package org.example.UI.Menus.Options;

import org.example.Data.DaoFactory;
import org.example.Data.Exceptions.UserNotFoundException;
import org.example.Data.UserDao;
import org.example.Objects.User;
import org.example.UI.Menus.CustomerMenu;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class LoginOption {
    public static void execute() {
        Clear.console();

        System.out.println("Please Login");
        String username = Ask.forString("Username");
        String password = Ask.forString("Password");

        UserDao userDao = DaoFactory.getUserDao();
        boolean loginSuccessful;
        try {
            User user = userDao.getUser(username);
            loginSuccessful = user.checkPassword(password);
        } catch (UserNotFoundException e) {
            System.out.println("User Does Not Exist");
            loginSuccessful = false;
        }


        if (loginSuccessful) {
            System.out.println("Logged In");
            CustomerMenu.show();
        } else {
            System.out.println("Login Failed");
        }
    }
}

