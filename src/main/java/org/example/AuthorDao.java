package org.example;

import java.util.List;

public interface AuthorDao {

    List<Author> getAuthor(Book book) throws AuthorNotFoundException;

}
