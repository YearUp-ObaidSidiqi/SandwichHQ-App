package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│ Welcome to SandwichHQ!                 │");
            System.out.println("│ 1) New Order                           │");
            System.out.println("│ 0) Exit                                │");
            System.out.println("└────────────────────────────────────────┘");
            System.out.print("Please select your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                while (true) {
                    System.out.println("┌────────────────────────────────────────┐");
                    System.out.println("│ Order Screen                           │");
                    System.out.println("│ 1) Add Sandwich                        │");
                    System.out.println("│ 2) Add Drink                           │");
                    System.out.println("│ 3) Add Chips                           │");
                    System.out.println("│ 4) Checkout                            │");
                    System.out.println("│ 0) Cancel Order                        │");
                    System.out.println("└────────────────────────────────────────┘");
                    System.out.print("Please select your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 0) {
                        System.out.println("Order canceled. Returning to home screen...");
                        break;
                    } else if (choice == 1) {
                        addSandwich();
                    } else if (choice == 2) {
                        addDrink();
                    } else if (choice == 3) {
                        addChips();
                    } else if (choice == 4) {
                        checkout();
                        break;
                    }
                }
            }
        }

        scanner.close();
    }

    public static void addSandwich() {
        System.out.println("┌──────────────┐");
        System.out.println("│ Add Sandwich │");
        System.out.println("└──────────────┘");

    }

    public static void addDrink() {
        System.out.println("┌────────────┐");
        System.out.println("│ Add Drink  │");
        System.out.println("└────────────┘");

    }

    public static void addChips() {
        System.out.println("┌────────────┐");
        System.out.println("│ Add Chips  │");
        System.out.println("└────────────┘");

    }

    public static void checkout() {
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│ Order Checkout                         │");
        System.out.println("└────────────────────────────────────────┘");

    }

}