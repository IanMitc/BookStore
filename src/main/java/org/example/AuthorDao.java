package org.example;

import java.util.List;

public interface AuthorDao {

    public Author getAuthor(int id) throws AuthorNotFoundException;

}
