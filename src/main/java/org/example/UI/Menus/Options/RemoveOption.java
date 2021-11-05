package org.example.UI.Menus.Options;

import org.example.Objects.Book;
import org.example.Objects.ShoppingCart;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class RemoveOption {
    public static void execute(Book book) {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();
        Clear.console();
        System.out.println(book);
        boolean sure = false;

        boolean run = true;
        while (run) {
            try {
                sure = Ask.forBoolean("Are you sure you want to remove this book", 'y', 'n');
                run = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (sure) {
            shoppingCart.removeBook(book);
            Clear.console();
            System.out.println("Book Removed");
        }
    }
}
