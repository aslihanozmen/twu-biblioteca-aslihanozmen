package com.twu.biblioteca.items;

public class Book extends ItemBasis implements Item {

    public Book(String title, String author, String publishedYear) {
        super(title, author, publishedYear);
    }

    @Override
    public void checkOut() {
        changeStatusOfCheckOut();
    }
}
