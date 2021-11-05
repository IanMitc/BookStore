package org.example.UI.Menus.Customer;

import org.example.Data.BookDao;
import org.example.Data.DaoFactory;
import org.example.Objects.Book;
import org.example.UI.Utility.Ask;

import java.util.List;

public class ShowFromCategoryMenu {
    public static void show(int category) {
        BookDao bookDao = DaoFactory.getBookDao();
        List<Book> books = bookDao.getBooks(category);

        boolean run = true;
        while (run) {
            int i = 1;
            for (Book book : books) {
                System.out.println(i++ + ".\n" + book);
            }
            int selection = 0;

            try {
                selection = Ask.forInt("Select a book for more information (99 to View Your Shopping Cart, 0 to Go Back)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> run = false;
                case 99 -> ShoppingCartMenu.show();
            }

            if (selection < books.size() && selection > 0) {
                BookDetailsMenu.show(books.get(selection - 1));
            } else {
                System.out.println("Please make a valid Selection");
            }
        }
    }
}