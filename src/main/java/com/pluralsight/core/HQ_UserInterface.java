package com.pluralsight.core;
import com.pluralsight.menu.Chips;
import com.pluralsight.menu.Drink;
import com.pluralsight.menu.Sandwich;
import com.pluralsight.utils.HelperFunction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.file_management.ReceiptFileHandler.creatingTheOrderReceipt;

public class HQ_UserInterface {
    public static void starter () {

        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            String start = """
            ┌──────────────────────────────────────────┐
            │          Welcome to SandwichHQ!          │
            │ 1) New Order                             │
            │ 0) Exit                                  │
            └──────────────────────────────────────────┘
            Please select your choice:""";

            choice = HelperFunction.PromptForInt(start);

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                while (true) {

                    String orderScreen = """
                    ┌──────────────────────────────────────────┐
                    │              Order Screen                │
                    │ 1) Add Sandwich                          │
                    │ 2) Add Drink                             │
                    │ 3) Add Chips                             │
                    │ 4) Checkout                              │
                    │ 0) Cancel Order                          │
                    └──────────────────────────────────────────┘
                    Please select your choice:""";

                    choice = HelperFunction.PromptForInt(orderScreen);

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

    static Order order = new Order();

    private static void addSandwich() {

        String sizeOption = """
        ┌──────────────────────────────────────────┐
        │ Welcome to the Sandwich Creation         │
        │ Station! Let’s craft your perfect        │
        │ sandwich!                                │
        │                                          │
        │  1) 4" - Small         (200 calories)    │
        │  2) 8" - Medium        (400 calories)    │
        │  3) 12" - Large        (600 calories)    │
        └──────────────────────────────────────────┘
        Please select your choice:""";

        int sandwichSize = HelperFunction.PromptForInt(sizeOption);

        String breadOptions = """
        ┌──────────────────────────────────────────┐
        │ Now, let’s choose the bread that will    │
        │ hold all that goodness:                  │
        │                                          │
        │  1) White              (150 calories)    │
        │  2) Wheat              (120 calories)    │
        │  3) Rye                (130 calories)    │
        │  4) Wrap               (200 calories)    │
        └──────────────────────────────────────────┘
        Please select your choice:""";
        int sandwichBreadType = HelperFunction.PromptForInt(breadOptions);

        String regularToppings = """
        ┌──────────────────────────────────────────┐
        │ Let's talk toppings! What's going on     │
        │ top of your sandwich? (Select multiple   │
        │ by typing numbers separated by commas):  │
        │                                          │
        │  1) Lettuce              (5 calories)    │
        │  2) Peppers              (10 calories)   │
        │  3) Onions               (15 calories)   │
        │  4) Tomatoes             (20 calories)   │
        │  5) Jalapeños            (5 calories)    │
        │  6) Cucumbers            (10 calories)   │
        │  7) Pickles              (5 calories)    │
        │  8) Guacamole            (50 calories)   │
        │  9) Mushrooms            (20 calories)   │
        │  0) No toppings                          │
        └──────────────────────────────────────────┘
        Please select your choice:""";
        ArrayList<Integer> selectedToppingNumbers = HelperFunction.PromptForArrayInt(regularToppings);

        String meatOptionsSt = """
        
        ┌──────────────────────────────────────────┐
        │ Let’s talk meat! Or not...               │
        │ (Select multiple by typing numbers       │
        │ separated by commas):                    │
        │                                          │
        │  1) Steak                (250 calories)  │
        │  2) Ham                  (150 calories)  │
        │  3) Salami               (200 calories)  │
        │  4) Roast Beef           (220 calories)  │
        │  5) Chicken              (180 calories)  │
        │  6) Bacon                (300 calories)  │
        │  0) No meat                              │
        └──────────────────────────────────────────┘
        Please select your choice:""";
        ArrayList<Integer> sandwichMeatOptionValue = HelperFunction.PromptForArrayInt(meatOptionsSt);

        boolean extraMeat = false;
        if (!(sandwichMeatOptionValue.get(0)==0)){
            String extraMeatOption = """
                    \nThinking of adding extra meat? (yes/no) [default: no]
                    Extra meat (adds approximately 150-250 calories depending on the type of meat you choose)
                    """;
            extraMeat = HelperFunction.PromptForYesNo(extraMeatOption+"\nEnter 'yes' for extra meat or 'no' for none: ");
        }

        String cheeseOptionsSt = """
        ┌──────────────────────────────────────────┐
        │ Cheese time! Because every sandwich      │
        │ deserves a little cheese. (Select        │
        │ multiple by typing numbers separated     │
        │ by commas):                              │
        │                                          │
        │  1) American             (100 calories)  │
        │  2) Provolone            (120 calories)  │
        │  3) Cheddar              (130 calories)  │
        │  4) Swiss                (110 calories)  │
        │  0) No cheese                            │
        └──────────────────────────────────────────┘
        Please select your choice:""";
        ArrayList<Integer> sandwichCheeseOptionValue = HelperFunction.PromptForArrayInt(cheeseOptionsSt);

        boolean extraCheese = false;
        if (!(sandwichCheeseOptionValue.get(0)==0)) {

            // Extra Cheese option
            String extraCheeseOption = """
                    \nLet’s make it extra cheesy. What do you say? (yes/no) [default: no]
                    Extra cheese (adds approximately 100-130 calories depending on the cheese you choose)
                    """;
            extraCheese = HelperFunction.PromptForYesNo(extraCheeseOption + "\nEnter 'yes' for extra cheese or 'no' for none: ");
        }

        String sauces = """
        ┌──────────────────────────────────────────┐
        │ What’s a sandwich without sauce?         │
        │ Let’s get saucy! (Select multiple by     │
        │ typing numbers separated by commas):     │
        │                                          │
        │  1) Mayo               (90 calories)     │
        │  2) Mustard            (10 calories)     │
        │  3) Ketchup            (20 calories)     │
        │  4) Ranch              (150 calories)    │
        │  5) Thousand Islands   (130 calories)    │
        │  6) Vinaigrette         (50 calories)    │
        │  0) No sauce                             │
        └──────────────────────────────────────────┘
        Please select your choice:""";
        ArrayList<Integer> sandwichSaucesOptionValue = HelperFunction.PromptForArrayInt(sauces);


        String sideOptionSt = """
        ┌────────────────────────────────────────┐
        │ Add au jus for dipping? (yes/no)       │
        │ [default: no]                          │
        └────────────────────────────────────────┘
        """;
        boolean sideOption = HelperFunction.PromptForYesNo(sideOptionSt);


        String toastOptionSt = """
        ┌────────────────────────────────────────┐
        │ Add toast for extra crunch? (yes/no)   │
        │ [default: yes]                         │
        └────────────────────────────────────────┘
        """;
        boolean toastOption = HelperFunction.PromptForYesNo(toastOptionSt);
        HelperFunction.showLoadingMessage();

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
            if (toppingNumber >= 0 && toppingNumber < toppingOptions.size()) {
                selectedToppings.add(toppingOptions.get(toppingNumber));
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

        order.items.add(new Sandwich(sandwichSize, orderSandwichBread,
                selectedMeats, extraMeat, selectedCheese, extraCheese,selectedToppings,selectedSauces,toastOption));
    }

    private static void addDrink() {

        String water = "Sparkling water";
        String flavor = "No Flavor";

        // Drink Option
        String drinkOptionSt = """
        ┌──────────────────────────────────────────┐
        │  We only serve Sparkling Water, but hey, │
        │  it's still refreshing!                  │
        │                                          │
        │  1) Small         - 0 calories           │
        │  2) Medium        - 0 calories           │
        │  3) Large         - 0 calories           │
        │  0) No drink (Are you sure you           │
        │     don't want some sparkle?)            │
        └──────────────────────────────────────────┘
        Please select your choice:""";
        int drinkOption = HelperFunction.PromptForInt(drinkOptionSt);

        // creating Strings for sandwich size
        String orderDrinkSize = null;
        if (drinkOption == 1) {
            orderDrinkSize = "small";
        } else if (drinkOption == 2) {
            orderDrinkSize = "medium";
        } else if (drinkOption == 3) {
            orderDrinkSize = "large";
        }
        order.items.add(new Drink(drinkOption, flavor));
    }

    private static void addChips() {
        String chipsOptionSt = """
        ┌──────────────────────────────────────────┐
        │ Pick your poison...chips or no chips?    │
        │                                          │
        │  1) Yes, I want chips   (150 calories)   │
        │  0) No chips                             │
        └──────────────────────────────────────────┘
        Please select your choice:""";


        boolean chipsOption = HelperFunction.PromptForYesNo(chipsOptionSt);
        String chipsFlavors = """
        ┌──────────────────────────────────────────┐
        │     Crunch Time! Choose Your Flavorful   │
        │               Sidekick!                  │
        │                                          │
        │ All chips are equally delicious, same    │
        │ price, same calories!                    │
        │                                          │
        │ 1) Doritos                               │
        │ 2) Lay's                                 │
        │ 3) Cheetos                               │
        │ 4) Pringles                              │
        │                                          │
        │   Make your choice wisely... and crunch  │
        │                away!                     │
        └──────────────────────────────────────────┘
        """;
        int chipsFlavorValue = HelperFunction.PromptForInt(chipsFlavors);

        // creating Array for sandwich saucesOptionOption
        List<String> chipsOptions = Arrays.asList(
                "surprised ",// 0
                "Doritos",    // 1
                "Lay's",      // 2
                "Cheetos",    // 3
                "Pringles"
        );
        String selectedChips = "";

        switch (chipsFlavorValue){
            case 1 -> selectedChips="Doritos";
            case 2 -> selectedChips="Lay's";
            case 3 -> selectedChips="Cheetos";
            case 4 -> selectedChips="Pringles";
        }

        order.items.add(new Chips(selectedChips));

    }

    private static void checkout() {
        System.out.println("┌──────────────────────────────────────────┐");
        System.out.println("│              Order Checkout              │");
        System.out.println("└──────────────────────────────────────────┘\n");

        creatingTheOrderReceipt(order.items);

        String receiptHeader = """
                           ** SandwichHQ Receipt **
                ------------------------------------------
                  Date: %s
                
                """.formatted(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.print(receiptHeader);

        double total = 0.0;
        for (SandwichHQItem item : order.items) {
            System.out.printf("  %-20s $%6.2f\n", item.getDescription(), item.getPrice());
            System.out.println("  " + item.receipt());
            System.out.println("------------------------------------------");
            total += item.getPrice();
        }

        System.out.printf("""
                     
                      Total:                  $%6.2f
                      Thank you for dining with us!
                    ------------------------------------------
                    
                    """, total);

    }
}