package org.example.UI.Menus;

import org.example.UI.Menus.Options.CustomerRegistrationOption;
import org.example.UI.Menus.Options.ExitOption;
import org.example.UI.Menus.Options.LoginOption;
import org.example.UI.Utility.Ask;
import org.example.UI.Utility.Clear;

public class MainMenu {

    public static void show() {
        Clear.console();
        boolean run = true;
        while (run) {
            int selection;

            System.out.println("\nWelcome to The Book Store\n\n");

            System.out.println("1 - Login");
            System.out.println("2 - Register as New Customer");
            System.out.println("3 - Exit");
            try {
                selection = Ask.forInt("Select Option");
            } catch (Exception e) {
                Clear.console();
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
                default -> {
                    Clear.console();
                    System.out.println("\nPlease make a valid selection.\n");
                }
            }
        }
    }
}
