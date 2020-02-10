package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.user.User;

import java.util.List;

public class MovieDirectory extends ItemDirectoryBasis implements ItemDirectory {

    private static final String MOVIE_TITLE = "Enter movie title: ";
    private static final String MOVIE_DIRECTOR = "Enter movie director: ";
    private static final String MOVIE_RELEASE_YEAR = "Enter movie release year: ";

    public MovieDirectory(List<Item> allItems) {
        super(allItems);
    }


    @Override
    public void checkOut(User user) {
        printMessage(checkoutItem(getMovieAsInput(), user));
    }

    @Override
    public void returnBack(User user) {
        printMessage(returnItemBack(getMovieAsInput(), user));
    }

    private Movie getMovieAsInput() {
        return new Movie(ScannerWrapper.askUserForInput(MOVIE_TITLE), ScannerWrapper.askUserForInput(MOVIE_DIRECTOR), ScannerWrapper.askUserForInput(MOVIE_RELEASE_YEAR));
    }
}
