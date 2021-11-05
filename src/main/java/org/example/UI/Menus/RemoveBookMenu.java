package org.example.UI.Menus;

import org.example.Objects.Book;
import org.example.Objects.ShoppingCart;
import org.example.UI.Menus.Options.RemoveOption;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

import java.util.List;

public class RemoveBookMenu {
    public static void show() {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();
        List<Book> books = shoppingCart.getBooks();

        Clear.console();
        boolean run = true;
        while (run) {
            int i = 1;
            for (Book book : books) {
                System.out.println(i++ + ".\n" + book.getTitle());
            }
            System.out.println("0 - Cancel");

            int selection;
            try {
                selection = Ask.forInt("Select a book to remove");
            } catch (Exception e) {
                Clear.console();
                System.out.println(e.getMessage());
                continue;
            }

            if (selection == 0) {
                Clear.console();
                run = false;
            }

            if (selection <= books.size() && selection > 0) {
                RemoveOption.execute(books.get(selection - 1));
                Clear.console();
                run = false;
            } else {
                Clear.console();
                System.out.println("Please make a valid Selection");
            }
        }
    }
}
