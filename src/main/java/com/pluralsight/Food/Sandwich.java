package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

import java.util.ArrayList;

public class Sandwich extends SandwichHQItem {

    String size;
    String breadType;
    boolean isToasted;
    ArrayList<String> meat;
    ArrayList<String> cheese;
    ArrayList<String> otherTopping;
    ArrayList<String> sauce;

    public Sandwich(String description, double price, String size, String breadType,
                    boolean isToasted, ArrayList<String> meat, ArrayList<String> cheese,
                    ArrayList<String> otherTopping, ArrayList<String> sauce)
    {
        super(description, price);
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.meat = meat;
        this.cheese = cheese;
        this.otherTopping = otherTopping;
        this.sauce = sauce;
    }


    @Override
    public String receipt() {
        return String.format(
                "Order: %s | Price: $%.2f | Size: %s | Bread: %s | Toasted: %s | Meat: %s | Cheese: %s | Toppings: %s | Sauces: %s",
                this.getDescription(),
                this.getPrice(),
                this.size,
                this.breadType,
                this.isToasted ? "Yes" : "No",
                String.join(", ", this.meat),
                String.join(", ", this.cheese),
                String.join(", ", this.otherTopping),
                String.join(", ", this.sauce)
        );
    }
}
