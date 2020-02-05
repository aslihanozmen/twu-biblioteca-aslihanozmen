package com.twu.biblioteca.items;

import de.vandermeer.asciitable.AsciiTable;

public interface Item {

    void printItem(AsciiTable asciiTable);
    String getTitle();
    String getAuthor();
    String getPublishedYear();

}
