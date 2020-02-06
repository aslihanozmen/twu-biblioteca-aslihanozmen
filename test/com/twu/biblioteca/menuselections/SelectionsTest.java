package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SelectionsTest {

    private BookDirectory bookDirectory;
    private Selections selections;

    @Before
    public void BeforeEach(){
        bookDirectory = mock(BookDirectory.class);
        selections = new Selections(1, "selectionDescTest",bookDirectory);
    }

    @Test
    public void shouldExecuteSelection() {
        selections.execute();
        verify(bookDirectory, times(1)).printAllItems();
    }

    @Test
    public void shouldGetDescOfSelection() {
        Assert.assertThat(selections.getDesc(), CoreMatchers.is("selectionDescTest"));
    }

    @Test
    public void shouldGetIdOfSelection() {
        Assert.assertThat(selections.getId(), CoreMatchers.is(1));
    }
}