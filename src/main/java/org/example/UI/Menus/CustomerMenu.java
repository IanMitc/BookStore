package org.example.UI.Menus;

import org.example.Objects.ShoppingCart;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class CustomerMenu {
    public static void show() {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();

        Clear.console();

        boolean run = true;
        while (run) {
            System.out.println();
            System.out.println("0 - Logout");
            System.out.println("1 - Romance");
            System.out.println("2 - Hardcore Bizarro Fiction");
            System.out.println("3 - Spoetry");
            System.out.println("4 - Cashier Memoir");
            System.out.println("5 - Oulipo Literature");
            System.out.println("99 - View Cart");


            int selection;
            try {
                selection = Ask.forInt("Select Option");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> {
                    shoppingCart.removeAll();
                    run = false;
                }
                case 1 -> ShowBooksFromCategoryMenu.show(1);
                case 2 -> ShowBooksFromCategoryMenu.show(2);
                case 3 -> ShowBooksFromCategoryMenu.show(3);
                case 4 -> ShowBooksFromCategoryMenu.show(4);
                case 5 -> ShowBooksFromCategoryMenu.show(5);
                case 99 -> ShoppingCartMenu.show();
                default -> System.out.println("\nPlease make a valid selection.\n");
            }
        }
    }
}