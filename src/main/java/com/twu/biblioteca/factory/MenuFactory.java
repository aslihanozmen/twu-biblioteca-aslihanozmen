package com.twu.biblioteca.factory;

import com.twu.biblioteca.Menu;
import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.itemdirectory.MovieDirectory;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.menuselections.*;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {


    public static Menu buildMenuList() {
        return new Menu(populateMenuItems());
    }

    private static List<MenuItem> populateMenuItems() {
        BookDirectory bookDirectory = new BookDirectory(populateListOfBooks());
        MovieDirectory movieDirectory = new MovieDirectory(populateListOfMovies());
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new PrintSelection(1, "Show All Books", bookDirectory));
        menuItemList.add(new CheckOutSelection(2, "Check out a book", bookDirectory));
        menuItemList.add(new ReturnBackSelection(3, "Return a book", bookDirectory));
        menuItemList.add(new PrintSelection(4, "Show All Movies", movieDirectory));
        menuItemList.add(new CheckOutSelection(5, "Checkout a movie", movieDirectory));
        menuItemList.add(new ReturnBackSelection(6, "Return a movie", movieDirectory));
        menuItemList.add(new QuitSelection(0, "Quit Application"));
        return menuItemList;
    }


    private static List<Item> populateListOfBooks() {
        List<Item> books = new ArrayList<>();
        books.add(new Book("Inferno", "Dan Brown", "2013"));
        books.add(new Book("Anne Frank's Diary", "Anne Frank", "1947"));
        return books;
    }

    private static List<Item> populateListOfMovies() {
        List<Item> movies = new ArrayList<>();
        movies.add(new Movie("Schindler's List ", "Steven Spielberg", "1993", "8.9"));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", "2008", "9"));
        movies.add(new Movie("Pulp Fiction", " Quentin Tarantino", "1994"));
        return movies;
    }
}
