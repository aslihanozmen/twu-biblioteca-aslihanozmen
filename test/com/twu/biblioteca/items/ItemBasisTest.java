package com.twu.biblioteca.items;

import de.vandermeer.asciitable.AsciiTable;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class ItemBasisTest {

    private Book book;

    @Before
    public void beforeEach() {
        book = new Book("TitleTest", "AuthorTest", "1234");
    }

    @Test
    public void shouldGetTitleOfBook() {
        assertThat(book.getTitle(), is("TitleTest"));
    }

    @Test
    public void getAuthor() {
        assertThat(book.getAuthor(), is("AuthorTest"));
    }

    @Test
    public void getPublishedYear() {
        assertThat(book.getPublishedYear(), is("1234"));
    }

    @Test
    public void shouldPrintItem() {
        AsciiTable asciiTable = new AsciiTable();
        book.printItem(asciiTable);
        assertThat(asciiTable.render(), containsString(book.getAuthor()));
    }
}