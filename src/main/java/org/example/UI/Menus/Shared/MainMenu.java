package org.example.UI.Menus.Shared;

import org.example.UI.Menus.Customer.Options.CustomerRegistrationOption;
import org.example.UI.Menus.Shared.Options.ExitOption;
import org.example.UI.Menus.Shared.Options.LoginOption;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class MainMenu {

    public static void show() {
        boolean run = true;
        while (run) {
            int selection;
            Clear.console();

            System.out.println("\nWelcome to The Book Store\n\n");

            System.out.println("1 - Login");
            System.out.println("2 - Register as New Customer");
            System.out.println("3 - Exit");
            try {
                selection = Ask.forInt("Select Option");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (selection) {
                case 1 -> LoginOption.execute();
                case 2 -> CustomerRegistrationOption.execute();
                case 3 -> {
                    run = false;
                    ExitOption.execute();
                }
                default -> System.out.println("\nPlease make a valid selection.\n");
            }
        }
    }
}
