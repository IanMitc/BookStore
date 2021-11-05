package org.example.Data;

import org.example.Data.Exceptions.UserNotFoundException;
import org.example.Data.Exceptions.DuplicateUserException;
import org.example.Objects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    Connection connection;

    public UserDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addUser(String username, String password) throws DuplicateUserException {
        try {
            String sql = "insert into user (username, password) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int count = preparedStatement.executeUpdate();
            if (count > 0)
                System.out.println("Account made");
            else
                System.out.println("Calamity! Something has gone awry!");
        } catch (SQLException e) {
            throw new DuplicateUserException();
        }
    }

    @Override
    public User getUser(String username) throws UserNotFoundException {
        String sql = "select * from user where username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet users = preparedStatement.executeQuery();
            users.next();
            int id = users.getInt("id");
            String username1 = users.getString("username");
            String password = users.getString("password");
            User user = new User(id, username1, password);

            return user;
        } catch (SQLException e) {
            throw new UserNotFoundException();
        }
    }
}
