package com.twu.biblioteca;

public class LibraryFactory {

    public static BibliotecaLibrary buildLibrary() {
        Book book1 = new Book(1,"Inferno", "Dan Brown","2013");
        Book book2 = new Book(2,"Anne Frank's Diary","Anne Frank","1947");

        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.addBook(book1);
        bibliotecaLibrary.addBook(book2);

        return bibliotecaLibrary;
    }
}
