package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class UserAdministrationTest {

    private User user;
    private User user1;
    private UserAdministration userAdministration;

    @Rule
    public final TextFromStandardInputStream textFromStandardInputStream = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();

    @Before
    public void beforeEach() {
        user = new User("123-4567", "password");
        user1 = new User("890-1234", "test");
        List<User> users = new ArrayList<>(Arrays.asList(user, user1));
        userAdministration = new UserAdministration(users);
    }


    @Test
    public void shouldgetPresentUser() {
        textFromStandardInputStream.provideLines("123-4567", "password");
        userAdministration.authorizeUser();
        assertThat(user, is(userAdministration.getPresentUser()));
    }


    @Test
    public void shouldAuthorizePresentUser() {
        textFromStandardInputStream.provideLines("123-4567", "password");
        userAdministration.authorizeUser();
        assertThat(userAdministration.isUserLoggedIn(), is(true));
    }

    @Test
    public void shouldPrintSuccessMessageIfAuthorizationIsSuccessful() {
        textFromStandardInputStream.provideLines("123-4567", "password");
        userAdministration.authorizeUser();
        assertThat(systemOutRule.getLog(), containsString("You are authorized and successfully logged in."));
    }

    @Test
    public void shouldPrintErrorMessageIfAuthorizationIsNotSuccessful() {
        textFromStandardInputStream.provideLines("123-56", "password");
        userAdministration.authorizeUser();
        assertThat(systemErrRule.getLog(), containsString("You are not authorized."));
    }

    @Test
    public void shouldPrintAlreadyLoggedInMessageIfUserIsAlreadyLoggedIn() {
        textFromStandardInputStream.provideLines("123-4567", "password");
        userAdministration.authorizeUser();
        userAdministration.authorizeUser();
        assertThat(systemOutRule.getLog(), containsString("You are already authorized and logged in to the system."));
    }

    @Test
    public void shouldLogoutIfUserChooses() {
        textFromStandardInputStream.provideLines("123-4567", "password");
        userAdministration.authorizeUser();
        userAdministration.logoutUser();
        assertThat(userAdministration.getPresentUser(), is(nullValue()));
        assertThat(userAdministration.isUserLoggedIn(), is(false));
    }

    @Test
    public void shouldPrintSuccessMessageIfUserLogsOut() {
        textFromStandardInputStream.provideLines("123-4567", "password");
        userAdministration.authorizeUser();
        userAdministration.logoutUser();
        assertThat(systemOutRule.getLog(), containsString("You are now logged out."));
    }

    @Test
    public void shouldPrintErrorMessageIfUsersLogOutIsNotSuccessful() {
        userAdministration.logoutUser();
        assertThat(systemOutRule.getLog(), containsString("You are not logged in."));
    }

}