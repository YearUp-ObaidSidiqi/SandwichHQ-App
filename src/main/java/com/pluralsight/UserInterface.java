package com.pluralsight;

import com.pluralsight.Food.Sandwich;

import java.util.ArrayList;
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
        System.out.println("\nWelcome to the Sandwich Creation Station! Let’s craft your perfect sandwich!");

        // Size options
        System.out.println("\nFirst, let’s choose the size of your sandwich masterpiece:");
        System.out.println("1. 4\" - Small (200 calories)");
        System.out.println("2. 8\" - Medium (400 calories)");
        System.out.println("3. 12\" - Large (600 calories)");
        int sandwichSize = Utilities.PromptForInt("Please select [1], [2], or [3] for the size of your sandwich: ");

        // Bread options
        System.out.println("\nNow, let’s choose the bread that will hold all that goodness:");
        System.out.println("1. White (150 calories)");
        System.out.println("2. Wheat (120 calories)");
        System.out.println("3. Rye (130 calories)");
        System.out.println("4. Wrap (200 calories)");
        int sandwichBreadType = Utilities.PromptForInt("Please select from [1], [2], [3], [4] for your bread: ");

        // Regular Toppings
        System.out.println("\nLet's talk toppings! What's going on top of your sandwich? (select multiple by typing numbers separated by commas):");
        System.out.println("1. Lettuce (5 calories)");
        System.out.println("2. Peppers (10 calories)");
        System.out.println("3. Onions (15 calories)");
        System.out.println("4. Tomatoes (20 calories)");
        System.out.println("5. Jalapeños (5 calories)");
        System.out.println("6. Cucumbers (10 calories)");
        System.out.println("7. Pickles (5 calories)");
        System.out.println("8. Guacamole (50 calories)");
        System.out.println("9. Mushrooms (20 calories)");
        System.out.println("0. No toppings");
        ArrayList<Integer> sandwichRegularToppingOption = Utilities.PromptForArrayInt("Please select the toppings by entering their corresponding numbers (e.g., 1,2,3), or [0] for no toppings: ");

        // Meat options
        System.out.println("\nLet’s talk meat! Or not... (select multiple by typing numbers separated by commas):");
        System.out.println("1. Steak (250 calories)");
        System.out.println("2. Ham (150 calories)");
        System.out.println("3. Salami (200 calories)");
        System.out.println("4. Roast Beef (220 calories)");
        System.out.println("5. Chicken (180 calories)");
        System.out.println("6. Bacon (300 calories)");
        System.out.println("0. No meat");
        ArrayList<Integer> sandwichMeatOption = Utilities.PromptForArrayInt("Please select from [1], [2], [3], [4], [5], [6] or 0 if no meat: ");

       // if (sandwichMeatOption)

        // Extra Meat option
        System.out.println("\nThinking of adding extra meat? (yes/no) [default: no]");
        System.out.println("Extra meat (adds approximately 150-250 calories depending on the type of meat you choose)");
        boolean extraMeat = Utilities.PromptForYesNo("Enter 'yes' for extra meat or 'no' for none: ");

        // Cheese options
        System.out.println("\nCheese time! Because every sandwich deserves a little cheese (you can select multiple by typing numbers separated by commas):");
        System.out.println("1. American (100 calories)");
        System.out.println("2. Provolone (120 calories)");
        System.out.println("3. Cheddar (130 calories)");
        System.out.println("4. Swiss (110 calories)");
        System.out.println("0. No cheese");
        ArrayList<Integer> sandwichCheeseOption = Utilities.PromptForArrayInt("Select your cheese [1,2,3...], or [0] for no cheese: ");

        // Extra Cheese option
        System.out.println("\nLet’s make it extra cheesy. What do you say? (yes/no) [default: no]");
        System.out.println("Extra cheese (adds approximately 100-130 calories depending on the cheese you choose)");
        boolean extraCheese = Utilities.PromptForYesNo("Enter 'yes' for extra cheese or 'no' for none: ");

        // Sauces
        System.out.println("\nWhat’s a sandwich without sauce? Let’s get saucy: (you can select multiple by typing numbers separated by commas):");
        System.out.println("1. Mayo (90 calories)");
        System.out.println("2. Mustard (10 calories)");
        System.out.println("3. Ketchup (20 calories)");
        System.out.println("4. Ranch (150 calories)");
        System.out.println("5. Thousand Islands (130 calories)");
        System.out.println("6. Vinaigrette (50 calories)");
        System.out.println("0. No sauce");
        ArrayList<Integer> sandwichSaucesOption = Utilities.PromptForArrayInt("Select your sauce [1,2,3...], or [0] for no sauce: ");

        // Side option
        System.out.println("\nWould you like to add a side of au jus for dipping? (yes/no) [default: no]");
        boolean sideOption = Utilities.PromptForYesNo("Enter 'yes' for au jus or 'no' for none: ");

        // Toasted option
        System.out.println("\nWant to add a little extra crunch to your sandwich with some toasting? (yes/no) [default: yes]");
        boolean toastOption = Utilities.PromptForYesNo("Type 'yes' for toasted, or 'no' if you prefer the fresh approach");

        System.out.println("\nThank you! Your sandwich order is all set. Get ready to enjoy a meal that’s as customized as you are.");

       /* // creating boolean, for calculation price,
        if ()

            boolean toppingMeat
        boolean toppingExtraMeat;
        boolean toppingChess;
        boolean toppingExtraChess;*/

        /*
        double x = Calculation.sandwichCalculation(sandwichSize, )
        Order order = new Order();
        order.orders.add(new Sandwich("Sandwich", ))
*/
    }

    private static void addDrink() {

        // Drink Option
        System.out.println("\nWe only serve sparkling water, but hey, it's still refreshing! Choose your drink size:");
        System.out.println("1. Small         - 0 calories");
        System.out.println("2. Medium        - 0 calories");
        System.out.println("3. Large         - 0 calories");
        System.out.println("0. No drink (Are you sure you don't want some sparkle?)");
        int drinkOption = Utilities.PromptForInt("Which one will it be? [1], [2], [3], or [0] to skip");

    }

    private static void addChips() {
        System.out.println("\nPick your poison...chips or no chips?");
        System.out.println("1. Yes, I want chips - 150 calories");
        System.out.println("0. No chips");
        boolean chipsOption = Utilities.PromptForYesNo("Type '1' for chips, '0' if you're skipping the crunch");

    }

    private static void checkout() {
        System.out.println("┌────────────────┐");
        System.out.println("│ Order Checkout │");
        System.out.println("└────────────────┘");



    }

}