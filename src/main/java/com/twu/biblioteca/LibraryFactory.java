package com.twu.biblioteca;

public class LibraryFactory {

    public static Library buildLibrary() {
        Book book1 = new Book (1, "Book1");
        Book book2 = new Book (2, "Book2");

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        return library;
    }
}
