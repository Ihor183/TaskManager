package com.tern.test.taskmanager.controller;

import com.tern.test.taskmanager.domain.DeletedTask;
import com.tern.test.taskmanager.domain.Task;
import com.tern.test.taskmanager.domain.User;
import com.tern.test.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("registration");
        }

        if(userService.findUserByEmail(userForm.getEmail()) == null) {
            userService.save(userForm);

            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("registration");
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("Error", "Your data are invalid");
        }

        if(logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView welcome() {

        User user = findUser();
        ModelAndView map = new ModelAndView("home");

        map.addObject("tasks", user.getTasks().stream()
                .filter(t -> t.getCompleted().equals(false)
                        && t.getDeleted().equals(false))
                .collect(Collectors.toList()));
        return map;
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addTask(Task task) {
        System.out.println(task.getTask());

        User user = findUser();
        user.getTasks().add(task);
        userService.update(user);

        return "redirect:/home";
    }

    @RequestMapping(value = "/handleTask", method = RequestMethod.POST, params = "mark")
    public String markCompleted(@RequestParam("passIdInput") String id) {

        User user = findUser();
        user.getTasks().forEach(t -> {
            if(t.getId().equals(id))
                t.setCompleted(true);
        });

        userService.update(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/handleTask", method = RequestMethod.POST, params = "edit")
    public String editTask(@RequestParam("passIdEdit") String id, @RequestParam("editTaskId") String taskDescription) {

        User user = findUser();
        user.getTasks().stream().filter(t -> t.getId().equals(id)).findFirst().get().setTask(taskDescription);
        userService.update(user);

        System.out.println("Edit");
        return "redirect:/home";
    }

    @RequestMapping(value = "/handleTask", method = RequestMethod.POST, params = "delete")
    public String deleteTAsk(@RequestParam("passIdInput") String id) throws Exception {

        User user = findUser();
        Task task = user.getTasks().stream().filter(t -> t.getId().equals(id)).findFirst().orElseThrow(Exception::new);
        task.setDeleted(true);
        user.getTasks().removeIf(t -> t.getId().equals(id));

        user.getDeletedTasks().add(new DeletedTask(task));
        userService.update(user);


        System.out.println("Delete");
        return "redirect:/home";
    }

    private User findUser() {
        return userService.findUserByEmail(getEmail());
    }

    private String getEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
