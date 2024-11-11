package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SandwichFileManager {

    public static void creatingTheOrderReceipt (String order){
        try {

            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String filename = localDateTime.format(formatter);
            System.out.println(filename);

            String filename2=filename+".txt";

            //Creating a file writer and assigning the file writer to the buffered writer.
            FileWriter fw = new FileWriter(filename2);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(order);

            bw.close(); // Close the BufferedWriter

        } catch (IOException e){
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }

}
