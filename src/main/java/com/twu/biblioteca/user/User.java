package com.twu.biblioteca.user;

public class User {

    private String libNu;
    private String password;
    private UserInfo userInfo;

    public User(String libNu, String password, UserInfo userInfo) {
        this.libNu = libNu;
        this.password = password;
        this.userInfo = userInfo;
    }

    public String getLibNu() {
        return libNu;
    }

    public String getPassword() {
        return password;
    }

    public void printInfo() {
        userInfo.printContactDetails();
    }
}
