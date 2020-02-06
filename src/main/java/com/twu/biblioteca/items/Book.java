package com.twu.biblioteca.items;

public class Book extends ItemBasis implements Item {

    private static final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
    private static final String CHECKOUT_ERROR_MESSAGE = "Sorry, that book is not available";

    public Book(String title, String author, String publishedYear) {
        super(title, author, publishedYear);
    }

    @Override
    public String checkOut() {
        return changeStatusOfCheckOut() ? CHECKOUT_SUCCESS_MESSAGE : CHECKOUT_ERROR_MESSAGE;
    }
}
