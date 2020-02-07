package com.twu.biblioteca.items;

public class Book extends ItemBasis implements Item {

    private static final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
    private static final String CHECKOUT_ERROR_MESSAGE = "Sorry, that book is not available";
    private static final String RETURN_SUCCESS_MESSAGE = "Thank you for returning the book";
    private static final String RETURN_ERROR_MESSAGE = "That is not a valid book to return";

    public Book(String title, String author, String publishedYear) {
        super(title, author, publishedYear);
    }

    @Override
    public String checkOut() {
        return changeStatusOfCheckOut() ? CHECKOUT_SUCCESS_MESSAGE : CHECKOUT_ERROR_MESSAGE;
    }

    @Override
    public String returnBackToLibrary() {
        return changeStatusOfReturnBack() ? RETURN_SUCCESS_MESSAGE : RETURN_ERROR_MESSAGE;
    }
}
