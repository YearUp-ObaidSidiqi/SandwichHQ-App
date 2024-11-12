package com.pluralsight;

public class Calculation {
    static Pricing pricing = new Pricing();

    public static double sandwichCalculation(int size,boolean toppingMeat, boolean toppingExtraMeat,
                                      boolean toppingChess, boolean toppingExtraChess ){

        double total = 0;

        if ( size==1){
            total += pricing.getSandwichPrice4Inch();
            if (toppingMeat){
                total += pricing.getSandwichToppingsPrice4Inch();}
            if(toppingExtraMeat){
                total+=pricing.getExtraMeatPrice4Inch();}
            if (toppingChess){
                total += pricing.getCheesePrice4Inch();}
            if (toppingExtraChess){
                total += pricing.getExtraCheesePrice4Inch();}

        } else if (size == 2) {
            total += pricing.getSandwichPrice8Inch();
            if (toppingMeat){
                total += pricing.getSandwichToppingsPrice8Inch();}
            if(toppingExtraMeat){
                total+=pricing.getExtraMeatPrice8Inch();}
            if (toppingChess){
                total += pricing.getCheesePrice8Inch();}
            if (toppingExtraChess){
                total += pricing.getExtraCheesePrice8Inch();}

        } else if (size==3) {
            total += pricing.getSandwichPrice12Inch();
            if (toppingMeat){
                total += pricing.getSandwichToppingsPrice12Inch();}
            if(toppingExtraMeat){
                total+=pricing.getExtraMeatPrice12Inch();}
            if (toppingChess){
                total += pricing.getCheesePrice12Inch();}
            if (toppingExtraChess){
                total += pricing.getExtraCheesePrice12Inch();}
        }
        return total;
    }

    public static double drinkCalculation(int size){
        return
        switch (size){
            case 1 ->  pricing.getSmallDrinkPrice();
            case 2 -> pricing.getMediumDrinkPrice();
            case 3 -> pricing.getLargeDrinkPrice();
            default -> throw new IllegalStateException("Unexpected value: ");
        };
    }

    public static double chipCalculation(){
        return pricing.getChipsPrice();
    }
}
