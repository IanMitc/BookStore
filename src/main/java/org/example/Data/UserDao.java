package org.example.Data;

import org.example.Data.Exceptions.DuplicateUserException;
import org.example.Data.Exceptions.UserNotFoundException;
import org.example.Objects.User;

public interface UserDao {

    void addUser(String username, String password) throws DuplicateUserException, DuplicateUserException;

    User getUser(String username) throws UserNotFoundException;

}
