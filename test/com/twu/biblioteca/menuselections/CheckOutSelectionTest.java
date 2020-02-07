package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckOutSelectionTest {

    private CheckOutSelection checkOutSelection;
    private BookDirectory bookDirectory;

    @Before
    public void beforeEach() {
        bookDirectory = mock(BookDirectory.class);
        checkOutSelection = new CheckOutSelection(2, "testDesc", bookDirectory);
    }

    @Test
    public void getDescOfCheckoutSelection() {
        Assert.assertThat(checkOutSelection.getDesc(), CoreMatchers.is("testDesc"));
    }

    @Test
    public void shouldExecuteCheckOutOption() {
        checkOutSelection.execute();
        verify(bookDirectory, times(1)).checkOut();
    }

    @Test
    public void shouldGetIdCheckOutSelection() {
        Assert.assertThat(checkOutSelection.getId(), CoreMatchers.is(2));
    }
}