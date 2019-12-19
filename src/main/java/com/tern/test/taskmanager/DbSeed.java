//package com.tern.test.taskmanager;
//
//import com.tern.test.taskmanager.domain.User;
//import com.tern.test.taskmanager.domain.UserRole;
//import com.tern.test.taskmanager.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DbSeed implements CommandLineRunner {
//
//    private UserRepository userRepository;
//
//    public DbSeed(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User(
//                "ihor183@gmail.com",
//                "Ihor",
//                UserRole.ROLE_ADMIN,
//                "$2a$10$ACnzRF9PuYm59FRnsTWequpjBg9Q2N4zeB2Daw.50fvNvDZ0p.z2S"
//        );
//
//        User user1 = new User(
//                "dima@gmail.com",
//                "Dima",
//                UserRole.ROLE_USER,
//                "$2a$10$ACnzRF9PuYm59FRnsTWequpjBg9Q2N4zeB2Daw.50fvNvDZ0p.z2S"
//        );
//
//        userRepository.deleteAll();
//
//        List<User> users = Arrays.asList(user, user1);
//        userRepository.saveAll(users);
//    }
//}
