package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.BookDirectory;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAdministration;
import com.twu.biblioteca.user.UserInfo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class InfoSelectionTest {

    private InfoSelection infoSelection;
    private UserAdministration userAdministration;
    private User user;

    @Before
    public void beforeEach() {
        user = mock(User.class);
        userAdministration = mock(UserAdministration.class);
        infoSelection = new InfoSelection(2, "testDesc", userAdministration);
    }

    @Test
    public void getDescOfInfoSelection() {
        Assert.assertThat(infoSelection.getDesc(), CoreMatchers.is("testDesc"));
    }

    @Test
    public void shouldExecuteInfoOptionWhileCheckingAuthorizedUser() {
        when(userAdministration.getPresentUser()).thenReturn(user);
        infoSelection.execute();
        verify(userAdministration, times(1)).getUserIfAuthorized();
    }

    @Test
    public void shouldExecuteInfoOptionWithPrintingUserInfo() {
        when(userAdministration.getUserIfAuthorized()).thenReturn(user);
        infoSelection.execute();
        verify(user, times(1)).printInfo();
    }

    @Test
    public void shouldGetIdInfoSelection() {
        Assert.assertThat(infoSelection.getId(), CoreMatchers.is(2));
    }
}