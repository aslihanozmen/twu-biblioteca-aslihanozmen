package com.twu.biblioteca.commandline;

import java.io.PrintStream;

public class Message {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static void printMenu(PrintStream ps) {
        ps.println(WELCOME_MESSAGE);
        ps.println("-----------------------------------------------------------------------------");
        ps.println("Following actions are available: \n");
    }
}
