package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;
import de.vandermeer.asciitable.AsciiTable;

public interface Item {

    void printItem(AsciiTable asciiTable);

    String getTitle();

    String getAuthor();

    String getPublishedYear();

    boolean isCheckedOut();

    boolean isEqualTo(Item item);

    String checkOut(User user);

    String returnBackToLibrary(User user);

}
