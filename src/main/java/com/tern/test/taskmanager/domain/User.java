package com.tern.test.taskmanager.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String email;
    private String name;
    private UserRole userRole;
    private String password;

    public User() {    }

    public User(String email, String name, UserRole userRole, String password) {
        this.email = email;
        this.name = name;
        this.userRole = userRole;
        this.password = password;
    }

    public User(String id, String email, String name, UserRole userRole, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.userRole = userRole;
        this.password = password;
    }

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
        this.userRole = user.userRole;
        this.password = user.password;
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
