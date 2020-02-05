package com.twu.biblioteca;

import de.vandermeer.asciitable.AsciiTable;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLibrary {

    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return this.books;
    }


    public void addBook(Book book) {
        books.add(book);
    }

  public void printAllBooks(){
      System.out.println("Books: \n");
      AsciiTable asciiTable = new AsciiTable();
      asciiTable.addRule();
      asciiTable.addRow("Title","Author","PublishedYear");
      asciiTable.addRule();
      books.forEach(book -> {
          asciiTable.addRow(book.getTitle(),book.getAuthor(),book.getPublishedYear());
          asciiTable.addRule();
      });
      String render = asciiTable.render();
      System.out.println(render);
  }

}
