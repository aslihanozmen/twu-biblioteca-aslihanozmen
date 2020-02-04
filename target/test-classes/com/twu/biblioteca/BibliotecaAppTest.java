package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest {

    private  ByteArrayOutputStream outputContent;


    @Before
    public void setUp() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        BibliotecaApp.main(new String[]{});
    }


    @Test
    public void testWelcomeMessage() {
        Assert.assertThat(outputContent.toString(), containsString("Welcome"));
    }
}
