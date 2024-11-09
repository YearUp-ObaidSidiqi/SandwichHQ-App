package com.pluralsight;

import java.util.ArrayList;

public class Calculation {
    Pricing pricing;


    // Sandwich
    String size;
    String breadType;
    boolean isToasted;
    ArrayList<String> meat;
    ArrayList<String> cheese;
    ArrayList<String> otherTopping;
    ArrayList<String> sauce;

    public double sandwichCalculation(String size,boolean toppingPremium, boolean toppingExtraPremium, boolean toppingChess, boolean toppingExtraChess ){

        double total = 0;

        if ( size.equalsIgnoreCase("small")){
            total += pricing.getSandwichPrice4Inch();
            if (toppingPremium){
                total += pricing.getSandwichToppingsPrice4Inch();}
            if(toppingExtraPremium){
                total+=pricing.getExtraMeatPrice4Inch();}
            if (toppingChess){
                total += pricing.getCheesePrice4Inch();}
            if (toppingExtraChess){
                total += pricing.getExtraCheesePrice4Inch();}

            System.out.println("small");
        } else if (size.equalsIgnoreCase("medium")) {
            total += pricing.getSandwichPrice8Inch();
            if (toppingPremium){
                total += pricing.getSandwichToppingsPrice8Inch();}
            if(toppingExtraPremium){
                total+=pricing.getExtraMeatPrice8Inch();}
            if (toppingChess){
                total += pricing.getCheesePrice8Inch();}
            if (toppingExtraChess){
                total += pricing.getExtraCheesePrice8Inch();}

            System.out.println("medium");
        } else if (size.equalsIgnoreCase("large")) {
            System.out.println("large");
        }
        return total;
    }

    public double drinkCalculation(String size){
        return
        switch (size.toUpperCase()){
            case "SMALL" ->  pricing.getSmallDrinkPrice();
            case "MEDIUM" -> pricing.getMediumDrinkPrice();
            case "LARGE" -> pricing.getLargeDrinkPrice();
            default -> throw new IllegalStateException("Unexpected value: " + size.toUpperCase());
        };
    }

    public double chipCalculation(String size){
        return pricing.getChipsPrice();
    }


}
