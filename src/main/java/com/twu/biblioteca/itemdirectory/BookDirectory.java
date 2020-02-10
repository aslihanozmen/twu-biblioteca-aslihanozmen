package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;

import java.util.List;

public class BookDirectory extends ItemDirectoryBasis implements ItemDirectory {

    private static final String BOOK_TITLE = "Enter book title: ";
    private static final String BOOK_AUTHOR = "Enter book author: ";
    private static final String BOOK_PUBLISHED_YEAR = "Enter book published year: ";

    public BookDirectory(List<Item> allItems) {
        super(allItems);
    }

    @Override
    public void checkOut() {
        printMessage(checkoutItem(getBookAsInput()));
    }

    @Override
    public void returnBack() {
        printMessage(returnItemBack(getBookAsInput()));
    }

    private Book getBookAsInput() {
        return new Book(ScannerWrapper.askUserForInput(BOOK_TITLE), ScannerWrapper.askUserForInput(BOOK_AUTHOR), ScannerWrapper.askUserForInput(BOOK_PUBLISHED_YEAR));
    }
}
