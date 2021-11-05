package org.example.Data;

import org.example.Data.Exceptions.AuthorNotFoundException;
import org.example.Objects.Author;

import java.util.List;

public interface AuthorDao {

    Author getAuthor(int id) throws AuthorNotFoundException;

    List<Author> getAuthor(String isbn);
}
