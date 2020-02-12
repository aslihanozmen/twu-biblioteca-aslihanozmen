package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAdministration;
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
    private UserAdministration userAdministration;


    @Rule
    public final ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @Before
    public void beforeEach() {
        bookDirectory = mock(BookDirectory.class);
        userAdministration = mock(UserAdministration.class);
        returnBackSelection = new ReturnBackSelection(3, "Return a book", bookDirectory, userAdministration);
    }

    @Test
    public void shouldExecuteReturnBackOption() {
        User user = mock(User.class);
        when(userAdministration.getUserIfAuthorized()).thenReturn(user);
        returnBackSelection.execute();
        verify(bookDirectory, times(1)).returnBack(user);
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