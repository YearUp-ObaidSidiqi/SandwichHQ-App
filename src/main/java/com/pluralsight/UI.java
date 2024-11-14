package com.pluralsight;

import com.pluralsight.Calculation.OrderPriceCalculator;
import com.pluralsight.Calculation.PricingManager;
import com.pluralsight.Food.Chips;
import com.pluralsight.Food.Drink;
import com.pluralsight.Food.Sandwich;
import com.pluralsight.Utilities.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.FileManager.ReceiptFileManager.creatingTheOrderReceipt;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);
    private static Order order = new Order();

    public static void main(String[] args) {
        int choice;

        while (true) {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                handleOrder();
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│ Welcome to SandwichHQ!                 │");
        System.out.println("│ 1) New Order                           │");
        System.out.println("│ 0) Exit                                │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.print("Please select your choice: ");
    }

    private static void handleOrder() {
        int choice;
        while (true) {
            displayOrderMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> {
                    System.out.println("Order canceled. Returning to home screen...");
                    return;
                }
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> {
                    checkout();
                     Utilities.printStarsForSpacing();
                    return;
                }
            }
        }
    }

    private static void displayOrderMenu() {
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│ Order Screen                           │");
        System.out.println("│ 1) Add Sandwich                        │");
        System.out.println("│ 2) Add Drink                           │");
        System.out.println("│ 3) Add Chips                           │");
        System.out.println("│ 4) Checkout                            │");
        System.out.println("│ 0) Cancel Order                        │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.print("Please select your choice: ");
    }

    private static void addSandwich() {

        int sandwichSize = Utilities.PromptForInt(getSandwichSizeOptions());
        int sandwichBreadType = Utilities.PromptForInt(getBreadOptions());
        ArrayList<Integer> selectedToppingNumbers = Utilities.PromptForArrayInt(getToppingsOptions());
        ArrayList<Integer> sandwichMeatOptionValue = Utilities.PromptForArrayInt(getMeatOptions());
        boolean extraMeat = !(sandwichMeatOptionValue.get(0) == 0) && Utilities.PromptForYesNo(getExtraMeatOption());
        ArrayList<Integer> sandwichCheeseOptionValue = Utilities.PromptForArrayInt(getCheeseOptions());
        boolean extraCheese = !(sandwichCheeseOptionValue.get(0) == 0) && Utilities.PromptForYesNo(getExtraCheeseOption());
        ArrayList<Integer> sandwichSaucesOptionValue = Utilities.PromptForArrayInt(getSaucesOptions());
        boolean sideOption = Utilities.PromptForYesNo(getSideOption());
        boolean toastOption = Utilities.PromptForYesNo(getToastOption());

        Sandwich sandwich = createSandwich(sandwichSize, sandwichBreadType, selectedToppingNumbers, sandwichMeatOptionValue,
                extraMeat, sandwichCheeseOptionValue, extraCheese, sandwichSaucesOptionValue, toastOption);
        order.Items.add(sandwich);
    }

    private static Sandwich createSandwich(int sandwichSize, int sandwichBreadType, ArrayList<Integer> selectedToppingNumbers,
                                           ArrayList<Integer> sandwichMeatOptionValue, boolean extraMeat,
                                           ArrayList<Integer> sandwichCheeseOptionValue, boolean extraCheese,
                                           ArrayList<Integer> sandwichSaucesOptionValue, boolean toastOption) {
        double sandwichPrice = OrderPriceCalculator.calculateSandwichTotalPrice(sandwichSize, hasToppings(sandwichMeatOptionValue),
                extraMeat, hasToppings(sandwichCheeseOptionValue), extraCheese);

        String orderSandwichBread = getBreadType(sandwichBreadType);
        String orderSandwichSize = getSizeType(sandwichSize);

        List<String> selectedMeats = getSelectedOptions(sandwichMeatOptionValue, getMeatOptionsList());
        List<String> selectedCheese = getSelectedOptions(sandwichCheeseOptionValue, getCheeseOptionsList());
        List<String> selectedToppings = getSelectedOptions(selectedToppingNumbers, getToppingsList());
        List<String> selectedSauces = getSelectedOptions(sandwichSaucesOptionValue, getSauceOptionsList());

        return new Sandwich(sandwichPrice, orderSandwichSize, orderSandwichBread, (ArrayList<String>) selectedMeats,
                extraMeat, (ArrayList<String>) selectedCheese, extraCheese, (ArrayList<String>) selectedToppings, (ArrayList<String>) selectedSauces, toastOption);
    }

    private static void addDrink() {
        int drinkOption = Utilities.PromptForInt(getDrinkOptions());
        double drinkPrice = OrderPriceCalculator.drinkCalculation(drinkOption);
        String orderDrinkSize = getSizeType(drinkOption);

        if (drinkOption != 0) {
            order.Items.add(new Drink("Drink", drinkPrice, orderDrinkSize, "No Flavor"));
        }
    }

    private static void addChips() {
        if (Utilities.PromptForYesNo(getChipsOption())) {
            String chipsFlavor = Utilities.PromptForInt(getChipsFlavorsOptions()) != 0 ? "Flavor selected" : "No Flavor";
            order.Items.add(new Chips("Chips", PricingManager.getChipsPrice() , chipsFlavor));
        }
    }

    private static void checkout() {
        creatingTheOrderReceipt(order.Items);
        System.out.println("Order receipt has been created. Thank you!");
    }

    // Utility methods for option texts
    private static String getSandwichSizeOptions() {
        return """
                \nWelcome to the Sandwich Creation Station! Let’s craft your perfect sandwich!
                Choose your sandwich size:
                1. 4" - Small (200 calories)
                2. 8" - Medium (400 calories)
                3. 12" - Large (600 calories)
                """;
    }

    private static String getBreadOptions() {
        return """
                \nNow, let’s choose the bread that will hold all that goodness:
                1. White (150 calories)
                2. Wheat (120 calories)
                3. Rye (130 calories)
                4. Wrap (200 calories)
                """;
    }

    private static String getToppingsOptions() {
        return """
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
    }

    private static String getMeatOptions() {
        return """
                \nLet’s talk meat! Or not... (select multiple by typing numbers separated by commas):
                1. Steak (250 calories)
                2. Ham (150 calories)
                3. Salami (200 calories)
                4. Roast Beef (220 calories)
                5. Chicken (180 calories)
                6. Bacon (300 calories)
                0. No meat
                """;
    }

    private static String getExtraMeatOption() {
        return "\nExtra meat? (yes/no)";
    }

    private static String getCheeseOptions() {
        return """
                \nCheese time! Because every sandwich deserves a little cheese (you can select multiple by typing numbers separated by commas):
                1. American (100 calories)
                2. Provolone (120 calories)
                3. Cheddar (130 calories)
                4. Swiss (110 calories)
                0. No cheese
                """;
    }

    private static String getExtraCheeseOption() {
        return "\nExtra cheese? (yes/no)";
    }

    private static String getSaucesOptions() {
        return """
                \nWhat’s a sandwich without sauce? Let’s get saucy: (you can select multiple by typing numbers separated by commas):
                1. Mayo (90 calories)
                2. Mustard (10 calories)
                3. Ketchup (20 calories)
                4. Ranch (150 calories)
                5. Thousand Islands (130 calories)
                6. Vinaigrette (50 calories)
                0. No sauce
                """;
    }

    private static String getSideOption() {
        return "\nAdd a side of au jus for dipping? (yes/no)";
    }

    private static String getToastOption() {
        return "\nWant to add a little extra crunch to your sandwich with some toasting? (yes/no) [default: yes]";
    }

    private static String getDrinkOptions() {
        return """
                \nWe only serve sparkling water, but hey, it's still refreshing! Choose your drink size:
                Choose the size:
                1. Small
                2. Medium
                3. Large
                0. No drink (Are you sure you don't want some sparkle?)
                """;
    }

    private static String getChipsOption() {
        return "\nPick your poison...chips or no chips? (yes/no)";
    }

    private static String getChipsFlavorsOptions() {
        return """
                \nCrunch Time! Choose Your Flavorful Sidekick!
                All chips are equally delicious, same price, same calories!
                1. Doritos - Spicy, crunchy, and dangerously tasty
                2. Lay's - Classic crunch for your munch
                3. Cheetos - A cheesy delight, beware of fingers!
                4. Pringles - Bet you can’t eat just one stack!
                
                Make your choice wisely... and crunch away!
                """;
    }

    private static String getBreadType(int breadOption) {
        return switch (breadOption) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "No bread";
        };
    }

    private static String getSizeType(int sizeOption) {
        return switch (sizeOption) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "No size";
        };
    }

    private static List<String> getSelectedOptions(List<Integer> selectedOptions, List<String> allOptions) {
        List<String> selectedItems = new ArrayList<>();
        for (int option : selectedOptions) {
            if (option > 0 && option <= allOptions.size()) {
                selectedItems.add(allOptions.get(option - 1));
            }
        }
        return selectedItems;
    }

    // Option lists for selections
    private static List<String> getMeatOptionsList() {
        return Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
    }

    private static List<String> getCheeseOptionsList() {
        return Arrays.asList("American", "Provolone", "Cheddar", "Swiss");
    }

    private static List<String> getToppingsList() {
        return Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
    }

    private static List<String> getSauceOptionsList() {
        return Arrays.asList("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette");
    }

    private static boolean hasToppings(ArrayList<Integer> selectedOptions) {
        return !selectedOptions.isEmpty() && selectedOptions.get(0) != 0;
    }
}
