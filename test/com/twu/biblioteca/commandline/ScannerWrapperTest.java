package com.twu.biblioteca.commandline;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.equalTo;

public class ScannerWrapperTest {


    private void setUp(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void shouldAskUserForInput() {
        String input = "1";
        setUp(input);
        Assert.assertThat(input, equalTo(ScannerWrapper.askUserForInput("Test")));
    }

}