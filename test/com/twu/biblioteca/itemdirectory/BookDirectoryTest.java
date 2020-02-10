package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BookDirectoryTest {

    private Book book;
    private Book book1;
    private BookDirectory bookDirectory;

    @Rule
    public final TextFromStandardInputStream textFromStandardInputStream = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        book = new Book("Inferno", "Dan Brown", "2013");
        book1 = new Book("Harry Potter", "J.K Rowling", "1999");
        book.checkOut();
        List<Item> itemList = new ArrayList<>(Arrays.asList(book, book1));
        bookDirectory = new BookDirectory(itemList);

    }

    @Test
    public void shouldPrintOnlyAvailableBooks() {
        bookDirectory.printAllItems();
        assertThat(systemOutRule.getLog(), containsString(book1.getAuthor()));
        assertThat(systemOutRule.getLog(), not(containsString(book.getAuthor())));

    }

    @Test
    public void shouldPrintSuccessMessageOfSuccessfulCheckOut() {
        textFromStandardInputStream.provideLines(book1.getTitle(), book1.getAuthor(), book1.getPublishedYear());
        bookDirectory.checkOut();
        assertThat(systemOutRule.getLog(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldPrintNotAvailableMessageIfBookIsAlreadyCheckedOut() {
        textFromStandardInputStream.provideLines(book.getTitle(), book.getAuthor(), book.getPublishedYear());
        bookDirectory.checkOut();
        assertThat(systemOutRule.getLog(), containsString("Sorry, that book is not available"));
    }

    @Test
    public void shouldPrintNotExistMessageIfUserTryToCheckOutNoExistBookInLibrary() {
        textFromStandardInputStream.provideLines("book.getTitle()", "book.getAuthor()", "book.getPublishedYear()");
        bookDirectory.checkOut();
        assertThat(systemOutRule.getLog(), containsString("That item does not exist."));
    }

    @Test
    public void shouldReturnItemBack() {
        textFromStandardInputStream.provideLines(book.getTitle(), book.getAuthor(), book.getPublishedYear());
        bookDirectory.returnBack();
        bookDirectory.printAllItems();
        assertThat(systemOutRule.getLog(), containsString(book.getAuthor()));
    }

    @Test
    public void shouldPrintSuccessMessageIfValidBookIsReturned() {
        textFromStandardInputStream.provideLines(book.getTitle(), book.getAuthor(), book.getPublishedYear());
        bookDirectory.returnBack();
        assertThat(systemOutRule.getLog(), containsString("Thank you for returning the book"));
    }

    @Test
    public void shouldPrintReturnErrorMessageIfBookWasntCheckedOut() {
        textFromStandardInputStream.provideLines(book1.getTitle(), book1.getAuthor(), book1.getPublishedYear());
        bookDirectory.returnBack();
        assertThat(systemOutRule.getLog(), containsString("That is not a valid book to return"));
    }

    @Test
    public void shouldPrintNotExistMessageIfUserTryToReturnNoExistBookInLibrary() {
        textFromStandardInputStream.provideLines("book.getTitle()", "book.getAuthor()", "book.getPublishedYear()");
        bookDirectory.returnBack();
        assertThat(systemOutRule.getLog(), containsString("That item does not exist."));
    }
}