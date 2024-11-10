package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│ Welcome to SandwichHQ!                 │");
            System.out.println("│ 1) New Order                           │");
            System.out.println("│ 0) Exit                                │");
            System.out.println("└────────────────────────────────────────┘");
            System.out.print("Please select your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                while (true) {

                    System.out.println("┌────────────────────────────────────────┐");
                    System.out.println("│ Order Screen                           │");
                    System.out.println("│ 1) Add Sandwich                        │");
                    System.out.println("│ 2) Add Drink                           │");
                    System.out.println("│ 3) Add Chips                           │");
                    System.out.println("│ 4) Checkout                            │");
                    System.out.println("│ 0) Cancel Order                        │");
                    System.out.println("└────────────────────────────────────────┘");
                    System.out.print("Please select your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 0) {
                        System.out.println("Order canceled. Returning to home screen...");
                        break;
                    } else if (choice == 1) {
                        addSandwich();
                    } else if (choice == 2) {
                        addDrink();
                    } else if (choice == 3) {
                        addChips();
                    } else if (choice == 4) {
                        checkout();
                        break;
                    }
                }
            }
        }
        scanner.close();
    }

    private static void addSandwich() {
        System.out.println("Let's create your sandwich.");

        // Size options
        System.out.println("\nChoose your sandwich size:");
        System.out.println("1. 4\" - Small");
        System.out.println("2. 8\" - Medium");
        System.out.println("3. 12\" - Large");
        int sandwichSize = Utilities.PromptForInt("Please select from [1], [2], [3] options");

        // Bread options
        System.out.println("\nChoose your bread:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        int sandwichBreadType = Utilities.PromptForInt("Please select from [1], [2], [3], [4] options");

        // Extra Meat option
        System.out.println("\nWould you like extra meat? (yes/no)");
        boolean extraMeat = Utilities.PromptForYesNo("Please select from [1], [2], [3], [4] options");

        // Cheese options
        System.out.println("\nChoose your cheese:");
        System.out.println("1. American");
        System.out.println("2. Provolone");
        System.out.println("3. Cheddar");
        System.out.println("4. Swiss");

        // Extra Cheese option
        System.out.println("\nWould you like extra cheese? (yes/no)");

        // Regular Toppings
        System.out.println("\nChoose your toppings (select multiple by typing numbers separated by commas):");
        System.out.println("1. Lettuce");
        System.out.println("2. Peppers");
        System.out.println("3. Onions");
        System.out.println("4. Tomatoes");
        System.out.println("5. Jalapeños");
        System.out.println("6. Cucumbers");
        System.out.println("7. Pickles");
        System.out.println("8. Guacamole");
        System.out.println("9. Mushrooms");

        // Sauces
        System.out.println("\nChoose your sauce (select multiple by typing numbers separated by commas):");
        System.out.println("1. Mayo");
        System.out.println("2. Mustard");
        System.out.println("3. Ketchup");
        System.out.println("4. Ranch");
        System.out.println("5. Thousand Islands");
        System.out.println("6. Vinaigrette");


        // Side option
        System.out.println("\nWould you like a side of au jus? (yes/no)");


        System.out.println("\nThank you! Your sandwich order has been created.");


    }

    private static void addDrink() {

        System.out.println("\nChoose your drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

    }

    private static void addChips() {
       System.out.println("\nWould you like chips with your order? (yes/no)");

    }

    private static void checkout() {
        System.out.println("┌────────────────┐");
        System.out.println("│ Order Checkout │");
        System.out.println("└────────────────┘");

    }

}