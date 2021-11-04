package org.example.Data;

import java.sql.SQLException;

public interface UserDao {

    void addUser(String username, String password) throws DuplicateUserException;

    User getUser(String username) throws UserNotFoundException;

}
