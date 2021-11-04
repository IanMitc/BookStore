package org.example.Data;

import org.example.Objects.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBooks();

    Book getBook(String isbn);
}