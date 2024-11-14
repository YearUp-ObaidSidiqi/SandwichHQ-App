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
    boolean extraCheese;
    ArrayList<String> regularTopping;
    ArrayList<String> sauce;

    public Sandwich(double price, String size, String breadType, ArrayList<String> meat,
                    boolean extraMeat, ArrayList<String> cheese, boolean extraChess, ArrayList<String> otherTopping,
                    ArrayList<String> sauce, boolean isToasted) {
        super("Sandwich", price);
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.meat = meat;
        this.cheese = cheese;
        this.regularTopping = otherTopping;
        this.sauce = sauce;
        this.extraMeat = extraMeat;
        this.extraCheese = extraChess;
    }


    @Override
    public String receipt() {
        return String.format(
                "Item: %-10s Size: %-4s | Bread: %-6s | Toasted: %-3s\nMeat: %-8s\nCheese: %-7s\nToppings: %-20s\nSauces: %-15s\nPrice: $%.2f",
                this.getDescription(),
                this.size,
                this.breadType,
                this.isToasted ? "Yes" : "No",
                String.join(", ", this.meat),
                String.join(", ", this.cheese),
                String.join(", ", this.regularTopping),
                String.join(", ", this.sauce),
                this.getPrice()
        );
    }
}

