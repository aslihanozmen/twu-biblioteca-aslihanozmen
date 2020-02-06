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
        String inputTitle = ScannerWrapper.askUserForInput("Enter Title: ");
        String inputAuthor = ScannerWrapper.askUserForInput("Enter Author: ");
        String inputPublishedYear = ScannerWrapper.askUserForInput("Enter Published Year: ");
        Book book = new Book(inputTitle, inputAuthor, inputPublishedYear);
        String message = checkoutItem(book);
        if(message != null) {
            System.out.println(message);
        }
    }
}
