package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;
import de.vandermeer.asciitable.AsciiTable;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

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

    @Test
    public void shouldChangeBookStatusIfIsCheckedOut() {
        User user = mock(User.class);
        movie.checkOut(user);
        assertThat(movie.isCheckedOut(), is(true));
    }

    @Test
    public void shouldReturnTrueIfMoviesAreSame() {
        Movie sameMovie = new Movie("TitleTest", "DirectorTest", "1234");
        assertThat(movie.isEqualTo(sameMovie), is(true));
    }

    @Test
    public void shouldReturnFalseIfBooksAreDifferent() {
        Movie differentMovie = new Movie("TitleTest12", "AuthorTest3", "1234");
        assertThat(movie.isEqualTo(differentMovie), is(false));
    }

    @Test
    public void shouldChangeBookStatusIfIsReturned() {
        User user = mock(User.class);
        movie.checkOut(user);
        movie.returnBackToLibrary(user);
        assertThat(movie.isCheckedOut(), is(false));
    }

    @Test
    public void shouldPrintSuccessCheckoutMessageIfBookIsSuccessfullyCheckedOut() {
        User user = mock(User.class);
        assertThat(movie.checkOut(user), is("Thank you! Enjoy the movie"));
    }

    @Test
    public void shouldPrintErrorCheckoutMessageIfBookIsAlreadyCheckedOut() {
        User user = mock(User.class);
        movie.checkOut(user);
        assertThat(movie.checkOut(user), is("Sorry, that movie is not available"));
    }

    @Test
    public void shouldPrintSuccessMessageIfValidBookIsReturned() {
        User user = mock(User.class);
        movie.checkOut(user);
        assertThat(movie.returnBackToLibrary(user), is(containsString("Thank you for returning the movie")));
    }

    @Test
    public void shouldPrintErrorMessageIfInvalidBookIsReturned() {
        User user = mock(User.class);
        assertThat(movie.returnBackToLibrary(user), is(containsString("That is not a valid movie to return")));
    }
}