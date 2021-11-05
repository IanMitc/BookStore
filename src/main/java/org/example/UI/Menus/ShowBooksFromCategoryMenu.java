package org.example.UI.Menus;

import org.example.Data.BookDao;
import org.example.Data.DaoFactory;
import org.example.Data.Exceptions.NoBooksException;
import org.example.Objects.Book;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

import java.util.ArrayList;
import java.util.List;

public class ShowBooksFromCategoryMenu {
    public static void show(int category) {
        BookDao bookDao = DaoFactory.getBookDao();
        List<Book> books;

        try {
            books = bookDao.getBooksByCategory(category);
        } catch (NoBooksException e) {
            //e.printStackTrace();
            books = new ArrayList<>();
        }

        boolean run = true;
        while (run) {
            int i = 1;
            for (Book book : books) {
                System.out.println(i++ + ".\n" + book);
            }
            System.out.println("0 - Go Back");
            System.out.println("99 - View Cart");

            int selection;
            try {
                selection = Ask.forInt("Select a book for more information");
            } catch (Exception e) {
                Clear.console();
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> {
                    Clear.console();
                    run = false;
                }
                case 99 -> ShoppingCartMenu.show();
            }

            if (selection <= books.size() && selection > 0) {
                BookDetailsMenu.show(books.get(selection - 1));
            } else {
                Clear.console();
                System.out.println("Please make a valid Selection");
            }
        }
    }
}