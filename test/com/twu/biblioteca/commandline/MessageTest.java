package com.twu.biblioteca.commandline;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;

public class MessageTest {

    @Test
    public void shouldPrintMenu() {
        String welcomeMessage = "Welcome";
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        Message.printMenu(System.out);
        Assert.assertThat(outputContent.toString(), containsString(welcomeMessage));
    }

}