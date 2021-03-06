package org.example.UI.Menus;

import org.example.Objects.Book;
import org.example.Objects.ShoppingCart;
import org.example.UI.Menus.Options.CheckoutOption;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

import java.util.List;

public class ShoppingCartMenu {
    public static void show() {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();
        Clear.console();

        boolean run = true;
        while (run) {
            List<Book> books = shoppingCart.getBooks();

            for (Book book : books) {
                System.out.println(book);
            }
            System.out.printf("\t\t\t\tTotal:\n\t\t\t\t\t%.2f\n", shoppingCart.getTotal());
            System.out.println();
            System.out.println("0 - Continue Shopping");
            System.out.println("1 - Remove Book from Cart");
            System.out.println("2 - Remove All from Cart");
            System.out.println("3 - Checkout");

            int selection;
            try {
                selection = Ask.forInt("Select Option");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> run = false;
                case 1 -> RemoveBookMenu.show();
                case 2 -> shoppingCart.removeAll();
                case 3 -> CheckoutOption.execute();
                default -> System.out.println("\nPlease make a valid selection.\n");
            }
        }
    }
}



