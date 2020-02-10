package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;
import de.vandermeer.asciitable.AsciiTable;

public abstract class ItemBasis implements Item {

    private String title;

    private String author;

    private String publishedYear;

    private User owner;

    private boolean status;

    public ItemBasis(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        status = false;
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
    public boolean isCheckedOut() {
        return status;
    }

    @Override
    public boolean isEqualTo(Item i) {
        return title.equalsIgnoreCase(i.getTitle()) && author.equalsIgnoreCase(i.getAuthor()) && publishedYear.equalsIgnoreCase(i.getPublishedYear());
    }

    @Override
    public void printItem(AsciiTable asciiTable) {
        asciiTable.addRow(title, author, publishedYear);
        asciiTable.addRule();
    }

    protected boolean changeStatusOfCheckOut(User user) {
        if (this.status) {
            return false;
        }
        owner = user;
        this.status = true;
        return true;
    }

    protected boolean changeStatusOfReturnBack(User user) {
        if (this.status && owner.equals(user)) {
            owner = null;
            this.status = false;
            return true;
        }
        return false;
    }


}
