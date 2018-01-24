package com.example.simplesqlite.DataModel;

/**
 * Created by WIN07 on 10/15/2017.
 */

public class LoginDataModel {

    private String username;
    private String password;


    public LoginDataModel() {
    }

    public LoginDataModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDataModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
