package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return this.books;
    }


    public void addBook(Book book) {
        books.add(book);
    }

  public void printAllBooks(){
      System.out.println("Books are: \n");
      books.forEach(book -> {
          book.print();
          System.out.println("\n");
      });
  }

}
