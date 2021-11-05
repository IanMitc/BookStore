package org.example.Data;

import org.example.Data.Exceptions.BookNotFoundException;
import org.example.Data.Exceptions.NoBooksException;
import org.example.Objects.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBooks() throws NoBooksException;

    Book getBook(String isbn) throws BookNotFoundException;

    List<Book> getBooksByCategory(int category) throws NoBooksException;
}
