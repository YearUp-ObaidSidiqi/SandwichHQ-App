package com.pluralsight.Food;
import com.pluralsight.SandwichHQItem;

public class Drink extends SandwichHQItem {

    String size;
    String flavor;

    public Drink(String description, double price, String size, String flavor) {
        super("Drink", price);
        this.size = size;
        this.flavor = flavor;
    }
    @Override
    public String receipt() {
        return String.format(
                "Item: %-10s Size: %-4s | Flavor: %-10s\nPrice: $%.2f",
                this.getDescription(),
                this.size,
                this.flavor,
                this.getPrice()
        );
    }
}

