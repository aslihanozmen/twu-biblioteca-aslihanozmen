package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.itemdirectory.MovieDirectory;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PrintSelectionTest {

    private BookDirectory bookDirectory;
    private MovieDirectory movieDirectory;
    private PrintSelection printSelection;
    private PrintSelection printSelectionMovie;

    @Before
    public void BeforeEach() {
        bookDirectory = mock(BookDirectory.class);
        movieDirectory = mock(MovieDirectory.class);
        printSelection = new PrintSelection(1, "selectionDescTest", bookDirectory);
        printSelectionMovie = new PrintSelection(4, "selectionDescTestMovie", movieDirectory);
    }

    @Test
    public void shouldExecuteSelectionOfBooks() {
        printSelection.execute();
        verify(bookDirectory, times(1)).printAllItems();
    }

    @Test
    public void shouldExecuteSelectionOfMovies() {
        printSelectionMovie.execute();
        verify(movieDirectory, times(1)).printAllItems();
    }

    @Test
    public void shouldGetDescOfSelectionOfBooks() {
        Assert.assertThat(printSelection.getDesc(), CoreMatchers.is("selectionDescTest"));
    }

    @Test
    public void shouldGetDescOfSelectionOfMovies() {
        Assert.assertThat(printSelectionMovie.getDesc(), CoreMatchers.is("selectionDescTestMovie"));
    }

    @Test
    public void shouldGetIdOfSelectionOfBook() {
        Assert.assertThat(printSelection.getId(), CoreMatchers.is(1));
    }

    @Test
    public void shouldGetIdOfSelectionOfMovie() {
        Assert.assertThat(printSelectionMovie.getId(), CoreMatchers.is(4));
    }
}