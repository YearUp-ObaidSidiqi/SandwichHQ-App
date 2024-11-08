package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

public class Drink extends SandwichHQItem {

    int size;
    String flavor;

    public Drink(String description, double price, int size, String flavor) {
        super(description, price);
        this.size = size;
        this.flavor = flavor;
    }
}
