package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class ReturnBackSelectionTest {

    private ReturnBackSelection returnBackSelection;
    private BookDirectory bookDirectory;


    @Rule
    public final ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @Before
    public void beforeEach() {
        bookDirectory = mock(BookDirectory.class);
        returnBackSelection = new ReturnBackSelection(3, "Return a book", bookDirectory);
    }

    @Test
    public void shouldExecuteReturnBackOption() {
        returnBackSelection.execute();
        verify(bookDirectory, times(1)).returnBack();
    }

    @Test
    public void shouldGetDescReturnBackSelection() {
        Assert.assertThat(returnBackSelection.getDesc(), CoreMatchers.is("Return a book"));
    }

    @Test
    public void shouldGetIdReturnBackSelection() {
        Assert.assertThat(returnBackSelection.getId(), CoreMatchers.is(3));
    }
}