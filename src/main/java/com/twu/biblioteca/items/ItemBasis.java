package com.twu.biblioteca.items;

import de.vandermeer.asciitable.AsciiTable;

public class ItemBasis implements Item {

    private String title;

    private String author;

    private String publishedYear;

    public ItemBasis(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getPublishedYear() {
        return publishedYear;
    }

    @Override
    public void printItem(AsciiTable asciiTable) {
        asciiTable.addRow(title,author,publishedYear);
        asciiTable.addRule();
    }


}
