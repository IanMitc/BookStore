package org.example;

import java.util.List;

public interface BookDao {

    List<Book> getBooks() throws NoBooksException;

    Book getBook(String isbn);
}
