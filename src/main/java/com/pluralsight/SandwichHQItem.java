package com.pluralsight;

public abstract class SandwichHQItem {
    String description;
    double price;

    public SandwichHQItem(){};
    public SandwichHQItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

}
