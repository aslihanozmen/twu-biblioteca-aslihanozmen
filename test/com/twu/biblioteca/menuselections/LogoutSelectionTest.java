package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.user.UserAdministration;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LogoutSelectionTest {

    private LogoutSelection logoutSelection;
    private UserAdministration userAdministration;

    @Before
    public void beforeEach() {
        userAdministration = mock(UserAdministration.class);
        logoutSelection = new LogoutSelection(2, "testDesc", userAdministration);
    }


    @Test
    public void getDescOfCheckoutSelection() {
        Assert.assertThat(logoutSelection.getDesc(), CoreMatchers.is("testDesc"));
    }

    @Test
    public void shouldExecuteCheckOutOption() {
        logoutSelection.execute();
        verify(userAdministration, times(1)).logoutUser();
    }

    @Test
    public void shouldGetIdCheckOutSelection() {
        Assert.assertThat(logoutSelection.getId(), CoreMatchers.is(2));
    }
}