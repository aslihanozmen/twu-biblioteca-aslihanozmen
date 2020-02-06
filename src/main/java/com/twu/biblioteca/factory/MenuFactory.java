package com.twu.biblioteca.factory;

import com.twu.biblioteca.Menu;
import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.menuselections.MenuItem;
import com.twu.biblioteca.menuselections.Selections;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {


    public static Menu buildMenuList() {
        return new Menu(populateMenuItems());
    }

    private static List<MenuItem> populateMenuItems() {
        BookDirectory bookDirectory = new BookDirectory(populateListOfBooks());
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new Selections(1, "Show All Books", bookDirectory));
        return menuItemList;
    }


    private static List<Item> populateListOfBooks() {
        List<Item> books = new ArrayList<>();
        books.add(new Book("Inferno", "Dan Brown","2013"));
        books.add(new Book("Anne Frank's Diary", "Anne Frank","1947"));
        return books;
    }
}
