package com.twu.biblioteca.commandline;

import java.util.Scanner;

public class ScannerWrapper {

    public static String askUserForInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
