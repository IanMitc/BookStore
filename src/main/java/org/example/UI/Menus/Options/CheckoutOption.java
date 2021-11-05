package org.example.UI.Menus.Options;

import org.example.Objects.ShoppingCart;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class CheckoutOption {
    public static void execute() {
        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();
        boolean sure = false;

        Clear.console();
        boolean run = true;
        while (run) {
            try {
                sure = Ask.forBoolean("Are you sure? I mean, we really are gonna take your money for this junk", 'y', 'n');
                run = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (sure) {
            shoppingCart.removeAll();
            Clear.console();
            System.out.println("Thanks, you should get your shipment sometime after we finally get around to sending it.");
        } else {
            Clear.console();
        }
    }
}