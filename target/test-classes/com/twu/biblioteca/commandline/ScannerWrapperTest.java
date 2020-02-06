package com.twu.biblioteca.commandline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.equalTo;

public class ScannerWrapperTest {

    @Before
    public void BeforeEach() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
    }

    @Test
    public void shouldAskUserForInput() {
        ScannerWrapper sw = new ScannerWrapper(System.in, System.out);
        Assert.assertThat("1", equalTo(sw.askUserForInput("Test")));
    }

    @Test
    public void shouldGetInput() {
        ScannerWrapper sw = new ScannerWrapper(System.in, System.out);
        Assert.assertThat(1, equalTo(sw.getInput(0,2)));
    }
}