package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class ItemDirectoryBasisTest {

    private Book book;
    private Book book1;
    private BookDirectory bookDirectory;

    @Before
    public void beforeEach() {
         book = new Book("Inferno", "Dan Brown", "2013" );
         book1 = new Book("Harry Potter", "J.K Rowling", "1999" );
         book.checkOut();
         List<Item> itemList = new ArrayList<>(Arrays.asList(book,book1));
         bookDirectory = new BookDirectory(itemList);

    }

    @Test
    public void shouldPrintOnlyAvailableBooks() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        bookDirectory.printAllItems();
        assertThat(outputContent.toString(), not(containsString(book.getAuthor())));
        assertThat(outputContent.toString(), containsString(book1.getAuthor()));


    }
}