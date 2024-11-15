package com.pluralsight.menu;

import com.pluralsight.pricing.PricingManager;
import com.pluralsight.core.SandwichHQItem;

public class Chips extends SandwichHQItem {

    String flavor;

    public Chips(String flavor) {
        super("Chips", PricingManager.getChipsPrice());
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
