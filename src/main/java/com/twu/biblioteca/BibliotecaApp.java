package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = LibraryFactory.buildLibrary();

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println("-----------------------------------------------------------------------------");

        library.printAllBooks();
    }
}
