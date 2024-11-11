package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

public class Drink extends SandwichHQItem {

    String size;
    String flavor;

    public Drink(String description, double price, String size, String flavor) {
        super(description, price);
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String receipt() {
        return String.format(
                "Order: %s | Price: $%.2f | Size: %s | Flavor: %s",
                this.getDescription(),
                this.getPrice(),
                this.size,
                this.flavor
        );
    }
}
