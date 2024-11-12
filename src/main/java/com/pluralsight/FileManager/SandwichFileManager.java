package com.pluralsight.FileManager;

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
            String filenameFormat = localDateTime.format(formatter);

            String filename="./order/"+filenameFormat+".txt";

            //Creating a file writer and assigning the file writer to the buffered writer.
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(order);
            bw.close(); // Close the BufferedWriter

        } catch (IOException e){
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }

}
