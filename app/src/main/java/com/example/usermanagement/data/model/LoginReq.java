package com.example.usermanagement.data.model;

public class LoginReq {
    String email;
    String password;

    public LoginReq(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
