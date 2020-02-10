package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;
import de.vandermeer.asciitable.AsciiTable;

public class Movie extends ItemBasis implements Item {

    private static final String CHECKOUT_SUCCESS_MESSAGE_MOVIE = "Thank you! Enjoy the movie";
    private static final String CHECKOUT_ERROR_MESSAGE_MOVIE = "Sorry, that movie is not available";
    private static final String RETURN_SUCCESS_MESSAGE_MOVIE = "Thank you for returning the movie";
    private static final String RETURN_ERROR_MESSAGE_MOVIE = "That is not a valid movie to return";


    private String rating;

    public Movie(String title, String author, String publishedYear, String rating) {
        super(title, author, publishedYear);
        this.rating = rating;
    }

    public Movie(String title, String author, String publishedYear) {
        super(title, author, publishedYear);
        this.rating = "";
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String checkOut(User user) {
        return changeStatusOfCheckOut(user) ? CHECKOUT_SUCCESS_MESSAGE_MOVIE : CHECKOUT_ERROR_MESSAGE_MOVIE;
    }

    @Override
    public String returnBackToLibrary(User user) {
        return changeStatusOfReturnBack(user) ? RETURN_SUCCESS_MESSAGE_MOVIE : RETURN_ERROR_MESSAGE_MOVIE;
    }

    @Override
    public void printItem(AsciiTable asciiTable) {
        asciiTable.addRow(getTitle(), getAuthor(), getPublishedYear(), rating);
        asciiTable.addRule();
    }
}


