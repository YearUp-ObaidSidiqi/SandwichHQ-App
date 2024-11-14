package com.pluralsight.Calculation;



public class OrderPriceCalculator {

    public static double calculateSandwichTotalPrice(int sandwichSizeInInches, boolean hasMeatTopping, boolean hasExtraMeatTopping,
                                                     boolean hasCheeseTopping, boolean hasExtraCheeseTopping ){
        double total = 0;

        if ( sandwichSizeInInches==1){
            total += PricingManager.getSandwichPrice4Inch();
            if (hasMeatTopping){
                total += PricingManager.getSandwichToppingsPrice4Inch();}
            if(hasExtraMeatTopping){
                total+= PricingManager.getExtraMeatPrice4Inch();}
            if (hasCheeseTopping){
                total += PricingManager.getCheesePrice4Inch();}
            if (hasExtraCheeseTopping){
                total += PricingManager.getExtraCheesePrice4Inch();}

        } else if (sandwichSizeInInches == 2) {
            total += PricingManager.getSandwichPrice8Inch();
            if (hasMeatTopping){
                total += PricingManager.getSandwichToppingsPrice8Inch();}
            if(hasExtraMeatTopping){
                total+= PricingManager.getExtraMeatPrice8Inch();}
            if (hasCheeseTopping){
                total += PricingManager.getCheesePrice8Inch();}
            if (hasExtraCheeseTopping){
                total += PricingManager.getExtraCheesePrice8Inch();}

        } else if (sandwichSizeInInches==3) {
            total += PricingManager.getSandwichPrice12Inch();
            if (hasMeatTopping){
                total += PricingManager.getSandwichToppingsPrice12Inch();}
            if(hasExtraMeatTopping){
                total+= PricingManager.getExtraMeatPrice12Inch();}
            if (hasCheeseTopping){
                total += PricingManager.getCheesePrice12Inch();}
            if (hasExtraCheeseTopping){
                total += PricingManager.getExtraCheesePrice12Inch();}
        }
        return total;
    }

    public static double drinkCalculation(int size){
        return
        switch (size){
            case 1 ->  PricingManager.getSmallDrinkPrice();
            case 2 -> PricingManager.getMediumDrinkPrice();
            case 3 -> PricingManager.getLargeDrinkPrice();
            default -> throw new IllegalStateException("Unexpected value: ");
        };

    }

    public static double chipCalculation(){
        return PricingManager.getChipsPrice();
    }
}
