package com.nowweareowner.nowweareowner.impl;

public class User {
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long userId;
    private String name;
    private String lastName;
    private String secondName;

    public User(Long userId, String name, String lastName, String secondName) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.secondName = secondName;
    }
    public Long getUserId() {
        return userId;
    }
}
