package com.twu.biblioteca.user;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class UserInfoTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void printContactDetails() {
        String name = "firstname lastname";
        String email = "f.l@gmail.com";
        String phoneNumber = "1234567890";
        UserInfo userInfo = new UserInfo(name, email, phoneNumber);
        userInfo.printContactDetails();
        assertThat(systemOutRule.getLog(), containsString(name));
        assertThat(systemOutRule.getLog(), containsString(email));
        assertThat(systemOutRule.getLog(), containsString(phoneNumber));
    }
}