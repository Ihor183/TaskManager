package com.tern.test.taskmanager.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String email;
    private String name;
    private UserRole userRole;
    private String password;
    private List<Task> tasks;
    private List<DeletedTask> deletedTasks;
    private List<SentTask> sentTasks;
    private List<IncomingTask> incomingTasks;

    public User() {
        this.tasks = new ArrayList<>();
        this.deletedTasks = new ArrayList<>();
        this.sentTasks = new ArrayList<>();
        this.incomingTasks = new ArrayList<>();
    }

    public User(String email, String name, UserRole userRole, String password,
                List<Task> tasks, List<DeletedTask> deletedTasks,
                List<SentTask> sentTasks, List<IncomingTask> incomingTasks) {
        this.email = email;
        this.name = name;
        this.userRole = userRole;
        this.password = password;
        this.tasks = tasks;
        this.deletedTasks = deletedTasks;
        this.sentTasks = sentTasks;
        this.incomingTasks = incomingTasks;
    }

    public User(String id, String email, String name, UserRole userRole, String password,
                List<Task> tasks, List<DeletedTask> deletedTasks,
                List<SentTask> sentTasks, List<IncomingTask> incomingTasks) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.userRole = userRole;
        this.password = password;
        this.tasks = tasks;
        this.deletedTasks = deletedTasks;
        this.sentTasks = sentTasks;
        this.incomingTasks = incomingTasks;
    }

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
        this.userRole = user.userRole;
        this.password = user.password;
        this.tasks = user.tasks;
        this.deletedTasks = user.deletedTasks;
        this.sentTasks = user.sentTasks;
        this.incomingTasks = user.incomingTasks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<DeletedTask> getDeletedTasks() {
        return deletedTasks;
    }

    public void setDeletedTasks(List<DeletedTask> deletedTasks) {
        this.deletedTasks = deletedTasks;
    }

    public List<SentTask> getSentTasks() {
        return sentTasks;
    }

    public void setSentTasks(List<SentTask> sentTasks) {
        this.sentTasks = sentTasks;
    }

    public List<IncomingTask> getIncomingTasks() {
        return incomingTasks;
    }

    public void setIncomingTasks(List<IncomingTask> incomingTasks) {
        this.incomingTasks = incomingTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) &&
                name.equals(user.name) &&
                userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
