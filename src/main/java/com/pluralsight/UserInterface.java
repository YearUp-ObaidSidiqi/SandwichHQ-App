package com.pluralsight;
import com.pluralsight.Calculation.Calculation;
import com.pluralsight.Food.Sandwich;
import com.pluralsight.Utilities.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        String sizeOption = """
                \nWelcome to the Sandwich Creation Station! Let’s craft your perfect sandwich!
                1. 4\\" - Small (200 calories)
                2. 8\\" - Medium (400 calories)
                3. 12\\" - Large (600 calories)
                """;
        int sandwichSize = Utilities.PromptForInt(sizeOption + "\nPlease select [1], [2], or [3] for the size of your sandwich: ");

        // Bread options
        String breadOptions = """
                \nNow, let’s choose the bread that will hold all that goodness:
                1. White (150 calories)
                2. Wheat (120 calories)
                3. Rye (130 calories)
                4. Wrap (200 calories)

                """;
        int sandwichBreadType = Utilities.PromptForInt(breadOptions + "\nPlease select from [1], [2], [3], [4] for your bread: ");

        // Regular Toppings
        String regularToppings = """
                \nLet's talk toppings! What's going on top of your sandwich? (select multiple by typing numbers separated by commas):
                1. Lettuce (5 calories)
                2. Peppers (10 calories)
                3. Onions (15 calories)
                4. Tomatoes (20 calories)
                5. Jalapeños (5 calories)
                6. Cucumbers (10 calories)
                7. Pickles (5 calories)
                8. Guacamole (50 calories)
                9. Mushrooms (20 calories)
                0. No toppings
                """;
        ArrayList<Integer> selectedToppingNumbers = Utilities.PromptForArrayInt(regularToppings+ "\nPlease select the toppings by entering their corresponding numbers (e.g., 1,2,3), or [0] for no toppings: ");

        String meatOptionsSt = """
                \nLet’s talk meat! Or not... (select multiple by typing numbers separated by commas):
                1. Steak (250 calories)
                2. Ham (150 calories)
                3. Salami (200 calories)
                4. Roast Beef (220 calories)
                5. Chicken (180 calories)
                6. Bacon (300 calories)
                0. No meat
                """;
        ArrayList<Integer> sandwichMeatOptionValue = Utilities.PromptForArrayInt(meatOptionsSt + "\nPlease select from [1], [2], [3], [4], [5], [6] or 0 if no meat: ");

        boolean extraMeat = false;
          if (!(sandwichMeatOptionValue.get(0)==0)){
            String extraMeatOption = """
                    \nThinking of adding extra meat? (yes/no) [default: no]
                    Extra meat (adds approximately 150-250 calories depending on the type of meat you choose)
                    """;
            extraMeat = Utilities.PromptForYesNo(extraMeatOption+"\nEnter 'yes' for extra meat or 'no' for none: ");
          }

        // Cheese options
        String cheeseOptionsSt = """
                \nCheese time! Because every sandwich deserves a little cheese (you can select multiple by typing numbers separated by commas):
                1. American (100 calories)
                2. Provolone (120 calories)
                3. Cheddar (130 calories)
                4. Swiss (110 calories)
                0. No cheese
                """;
        ArrayList<Integer> sandwichCheeseOptionValue = Utilities.PromptForArrayInt(cheeseOptionsSt + "\nSelect your cheese [1,2,3...], or [0] for no cheese: ");

        boolean extraCheese = false;
        if (!(sandwichCheeseOptionValue.get(0)==0)) {

            // Extra Cheese option
            String extraCheeseOption = """
                    \nLet’s make it extra cheesy. What do you say? (yes/no) [default: no]
                    Extra cheese (adds approximately 100-130 calories depending on the cheese you choose)
                    """;
            extraCheese = Utilities.PromptForYesNo(extraCheeseOption + "\nEnter 'yes' for extra cheese or 'no' for none: ");
        }

        // Sauces
        String sauces = """
                \nWhat’s a sandwich without sauce? Let’s get saucy: (you can select multiple by typing numbers separated by commas):
                1. Mayo (90 calories)
                2. Mustard (10 calories)
                3. Ketchup (20 calories)
                4. Ranch (150 calories)
                5. Thousand Islands (130 calories)
                6. Vinaigrette (50 calories)
                0. No sauce
                """;
        ArrayList<Integer> sandwichSaucesOptionValue = Utilities.PromptForArrayInt(sauces + "\nSelect your sauce [1,2,3...], or [0] for no sauce: ");

        // Side option
        String sideOptionSt = ("\nWould you like to add a side of au jus for dipping? (yes/no) [default: no]");
        boolean sideOption = Utilities.PromptForYesNo(sideOptionSt + "\nEnter 'yes' for au jus or 'no' for none: ");

        // Toasted option
        String toastOptionSt = ("\nWant to add a little extra crunch to your sandwich with some toasting? (yes/no) [default: yes]");
        boolean toastOption = Utilities.PromptForYesNo(toastOptionSt + "\nType 'yes' for toasted, or 'no' if you prefer the fresh approach");

        System.out.println("\nThank you! Your sandwich order is all set. Get ready to enjoy a meal that’s as customized as you are.");

        // creating boolean, for calculating price,

       /* double sandwichPrice = Calculation.sandwichCalculation(sandwichSize, toppingMeat, toppingExtraMeat, toppingChess, toppingExtraChess);*/

        // creating Strings for sandwich size
        String orderSandwichSize = null;
        if (sandwichSize == 1) {
            orderSandwichSize = "small";
        } else if (sandwichSize == 2) {
            orderSandwichSize = "medium";
        } else if (sandwichSize == 3) {
            orderSandwichSize = "large";
        }

        // creating Strings for sandwich bread type
        String orderSandwichBread = null;
        if (sandwichBreadType == 1) {
            orderSandwichBread = "White";
        } else if (sandwichBreadType == 2) {
            orderSandwichBread = "Wheat";
        } else if (sandwichBreadType == 3) {
            orderSandwichBread = "Rye";
        }else if (sandwichBreadType == 4) {
            orderSandwichBread = "Wrap";
        }

        /// Convert ArrayList<Integers> to ArrayList<Strings>

        // creating Array for sandwich meatOption
        List<String> meatOptions = Arrays.asList(
                "No meat",               // 0
                "Steak (250 calories)",  // 1
                "Ham (150 calories)",    // 2
                "Salami (200 calories)", // 3
                "Roast Beef (220 calories)", // 4
                "Chicken (180 calories)",    // 5
                "Bacon (300 calories)"       // 6
        );
        ArrayList<String> selectedMeats = new ArrayList<>();
        for (Integer meatNumber : sandwichMeatOptionValue) {
            if (meatNumber >= 0 && meatNumber < meatOptions.size()) {
                selectedMeats.add(meatOptions.get(meatNumber));
            }
        }

        // creating Array for sandwich cheeseOption
        List<String> cheeseOptions = Arrays.asList(
                "No cheese",                // 0
                "American (100 calories)",  // 1
                "Provolone (120 calories)", // 2
                "Cheddar (130 calories)",   // 3
                "Swiss (110 calories)"      // 4
        );
        ArrayList<String> selectedCheese = new ArrayList<>();
        for (Integer cheeseNumber : sandwichCheeseOptionValue){
            if(cheeseNumber>=0 && cheeseNumber<cheeseOptions.size()){
                selectedCheese.add(cheeseOptions.get(cheeseNumber));
            }
        }

        // creating Array for sandwich regularToppingOption
        List<String> toppingOptions = Arrays.asList(
                "No toppings",            // 0
                "Lettuce (5 calories)",   // 1
                "Peppers (10 calories)",  // 2
                "Onions (15 calories)",   // 3
                "Tomatoes (20 calories)", // 4
                "Jalapeños (5 calories)", // 5
                "Cucumbers (10 calories)",// 6
                "Pickles (5 calories)",   // 7
                "Guacamole (50 calories)",// 8
                "Mushrooms (20 calories)" // 9
        );
        ArrayList<String> selectedToppings = new ArrayList<>();
        for (Integer toppingNumber : selectedToppingNumbers) {
            // Adjust for zero-based indexing by subtracting 1
            if (toppingNumber >= 0 && toppingNumber <= toppingOptions.size()) {
                selectedToppings.add(toppingOptions.get(toppingNumber - 1));
            }
        }

        // creating Array for sandwich saucesOptionOption
        List<String> sauceOptions = Arrays.asList(
                "No sauce",                 // 0
                "Mayo (90 calories)",       // 1
                "Mustard (10 calories)",    // 2
                "Ketchup (20 calories)",    // 3
                "Ranch (150 calories)",     // 4
                "Thousand Islands (130 calories)", // 5
                "Vinaigrette (50 calories)" // 6
        );
        ArrayList<String> selectedSauces = new ArrayList<>();
        for (Integer sauceNumber : sandwichSaucesOptionValue ) {
            if (sauceNumber >= 0 && sauceNumber < sauceOptions.size()) {
                selectedSauces.add(sauceOptions.get(sauceNumber));
            }
        }

        double sandwichPrice = 0;
        Order order = new Order();
        order.orders.add(new Sandwich("Sandwich",sandwichPrice, orderSandwichSize, orderSandwichBread,
                selectedMeats, extraMeat, selectedCheese, extraCheese,selectedToppings,selectedSauces,toastOption));

        for (SandwichHQItem o : order.orders){
            System.out.println( o.receipt());

        }

    }

    /*
    private void static addMeatToSandwich(ArrayList<Integer> meatValues, Sandwich sandwich){
        //do work to loop through integers, translate into string, and add to sandwich...
    }
    */

    private static void addDrink() {

        // Drink Option
        String drinkOptionSt = """
                \nWe only serve sparkling water, but hey, it's still refreshing! Choose your drink size:
                1. Small         - 0 calories
                2. Medium        - 0 calories
                3. Large         - 0 calories
                0. No drink (Are you sure you don't want some sparkle?)
                """;
        int drinkOption = Utilities.PromptForInt(drinkOptionSt + "\nWhich one will it be? [1], [2], [3], or [0] to skip");

    }

    private static void addChips() {
        String chipsOptionSt = """
                \nPick your poison...chips or no chips?
                1. Yes, I want chips - 150 calories
                0. No chips
                """;
        boolean chipsOption = Utilities.PromptForYesNo(chipsOptionSt + "\nType '1' for chips, '0' if you're skipping the crunch");

    }

    private static void checkout() {
        System.out.println("┌────────────────┐");
        System.out.println("│ Order Checkout │");
        System.out.println("└────────────────┘");



    }

}