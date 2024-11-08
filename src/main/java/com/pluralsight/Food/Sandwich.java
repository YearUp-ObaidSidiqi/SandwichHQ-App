package com.pluralsight.Food;

import com.pluralsight.SandwichHQItem;

import java.util.ArrayList;

public class Sandwich extends SandwichHQItem {

    int size;
    String breadType;
    boolean isToasted;
    ArrayList<String> meat;
    ArrayList<String> cheese;
    ArrayList<String> otherTopping;
    ArrayList<String> sauce;

    public Sandwich(String description, double price, int size, String breadType,
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
}
