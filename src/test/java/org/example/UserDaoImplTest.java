package org.example;

import static org.junit.Assert.assertTrue;

import org.example.Data.DaoFactory;
import org.example.Data.UserDao;
import org.junit.Test;

public class UserDaoImplTest {

    @Test
    public void testUser() {
        //Arrange
        UserDao userDao = DaoFactory.getUserDao();

    }
}
