package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


public class UserTest {

    private User user;
    private UserInfo userInfo;

    @Before
    public void beforeEach() {
        userInfo = mock(UserInfo.class);
        user = new User("000-0000", "pw", userInfo);
    }

    @Test
    public void shouldGetLibraryNumber() {
        assertThat(user.getLibNu(), is("000-0000"));
    }

    @Test
    public void shouldGetPassword() {
        assertThat(user.getPassword(), is("pw"));
    }

    @Test
    public void shouldPrintUserInfo() {
        user.printInfo();
        verify(userInfo, times(1)).printContactDetails();
    }
}
