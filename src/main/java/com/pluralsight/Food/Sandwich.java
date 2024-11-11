package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

import java.util.ArrayList;

public class Sandwich extends SandwichHQItem {

    String size;
    String breadType;
    boolean isToasted;
    ArrayList<String> meat;
    boolean extraMeat;
    ArrayList<String> cheese;
    boolean extraChess;
    ArrayList<String> regularTopping;
    ArrayList<String> sauce;



    public Sandwich(String description, double price, String size, String breadType, ArrayList<String> meat,
                    boolean extraMeat, ArrayList<String> cheese, boolean extraChess, ArrayList<String> otherTopping,
                    ArrayList<String> sauce, boolean isToasted )
    {
        super(description, price);
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.meat = meat;
        this.cheese = cheese;
        this.regularTopping = otherTopping;
        this.sauce = sauce;
        this.extraMeat= extraMeat;
        this.extraChess = extraChess;
    }


    @Override
    public  String receipt() {
        return String.format(
                "Order: %s | Price: $%.2f | Size: %s | Bread: %s | Toasted: %s | Meat: %s | Cheese: %s | Toppings: %s | Sauces: %s",
                this.getDescription(),
                this.getPrice(),
                this.size,
                this.breadType,
                this.isToasted ? "Yes" : "No",
                String.join(", ", this.meat),
                String.join(", ", this.cheese),
                String.join(", ", this.regularTopping),
                String.join(", ", this.sauce)
        );
    }
}
