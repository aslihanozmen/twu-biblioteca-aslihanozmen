package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserTest {

    private User user;

    @Before
    public void beforeEach() {
        user = new User("000-0000", "pw");
    }

    @Test
    public void shouldGetLibraryNumber() {
        assertThat(user.getLibNu(), is("000-0000"));
    }

    @Test
    public void shouldGetPassword() {
        assertThat(user.getPassword(), is("pw"));
    }
}
