package org.example;

import org.example.Data.Exceptions.AuthorNotFoundException;
import org.example.Objects.Author;

public interface AuthorDao {

    public Author getAuthor(int id) throws AuthorNotFoundException;

}
