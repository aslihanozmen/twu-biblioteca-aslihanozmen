package com.twu.biblioteca.items;

public class Book extends ItemBasis implements Item {

    private static final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";

    public Book(String title, String author, String publishedYear) {
        super(title, author, publishedYear);
    }

    @Override
    public String checkOut() {
        return changeStatusOfCheckOut() ? CHECKOUT_SUCCESS_MESSAGE : null;
    }
}
