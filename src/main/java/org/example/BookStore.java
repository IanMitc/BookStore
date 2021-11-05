package org.example;

import org.example.Data.Database;
import org.example.UI.Menus.MainMenu;

/**
 * Hello world!
 */
public class BookStore {
    public static void main(String[] args) {
        Database.initialize();
        MainMenu.show();
    }
}
