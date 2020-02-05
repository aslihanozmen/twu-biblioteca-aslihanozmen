package com.twu.biblioteca.commandline;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ScannerWrapper {

    private final Scanner scanner;
    private final PrintStream out;

    public ScannerWrapper(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public String askUserForInput(String message) {
        out.println(message);
        return scanner.next();
    }

    public int getInput( int min, int max) {
        String choice = askUserForInput("Enter Choice: \n");
        int choiceInt = Integer.parseInt(choice);
        if ((!choice.matches(".*[a-zA-Z]+.*")) && (choiceInt > min && choiceInt < max)) {
            return choiceInt;
        }
        return 0;
    }
}
