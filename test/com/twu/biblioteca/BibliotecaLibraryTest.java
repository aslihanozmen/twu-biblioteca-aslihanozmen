package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.util.OptionalDouble.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BibliotecaLibraryTest {

    private BibliotecaLibrary bibliotecaLibrary;

    @Before
    public void setUp() {
        Book book = new Book(3, "Book3", "authorTest", "1234");
        bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.addBook(book);
    }


    @Test
    public void shouldAddBook() {
        assertThat(bibliotecaLibrary.getBooks(), is(not(empty())));
    }

    @Test
    public void shouldPrintAllBooks() {
        final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        bibliotecaLibrary.printAllBooks();
        assertThat(outputContent.toString(), containsString("Title"));
        assertThat(outputContent.toString(), containsString("Author"));
        assertThat(outputContent.toString(), containsString("PublishedYear"));
        assertThat(outputContent.toString(), containsString(bibliotecaLibrary.getBooks().get(0).getTitle()));
    }
}
