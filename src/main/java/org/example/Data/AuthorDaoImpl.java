package org.example.Data;

import org.example.Data.Exceptions.AuthorNotFoundException;
import org.example.Objects.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    Connection connection;

    public AuthorDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Author getAuthor(int id) throws AuthorNotFoundException {
        String sql = "select * from author where Id = ?";
        List<Author> list = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet authors = preparedStatement.executeQuery();

            id = authors.getInt("id");
            String firstName = authors.getString("FirstName");
            String lastName = authors.getString("LastName");

            return (new Author(id, firstName, lastName));
        } catch (SQLException e) {
            throw new AuthorNotFoundException();
        }
    }

}

