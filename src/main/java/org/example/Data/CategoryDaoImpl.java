package org.example.Data;

import org.example.Data.Exceptions.CategoryNotFoundException;
import org.example.Objects.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao {

    Connection connection;

    public CategoryDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Category getCategory(int id) throws CategoryNotFoundException {
        String sql = "select * category where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet authors = preparedStatement.executeQuery();

            id = authors.getInt("id");
            String firstName = authors.getString("category");

            return (new Category(id, firstName));
        } catch (SQLException e) {
            throw new CategoryNotFoundException();
        }
    }
}
