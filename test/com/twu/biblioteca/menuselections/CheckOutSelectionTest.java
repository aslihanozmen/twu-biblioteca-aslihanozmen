package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAdministration;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckOutSelectionTest {

    private CheckOutSelection checkOutSelection;
    private BookDirectory bookDirectory;
    private UserAdministration userAdministration;

    @Before
    public void beforeEach() {
        bookDirectory = mock(BookDirectory.class);
        userAdministration = mock(UserAdministration.class);
        checkOutSelection = new CheckOutSelection(2, "testDesc", bookDirectory, userAdministration);
    }

    @Test
    public void getDescOfCheckoutSelection() {
        Assert.assertThat(checkOutSelection.getDesc(), CoreMatchers.is("testDesc"));
    }

    @Test
    public void shouldExecuteCheckOutOption() {
        User user = mock(User.class);
        when(userAdministration.getUserIfAuthorized()).thenReturn(user);
        checkOutSelection.execute();
        verify(bookDirectory, times(1)).checkOut(user);
    }

    @Test
    public void shouldGetIdCheckOutSelection() {
        Assert.assertThat(checkOutSelection.getId(), CoreMatchers.is(2));
    }
}