package com.tern.test.taskmanager.domain;

import java.util.Objects;

public class SentTask {
    private String id;
    private String task;
    private String userEmail;
    private String message;
    private Boolean isAccepted;

    public SentTask(String task, String userEmail, String message) {
        this.task = task;
        this.userEmail = userEmail;
        this.message = message;
    }

    public SentTask(String id, String task, String userEmail, String message, Boolean isAccepted) {
        this.id = id;
        this.task = task;
        this.userEmail = userEmail;
        this.message = message;
        this.isAccepted = isAccepted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentTask sentTask = (SentTask) o;
        return task.equals(sentTask.task) &&
                userEmail.equals(sentTask.userEmail) &&
                Objects.equals(message, sentTask.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, userEmail, message);
    }

    @Override
    public String toString() {
        return "SentTask{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", message='" + message + '\'' +
                ", isAccepted=" + isAccepted +
                '}';
    }
}
