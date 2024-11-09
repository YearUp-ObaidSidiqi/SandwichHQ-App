package com.pluralsight;

public abstract class SandwichHQItem implements IReceiptDescription {
    String description;
    double price;

    public SandwichHQItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
