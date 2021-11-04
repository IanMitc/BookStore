package org.example.UI.Menus.Customer.Options;

import org.example.Data.DaoFactory;
import org.example.Data.UserDao;
import org.example.Objects.User;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class CustomerRegistrationOption {
    public static void execute() {
        Clear.console();

        String username = Ask.forString("Pick a username");
        String password = Ask.forString("Enter Password");

        User user = new User(username, password);

        UserDao userDao = DaoFactory.getUserDao();
        userDao.addUser(user);

        Clear.console();
        System.out.println(user + "\nAccount Created, Please Login");
    }
}
