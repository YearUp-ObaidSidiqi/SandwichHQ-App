package com.pluralsight.menu;

import com.pluralsight.pricing.PricingManager;
import com.pluralsight.core.SandwichHQItem;
import java.util.ArrayList;

public class Sandwich extends SandwichHQItem {

    String size;
    String bread;
    ArrayList<String> meats;
    boolean extraMeat;
    ArrayList<String> cheeses;
    boolean extraCheese;
    ArrayList<String> toppings;
    ArrayList<String> sauces;
    boolean toasted;

    public Sandwich(int size, String bread, ArrayList<String> meats, boolean extraMeat,
                    ArrayList<String> cheeses, boolean extraCheese,
                    ArrayList<String> toppings, ArrayList<String> sauces, boolean toasted) {

        super("Sandwich", calculateSandwichPrice(size,extraMeat,extraCheese,meats,cheeses));
        this.size = size(size);
        this.bread = bread;
        this.meats = meats;
        this.extraMeat = extraMeat;
        this.cheeses = cheeses;
        this.extraCheese = extraCheese;
        this.toppings = toppings;
        this.sauces = sauces;
        this.toasted = toasted;
    }

    private String size(int size) {
        return switch (size) {
            case 1 -> "small";
            case 2 -> "medium";
            case 3 -> "large";
            default -> throw new IllegalStateException("Unexpected value: " + size);
        };
    }

    // Method to calculate the sandwich price
    static double calculateSandwichPrice(int size, boolean extraMeat, boolean extraCheese,
                                         ArrayList<String> meats, ArrayList<String> cheeses ) {

        // Toppings flags
        boolean hasMeatTopping = !(meats.get(0).equalsIgnoreCase("0"));
        boolean hasCheeseTopping = !(cheeses.get(0).equalsIgnoreCase("0"));

        double total = 0;

        if (size==1){
            total += PricingManager.getSandwichPrice4Inch();
            if (hasMeatTopping){
                total += PricingManager.getSandwichMeatPrice4Inch();}
            if(extraMeat){
                total+= PricingManager.getExtraMeatPrice4Inch();}
            if (hasCheeseTopping){
                total += PricingManager.getCheesePrice4Inch();}
            if (extraCheese){
                total += PricingManager.getExtraCheesePrice4Inch();}
        } else if (size == 2) {
            total += PricingManager.getSandwichPrice8Inch();
            if (hasMeatTopping){
                total += PricingManager.getSandwichMeatPrice8Inch();}
            if(extraMeat){
                total+= PricingManager.getExtraMeatPrice8Inch();}
            if (hasCheeseTopping){
                total += PricingManager.getCheesePrice8Inch();}
            if (extraCheese){
                total += PricingManager.getExtraCheesePrice8Inch();}
        } else if (size == 3) {
            total += PricingManager.getSandwichPrice12Inch();
            if (hasMeatTopping){
                total += PricingManager.getSandwichMeatPrice12Inch();}
            if(extraMeat){
                total+= PricingManager.getExtraMeatPrice12Inch();}
            if (hasCheeseTopping){
                total += PricingManager.getCheesePrice12Inch();}
            if (extraCheese){
                total += PricingManager.getExtraCheesePrice12Inch();}
        }
        return total;
    }

    @Override
    public String receipt() {
        return String.format(
                "Item: %-10s Size: %-4s | Bread: %-6s | Toasted: %-3s\nMeat: %-8s\nCheese: %-7s\nToppings: %-20s\nSauces: %-15s\nPrice: $%.2f",
                this.getDescription(),
                this.size,
                this.bread,
                this.toasted ? "Yes" : "No",
                String.join(", ", this.meats),
                String.join(", ", this.cheeses),
                String.join(", ", this.toppings),
                String.join(", ", this.sauces),
                this.getPrice()
        );
    }
}
