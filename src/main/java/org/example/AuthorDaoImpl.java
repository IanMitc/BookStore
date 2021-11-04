package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao{

    Connection connection;

    @Override
    public List<Author> getAuthor(Book book) throws AuthorNotFoundException {
        String sql = "select * from author where Id = ?";
        List<Author> list = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getISBN());
            ResultSet authors = preparedStatement.executeQuery();
            while (authors.next()) {
                int id = authors.getInt("id");
                String firstName = authors.getString("FirstName");
                String lastName = authors.getString("LastName");

                list.add(new Author(id, firstName, lastName));
            }
            return list;
        } catch(SQLException e) {
            throw new AuthorNotFoundException();
        }
    }

}

