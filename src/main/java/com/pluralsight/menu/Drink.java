package com.pluralsight.menu;
import com.pluralsight.pricing.PricingManager;
import com.pluralsight.core.SandwichHQItem;

public class Drink extends SandwichHQItem {

    String size;
    String flavor;

    public Drink(int size, String flavor) {
        super("Drink", calculateDrinkPrice(size));
        this.size = size(size);
        this.flavor = flavor;
    }

    private String size(int size) {
        return switch (size) {
            case 1 -> "small";
            case 2 -> "medium";
            case 3 -> "large";
            default -> throw new IllegalStateException("Unexpected value: " + size);
        };
    }

    public static double calculateDrinkPrice(int size){
        return
                switch (size){
                    case 1 ->  PricingManager.getSmallDrinkPrice();
                    case 2 -> PricingManager.getMediumDrinkPrice();
                    case 3 -> PricingManager.getLargeDrinkPrice();
                    default -> throw new IllegalStateException("Unexpected value: ");
                };
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