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

    @Test
    public void shouldReturnTrueIfBooksAreSame() {
        Book sameBook = new Book("TitleTest", "AuthorTest", "1234");
        assertThat(book.isEqualTo(sameBook), is(true));
    }

    @Test
    public void shouldReturnFalseIfBooksAreDifferent() {
        Book sameBook = new Book("TitleTest", "AuthorTest3", "1234");
        assertThat(book.isEqualTo(sameBook), is(false));
    }

    @Test
    public void shouldChangeBookStatusIfIsCheckedOut() {
        book.checkOut();
        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldChangeBookStatusIfIsReturned() {
        book.checkOut();
        book.returnBackToLibrary();
        assertThat(book.isCheckedOut(), is(false));
    }

    @Test
    public void shouldPrintSuccessCheckoutMessageIfBookIsSuccessfullyCheckedOut() {
        assertThat(book.checkOut(), is("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldPrintErrorCheckoutMessageIfBookIsAlreadyCheckedOut() {
        book.checkOut();
        assertThat(book.checkOut(), is("Sorry, that book is not available"));
    }

    @Test
    public void shouldPrintSuccessMessageIfValidBookIsReturned() {
        book.checkOut();
        assertThat(book.returnBackToLibrary(), is(containsString("Thank you for returning the book")));
    }

    @Test
    public void shouldPrintErrorMessageIfInvalidBookIsReturned() {
        assertThat(book.returnBackToLibrary(), is(containsString("That is not a valid book to return")));
    }
}