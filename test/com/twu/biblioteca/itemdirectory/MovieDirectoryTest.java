package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.mock;

public class MovieDirectoryTest {

    private Movie movie;
    private Movie movie1;
    private MovieDirectory movieDirectory;
    private User user;

    @Rule
    public final TextFromStandardInputStream textFromStandardInputStream = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        user = mock(User.class);
        movie = new Movie("The Dark Knight", "Christoph Nolan", "2008");
        movie1 = new Movie("Shindler's List", "Steven Spielberg", "1993");
        movie.checkOut(user);
        List<Item> itemList = new ArrayList<>(Arrays.asList(movie, movie1));
        movieDirectory = new MovieDirectory(itemList);

    }

    @Test
    public void shouldPrintOnlyAvailableMovies() {
        movieDirectory.printAllItems();
        assertThat(systemOutRule.getLog(), containsString(movie1.getAuthor()));
        assertThat(systemOutRule.getLog(), not(containsString(movie.getAuthor())));

    }

    @Test
    public void shouldPrintSuccessMessageOfSuccessfulCheckOut() {
        textFromStandardInputStream.provideLines(movie1.getTitle(), movie1.getAuthor(), movie1.getPublishedYear());
        movieDirectory.checkOut(user);
        assertThat(systemOutRule.getLog(), containsString("Thank you! Enjoy the movie"));
    }

    @Test
    public void shouldPrintNotAvailableMessageIfMovieIsAlreadyCheckedOut() {
        textFromStandardInputStream.provideLines(movie.getTitle(), movie.getAuthor(), movie.getPublishedYear());
        movieDirectory.checkOut(user);
        assertThat(systemOutRule.getLog(), containsString("Sorry, that movie is not available"));
    }

    @Test
    public void shouldPrintNotExistMessageIfUserTryToCheckOutNoExistMovieInLibrary() {
        textFromStandardInputStream.provideLines("Movie.getTitle()", "Movie.getAuthor()", "Movie.getPublishedYear()");
        movieDirectory.checkOut(user);
        assertThat(systemOutRule.getLog(), containsString("That item does not exist."));
    }

    @Test
    public void shouldReturnItemBack() {
        textFromStandardInputStream.provideLines(movie.getTitle(), movie.getAuthor(), movie.getPublishedYear());
        movieDirectory.returnBack(user);
        movieDirectory.printAllItems();
        assertThat(systemOutRule.getLog(), containsString(movie.getAuthor()));
    }

    @Test
    public void shouldPrintSuccessMessageIfValidMovieIsReturned() {
        textFromStandardInputStream.provideLines(movie.getTitle(), movie.getAuthor(), movie.getPublishedYear());
        movieDirectory.returnBack(user);
        assertThat(systemOutRule.getLog(), containsString("Thank you for returning the movie"));
    }

    @Test
    public void shouldPrintReturnErrorMessageIfMovieWasntCheckedOut() {
        textFromStandardInputStream.provideLines(movie1.getTitle(), movie1.getAuthor(), movie1.getPublishedYear());
        movieDirectory.returnBack(user);
        assertThat(systemOutRule.getLog(), containsString("That is not a valid movie to return"));
    }

    @Test
    public void shouldPrintNotExistMessageIfUserTryToReturnNoExistMovieInLibrary() {
        textFromStandardInputStream.provideLines("Movie.getTitle()", "Movie.getAuthor()", "Movie.getPublishedYear()");
        movieDirectory.returnBack(user);
        assertThat(systemOutRule.getLog(), containsString("That item does not exist."));
    }
}