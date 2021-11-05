package org.example.UI.Menus.Customer;

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
            System.out.println("1 - Romance");
            System.out.println("2 - Hardcore Bizarro Fiction");
            System.out.println("3 - Spoetry");
            System.out.println("4 - Cashier Memoir");
            System.out.println("5 - Oulipo Literature");

            int selection;
            try {
                selection = Ask.forInt("Select Category (99 to View Your Shopping Cart, 0 to Logout)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 0 -> {
                    shoppingCart = null;
                    return;
                }
                case 1 -> ShowFromCategoryMenu.show(1);
                case 2 -> ShowFromCategoryMenu.show(2);
                case 3 -> ShowFromCategoryMenu.show(3);
                case 4 -> ShowFromCategoryMenu.show(4);
                case 5 -> ShowFromCategoryMenu.show(5);
                case 99 -> ShoppingCartMenu.show();
                default -> System.out.println("\nPlease make a valid selection.\n");
            }
        }
    }
}