package com.example.usermanagement.data.model;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String avatar;

    public User() {
        // Empty constructor required for Gson
    }

    public User(int id, String first_name, String last_name, String email, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.avatar = avatar;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getFullName() {
        return first_name + " " + last_name;
    }
}
