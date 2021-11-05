package org.example.UI.Menus;

import org.example.Objects.Book;
import org.example.Objects.ShoppingCart;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class BookDetailsMenu {
    public static void show(Book book) {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();

        boolean run = true;
        while (run) {

            System.out.println(book);

            System.out.println();
            System.out.println("0 - Go Back");
            System.out.println("1 - Add to Cart");
            System.out.println("99 - View Cart");

            int selection;
            try {
                selection = Ask.forInt("Select Option");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> run = false;
                case 1 -> {
                    shoppingCart.addBook(book);
                    Clear.console();
                    System.out.println("Book added to Cart");
                    run = false;
                }
                case 99 -> ShoppingCartMenu.show();
                default -> System.out.println("\nPlease make a valid selection.\n");
            }
        }
    }
}

