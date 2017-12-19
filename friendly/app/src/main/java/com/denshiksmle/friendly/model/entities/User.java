package com.denshiksmle.friendly.model.entities;

/**
 * Created by troll on 11.12.2017.
 */

public class User {

    private String uid;
    private String name;
    private String userName;
    private String password;

    public User(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public User(String uid, String name, String userName, String password) {
        this.uid = uid;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUid() {
        return uid;
    }
}
