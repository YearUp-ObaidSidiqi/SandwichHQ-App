package com.pluralsight.pricing;


public class PricingManager {


    //MenuPricing

    // Sandwich Prices (per size)
    private static final double sandwichPrice4Inch = 5.50;
    private static final double sandwichPrice8Inch = 7.00;
    private static final double sandwichPrice12Inch = 8.50;

    // Topping Prices for Meats (per size)
    private static final double sandwichMeatPrice4Inch = 1.00;
    private static final double sandwichMeatPrice8Inch = 2.00;
    private static final double sandwichMeatPrice12Inch = 3.00;

    // Extra Meat Prices (per size)
    private static final double extraMeatPrice4Inch = 0.50;
    private static final double extraMeatPrice8Inch = 1.00;
    private static final double extraMeatPrice12Inch = 1.50;

    // Cheese Prices (per size)
    private static final double CheesePrice4Inch = 0.75;
    private static final double CheesePrice8Inch = 1.50;
    private static final double CheesePrice12Inch = 2.25;

    // Extra Cheese Prices (per size)
    private static final double extraCheesePrice4Inch = 0.30;
    private static final double extraCheesePrice8Inch = 0.60;
    private static final double extraCheesePrice12Inch = 0.90;

    // Drink Prices (by size)
    private static final double smallDrinkPrice = 2.00;
    private static final double mediumDrinkPrice = 2.50;
    private static final double largeDrinkPrice = 3.00;

    // Chips Price
    private static final double chipsPrice = 1.50;

    public static double getChipsPrice() {
        return chipsPrice;
    }

    // Regular Topping Prices (all sizes) are free of cost

    // Sauces Prices (all sizes) are free of cost

    // Sides (included in the sandwich) are free of cost


    public static double getSandwichPrice4Inch() {
        return sandwichPrice4Inch;
    }

    public static double getSandwichPrice8Inch() {
        return sandwichPrice8Inch;
    }

    public static double getSandwichPrice12Inch() {
        return sandwichPrice12Inch;
    }

    public static double getSandwichMeatPrice4Inch() {
        return sandwichMeatPrice4Inch;
    }

    public static double getSandwichMeatPrice8Inch() {
        return sandwichMeatPrice8Inch;
    }

    public static double getSandwichMeatPrice12Inch() {
        return sandwichMeatPrice12Inch;
    }

    public static double getExtraMeatPrice4Inch() {
        return extraMeatPrice4Inch;
    }

    public static double getExtraMeatPrice8Inch() {
        return extraMeatPrice8Inch;
    }

    public static double getExtraMeatPrice12Inch() {
        return extraMeatPrice12Inch;
    }

    public static double getCheesePrice4Inch() {
        return CheesePrice4Inch;
    }

    public static double getCheesePrice8Inch() {
        return CheesePrice8Inch;
    }

    public static double getCheesePrice12Inch() {
        return CheesePrice12Inch;
    }

    public static double getExtraCheesePrice4Inch() {
        return extraCheesePrice4Inch;
    }

    public static double getExtraCheesePrice8Inch() {
        return extraCheesePrice8Inch;
    }

    public static double getExtraCheesePrice12Inch() {
        return extraCheesePrice12Inch;
    }

    public static double getSmallDrinkPrice() {
        return smallDrinkPrice;
    }

    public static double getMediumDrinkPrice() {
        return mediumDrinkPrice;
    }

    public static double getLargeDrinkPrice() {
        return largeDrinkPrice;
    }

}