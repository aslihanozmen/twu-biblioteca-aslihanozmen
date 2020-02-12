package com.twu.biblioteca.factory;

import com.twu.biblioteca.Menu;
import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.itemdirectory.MovieDirectory;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.menuselections.*;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAdministration;
import com.twu.biblioteca.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {


    public static Menu buildMenuList() {
        return new Menu(populateMenuItems());
    }

    private static List<MenuItem> populateMenuItems() {
        UserAdministration userAdministration = new UserAdministration(populateListOfUsers());
        BookDirectory bookDirectory = new BookDirectory(populateListOfBooks());
        MovieDirectory movieDirectory = new MovieDirectory(populateListOfMovies());

        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new PrintSelection(1, "Show All Books", bookDirectory));
        menuItemList.add(new CheckOutSelection(2, "Check out a book", bookDirectory, userAdministration));
        menuItemList.add(new ReturnBackSelection(3, "Return a book", bookDirectory, userAdministration));
        menuItemList.add(new PrintSelection(4, "Show All Movies", movieDirectory));
        menuItemList.add(new CheckOutSelection(5, "Checkout a movie", movieDirectory, userAdministration));
        menuItemList.add(new ReturnBackSelection(6, "Return a movie", movieDirectory, userAdministration));
        menuItemList.add(new InfoSelection(7, "My Information", userAdministration));
        menuItemList.add(new LogoutSelection(8, "Log Out", userAdministration));
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

    private static List<User> populateListOfUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("111-1111", "psswd1", new UserInfo("Asli Ozmen", "asliozmen@gmail.com", "123456789")));
        users.add(new User("222-2222", "psswd2", new UserInfo("Elon Musk", "elonmusk@gmail.com", "223456789")));
        users.add(new User("333-3333", "psswd3", new UserInfo("Bill Gates", "billgates@gmail.com", "223456789")));
        return users;
    }
}
