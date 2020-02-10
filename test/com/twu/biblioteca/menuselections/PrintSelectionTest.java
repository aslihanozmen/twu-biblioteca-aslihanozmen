package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PrintSelectionTest {

    private BookDirectory bookDirectory;
    private PrintSelection printSelection;

    @Before
    public void BeforeEach() {
        bookDirectory = mock(BookDirectory.class);
        printSelection = new PrintSelection(1, "selectionDescTest", bookDirectory);
    }

    @Test
    public void shouldExecuteSelectionOfBooks() {
        printSelection.execute();
        verify(bookDirectory, times(1)).printAllItems();
    }

    @Test
    public void shouldGetDescOfSelectionOfBooks() {
        Assert.assertThat(printSelection.getDesc(), CoreMatchers.is("selectionDescTest"));
    }
}