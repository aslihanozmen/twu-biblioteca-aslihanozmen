package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;

import java.util.List;

public class BookDirectory extends ItemDirectoryBasis implements ItemDirectory {

    public BookDirectory(List<Item> allItems) {
        super(allItems);
    }

    @Override
    public void checkOut() {
        Book book = getBookAsInput();
        String message = checkoutItem(book);
        if (message != null) {
            System.out.println(message);
        }
    }

    @Override
    public void returnBack() {
        Book book = getBookAsInput();
        returnItemBack(book);
    }

    private Book getBookAsInput() {
        String inputTitle = ScannerWrapper.askUserForInput("Enter Title: ");
        String inputAuthor = ScannerWrapper.askUserForInput("Enter Author: ");
        String inputPublishedYear = ScannerWrapper.askUserForInput("Enter Published Year: ");
        return new Book(inputTitle, inputAuthor, inputPublishedYear);
    }
}
