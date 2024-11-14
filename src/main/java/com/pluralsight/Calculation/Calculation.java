package com.pluralsight.Calculation;

import java.util.ArrayList;

public class Calculation {

    public static double sandwichCalculation(int sandwichSize, boolean toppingMeat, boolean toppingExtraMeat,
                                             boolean toppingChess, boolean toppingExtraChess ){
        double total = 0;

        if ( sandwichSize==1){
            total += Pricing.getSandwichPrice4Inch();
            if (toppingMeat){
                total += Pricing.getSandwichToppingsPrice4Inch();}
            if(toppingExtraMeat){
                total+= Pricing.getExtraMeatPrice4Inch();}
            if (toppingChess){
                total += Pricing.getCheesePrice4Inch();}
            if (toppingExtraChess){
                total += Pricing.getExtraCheesePrice4Inch();}

        } else if (sandwichSize == 2) {
            total += Pricing.getSandwichPrice8Inch();
            if (toppingMeat){
                total += Pricing.getSandwichToppingsPrice8Inch();}
            if(toppingExtraMeat){
                total+= Pricing.getExtraMeatPrice8Inch();}
            if (toppingChess){
                total += Pricing.getCheesePrice8Inch();}
            if (toppingExtraChess){
                total += Pricing.getExtraCheesePrice8Inch();}

        } else if (sandwichSize==3) {
            total += Pricing.getSandwichPrice12Inch();
            if (toppingMeat){
                total += Pricing.getSandwichToppingsPrice12Inch();}
            if(toppingExtraMeat){
                total+= Pricing.getExtraMeatPrice12Inch();}
            if (toppingChess){
                total += Pricing.getCheesePrice12Inch();}
            if (toppingExtraChess){
                total += Pricing.getExtraCheesePrice12Inch();}
        }
        return total;
    }

    public static double drinkCalculation(int size){
        return
        switch (size){
            case 1 ->  Pricing.getSmallDrinkPrice();
            case 2 -> Pricing.getMediumDrinkPrice();
            case 3 -> Pricing.getLargeDrinkPrice();
            default -> throw new IllegalStateException("Unexpected value: ");
        };

    }

    public static double chipCalculation(){
        return Pricing.getChipsPrice();
    }
}
