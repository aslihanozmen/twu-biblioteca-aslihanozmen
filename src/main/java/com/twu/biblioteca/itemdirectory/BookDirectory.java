package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.user.User;

import java.util.List;

public class BookDirectory extends ItemDirectoryBasis implements ItemDirectory {

    private static final String BOOK_TITLE = "Enter book title: ";
    private static final String BOOK_AUTHOR = "Enter book author: ";
    private static final String BOOK_PUBLISHED_YEAR = "Enter book published year: ";

    public BookDirectory(List<Item> allItems) {
        super(allItems);
    }

    @Override
    public void checkOut(User user) {
        printMessage(checkoutItem(getBookAsInput(), user));
    }

    @Override
    public void returnBack(User user) {
        printMessage(returnItemBack(getBookAsInput(), user));
    }

    private Book getBookAsInput() {
        return new Book(ScannerWrapper.askUserForInput(BOOK_TITLE), ScannerWrapper.askUserForInput(BOOK_AUTHOR), ScannerWrapper.askUserForInput(BOOK_PUBLISHED_YEAR));
    }
}
