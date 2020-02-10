package com.twu.biblioteca.items;

import de.vandermeer.asciitable.AsciiTable;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class MovieTest {

    private Movie movie;

    @Before
    public void beforeEach() {
        movie = new Movie("TitleTest", "DirectorTest", "1234", "4.3");
    }

    @Test
    public void shouldGetTitleOfMovie() {
        assertThat(movie.getTitle(), is("TitleTest"));
    }

    @Test
    //TODO not happy with having author as director, fix it later
    public void shouldGetAuthorAsDirector() {
        assertThat(movie.getAuthor(), is("DirectorTest"));
    }

    @Test
    public void shouldGetPublishedYear() {
        assertThat(movie.getPublishedYear(), is("1234"));
    }

    @Test
    public void shouldGetRating() {
        assertThat(movie.getRating(), is("4.3"));
    }


    @Test
    public void shouldPrintMovie() {
        AsciiTable asciiTable = new AsciiTable();
        movie.printItem(asciiTable);
        assertThat(asciiTable.render(), containsString(movie.getAuthor()));
    }
}