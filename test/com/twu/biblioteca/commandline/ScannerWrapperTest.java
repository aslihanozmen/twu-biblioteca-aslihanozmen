package com.twu.biblioteca.commandline;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ScannerWrapperTest {

    @Rule
    public final TextFromStandardInputStream textFromStandardInputStream = emptyStandardInputStream();

    @Test
    public void shouldAskUserForInput() {
        textFromStandardInputStream.provideText("1");
        ScannerWrapper sw = new ScannerWrapper(System.in, System.out);
        Assert.assertThat("1", equalTo(sw.askUserForInput("Test")));
    }

    @Test
    public void shouldGetInput() {
        textFromStandardInputStream.provideText("1");
        ScannerWrapper sw = new ScannerWrapper(System.in, System.out);
        Assert.assertThat(1, equalTo(sw.getInput(0,2)));
    }
}