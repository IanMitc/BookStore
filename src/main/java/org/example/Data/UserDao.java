package org.example.Data;

public interface UserDao {

    void addUser(String username, String password);

    boolean verifyUser(String username, String password);

}
