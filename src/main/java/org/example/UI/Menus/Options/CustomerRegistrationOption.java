package org.example.UI.Menus.Options;

import org.example.Data.DaoFactory;
import org.example.Data.Exceptions.DuplicateUserException;
import org.example.Data.UserDao;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class CustomerRegistrationOption {
    public static void execute() {
        Clear.console();

        String username = Ask.forString("Pick a username");
        String password = Ask.forString("Enter Password");

        UserDao userDao = DaoFactory.getUserDao();
        try {
            userDao.addUser(username, password);
        } catch (DuplicateUserException e) {
            System.out.println("User already exists");
        }

        Clear.console();
        System.out.println("Account Created, Please Login");
    }
}
