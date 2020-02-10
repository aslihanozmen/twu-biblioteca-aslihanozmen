package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;
import de.vandermeer.asciitable.AsciiTable;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BookTest {

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
    public void shouldGetAuthor() {
        assertThat(book.getAuthor(), is("AuthorTest"));
    }

    @Test
    public void shouldGetPublishedYear() {
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
        User user = mock(User.class);
        book.checkOut(user);
        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldChangeBookStatusIfIsReturned() {
        User user = mock(User.class);
        book.checkOut(user);
        book.returnBackToLibrary(user);
        assertThat(book.isCheckedOut(), is(false));
    }

    @Test
    public void shouldPrintSuccessCheckoutMessageIfBookIsSuccessfullyCheckedOut() {
        User user = mock(User.class);
        assertThat(book.checkOut(user), is("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldPrintErrorCheckoutMessageIfBookIsAlreadyCheckedOut() {
        User user = mock(User.class);
        book.checkOut(user);
        assertThat(book.checkOut(user), is("Sorry, that book is not available"));
    }

    @Test
    public void shouldPrintSuccessMessageIfValidBookIsReturned() {
        User user = mock(User.class);
        book.checkOut(user);
        assertThat(book.returnBackToLibrary(user), is(containsString("Thank you for returning the book")));
    }

    @Test
    public void shouldPrintErrorMessageIfInvalidBookIsReturned() {
        User user = mock(User.class);
        assertThat(book.returnBackToLibrary(user), is(containsString("That is not a valid book to return")));
    }
}