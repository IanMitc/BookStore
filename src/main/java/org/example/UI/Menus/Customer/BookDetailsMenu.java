package org.example.UI.Menus.Customer;

import org.example.Objects.Book;
import org.example.Objects.ShoppingCart;
import org.example.UI.Utility.Ask;

public class BookDetailsMenu {
    public static void show(Book book) {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();

        boolean run = true;
        while (run) {

            System.out.println(book.getDetails());

            System.out.println();
            System.out.println("1 - Add to Cart");

            int selection;
            try {
                selection = Ask.forInt("Select Option (99 to View Your Shopping Cart, 0 to Go Back)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> run = false;
                case 1 -> {
                    shoppingCart.addBook(book);
                    run = false;
                }
                case 99 -> ShoppingCartMenu.show();
                default -> System.out.println("\nPlease make a valid selection.\n");
            }
        }
    }
}
}
