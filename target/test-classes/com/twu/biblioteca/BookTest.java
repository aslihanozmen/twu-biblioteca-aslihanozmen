package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BookTest {


    @Test
    public void testPrintBook() {
        Book book = new Book(4,"testBook4");
        final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        book.print();
        assertThat(outputContent.toString(), containsString("testBook4"));
    }
}