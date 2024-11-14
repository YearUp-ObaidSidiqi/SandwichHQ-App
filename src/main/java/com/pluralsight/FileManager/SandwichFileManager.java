package com.pluralsight.FileManager;

import com.pluralsight.SandwichHQItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SandwichFileManager {

    public static void creatingTheOrderReceipt(ArrayList<SandwichHQItem> orders) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String filenameFormat = localDateTime.format(formatter);

            String filename = "./order/" + filenameFormat + ".txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            // Header
            bw.write("           ** SandwichHQ Receipt **\n");
            bw.write("------------------------------------------\n");
            bw.write("  Date: " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            // Itemized orders
            double total = 0.0;
            for (SandwichHQItem order : orders) {
                bw.write(order.receipt() + "\n");
                bw.write("------------------------------------------\n");
                total += order.getPrice();
            }

            // Footer with total
            bw.write("\n  Total: $" + String.format("%.2f", total) + "\n");
            bw.write("  Thank you for dining with us!\n");
            bw.write("------------------------------------------\n");

            bw.close();
        } catch (IOException e) {
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }
}
