package com.twu.biblioteca.user;

import de.vandermeer.asciitable.AsciiTable;

public class UserInfo {

    private String name;
    private String email;
    private String phoneNumber;


    public UserInfo(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void printContactDetails() {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(name, email, phoneNumber);
        asciiTable.addRule();
        String render = asciiTable.render();
        System.out.println(render);
    }
}
