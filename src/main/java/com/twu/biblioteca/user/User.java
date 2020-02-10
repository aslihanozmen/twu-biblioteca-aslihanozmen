package com.twu.biblioteca.user;

public class User {

    private String libNu;
    private String password;

    public User(String libNu, String password) {
        this.libNu = libNu;
        this.password = password;
    }

    public String getLibNu() {
        return libNu;
    }

    public String getPassword() {
        return password;
    }
}
