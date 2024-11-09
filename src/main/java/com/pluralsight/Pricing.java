package com.pluralsight;


public class Pricing {

    /// private final vs private final and gave getters and setter.

    // Sandwich Prices (per size)
    private final double sandwichPrice4Inch = 5.50;
    private final double sandwichPrice8Inch = 7.00;
    private final double sandwichPrice12Inch = 8.50;

    // Topping Prices for Meats (per size)
    private final double sandwichToppingsPrice4Inch = 1.00;
    private final double sandwichToppingsPrice8Inch = 2.00;
    private final double sandwichToppingsPrice12Inch = 3.00;

    // Extra Meat Prices (per size)
    private final double extraMeatPrice4Inch = 0.50;
    private final double extraMeatPrice8Inch = 1.00;
    private final double extraMeatPrice12Inch = 1.50;

    // Cheese Prices (per size)
    private final double CheesePrice4Inch = 0.75;
    private final double CheesePrice8Inch = 1.50;
    private final double CheesePrice12Inch = 2.25;

    // Extra Cheese Prices (per size)
    private final double extraCheesePrice4Inch = 0.30;
    private final double extraCheesePrice8Inch = 0.60;
    private final double extraCheesePrice12Inch = 0.90;

    // Drink Prices (by size)
    private final double smallDrinkPrice = 2.00;
    private final double mediumDrinkPrice = 2.50;
    private final double largeDrinkPrice = 3.00;

    // Chips Price
    private final double chipsPrice = 1.50;

    public double getChipsPrice() {
        return chipsPrice;
    }

    // Regular Topping Prices (all sizes) are free of cost

    // Sauces Prices (all sizes) are free of cost

    // Sides (included in the sandwich) are free of cost


    public double getSandwichPrice4Inch() {
        return sandwichPrice4Inch;
    }

    public double getSandwichPrice8Inch() {
        return sandwichPrice8Inch;
    }

    public double getSandwichPrice12Inch() {
        return sandwichPrice12Inch;
    }

    public double getSandwichToppingsPrice4Inch() {
        return sandwichToppingsPrice4Inch;
    }

    public double getSandwichToppingsPrice8Inch() {
        return sandwichToppingsPrice8Inch;
    }

    public double getSandwichToppingsPrice12Inch() {
        return sandwichToppingsPrice12Inch;
    }

    public double getExtraMeatPrice4Inch() {
        return extraMeatPrice4Inch;
    }

    public double getExtraMeatPrice8Inch() {
        return extraMeatPrice8Inch;
    }

    public double getExtraMeatPrice12Inch() {
        return extraMeatPrice12Inch;
    }

    public double getCheesePrice4Inch() {
        return CheesePrice4Inch;
    }

    public double getCheesePrice8Inch() {
        return CheesePrice8Inch;
    }

    public double getCheesePrice12Inch() {
        return CheesePrice12Inch;
    }

    public double getExtraCheesePrice4Inch() {
        return extraCheesePrice4Inch;
    }

    public double getExtraCheesePrice8Inch() {
        return extraCheesePrice8Inch;
    }

    public double getExtraCheesePrice12Inch() {
        return extraCheesePrice12Inch;
    }

    public double getSmallDrinkPrice() {
        return smallDrinkPrice;
    }

    public double getMediumDrinkPrice() {
        return mediumDrinkPrice;
    }

    public double getLargeDrinkPrice() {
        return largeDrinkPrice;
    }


}


