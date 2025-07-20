package com.example.usermanagement.data.model;

import java.util.List;

public class UsersResponse {
    private int page;
    private int total;
    private List<User> data;

    public List<User> getData() { return data; }
}
