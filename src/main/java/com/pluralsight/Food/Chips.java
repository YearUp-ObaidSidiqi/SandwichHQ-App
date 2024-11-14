package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

public class Chips extends SandwichHQItem {

    String flavor;

    public Chips(String description, double price, String flavor) {
        super("Chips", price);
        this.flavor = flavor;
    }

    @Override
    public String receipt() {
        return String.format(
                "Item: %-10s | Flavor: %-10s\nPrice: $%.2f",
                this.getDescription(),
                this.flavor,
                this.getPrice()
        );
    }
}
