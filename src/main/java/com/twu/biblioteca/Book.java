package com.twu.biblioteca;

public class Book {

    private int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void print() {
        System.out.println(id + "\t\t\t" + title);
    }
}
