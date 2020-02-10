package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;

import java.util.List;

public class MovieDirectory extends ItemDirectoryBasis implements ItemDirectory {

    private static final String MOVIE_TITLE = "Enter movie title: ";
    private static final String MOVIE_DIRECTOR = "Enter movie director: ";
    private static final String MOVIE_RELEASE_YEAR = "Enter movie release year: ";

    public MovieDirectory(List<Item> allItems) {
        super(allItems);
    }


    @Override
    public void checkOut() {
        printMessage(checkoutItem(getMovieAsInput()));
    }

    @Override
    public void returnBack() {
        printMessage(returnItemBack(getMovieAsInput()));
    }

    private Movie getMovieAsInput() {
        return new Movie(ScannerWrapper.askUserForInput(MOVIE_TITLE), ScannerWrapper.askUserForInput(MOVIE_DIRECTOR), ScannerWrapper.askUserForInput(MOVIE_RELEASE_YEAR));
    }
}
