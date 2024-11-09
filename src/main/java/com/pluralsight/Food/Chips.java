package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

public class Chips extends SandwichHQItem {

    String flavor;

    public Chips(String description, double price, String flavor) {
        super(description, price);
        this.flavor = flavor;
    }


    @Override
    public String receipt() {
        return String.format(
                "Order: %s | Price: $%.2f | Flavor: %s",
                this.getDescription(),
                this.getPrice(),
                this.flavor
        );
    }
}
