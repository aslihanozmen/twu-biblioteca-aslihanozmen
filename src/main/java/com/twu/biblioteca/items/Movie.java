package com.twu.biblioteca.items;

import de.vandermeer.asciitable.AsciiTable;

public class Movie extends ItemBasis implements Item {


    private String rating;

    public Movie(String title, String author, String publishedYear, String rating) {
        super(title, author, publishedYear);
        this.rating = rating;
    }

    public Movie(String title, String author, String publishedYear) {
        super(title, author, publishedYear);
        this.rating = "";
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String checkOut() {
        return null;
    }

    @Override
    public String returnBackToLibrary() {
        return null;
    }

    @Override
    public void printItem(AsciiTable asciiTable) {
        asciiTable.addRow(getTitle(), getAuthor(), getPublishedYear(), rating);
        asciiTable.addRule();
    }
}


