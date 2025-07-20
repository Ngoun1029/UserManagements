package com.example.usermanagement.data.model;

import java.util.ArrayList;
import java.util.List;

public class ListUserRes {
    ArrayList<User> data;

    public ListUserRes(ArrayList<User> data) {
        this.data = data;
    }

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }
}
