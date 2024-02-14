package org.example.data;

import java.util.ArrayList;

public class User {

    private String login;
    private String password;
    private String name;
    private  UserType userType;
    private boolean online = false;
    private boolean isBlocked = false;

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    private String message;


    public ArrayList<String> messages = new ArrayList<>();

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public User(String login, String password, String name, UserType userType, boolean isBlocked) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.isBlocked = isBlocked;
    }
    public User() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isOnline() {
        return online;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
