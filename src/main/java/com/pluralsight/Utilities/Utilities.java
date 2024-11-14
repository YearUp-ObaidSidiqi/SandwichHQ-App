package com.pluralsight.Utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utilities {

    static Scanner scanner = new Scanner(System.in);

    public static int PromptForInt(String prompt){
        System.out.print(prompt);
        String userInputs = scanner.nextLine();
        int userinput =Integer.parseInt(userInputs);
        return userinput;
    }
    public static ArrayList<Integer> PromptForArrayInt(String prompt){
        System.out.print(prompt);
        String userInputs = scanner.nextLine();
        String [] p = (userInputs.split(Pattern.quote(",")));
        ArrayList<Integer> l = new ArrayList<>();
        for ( int q = 0; q < p.length; q++){
            l.add(Integer.parseInt(p[q]));
        }
        return l;
    }

    public static boolean PromptForYesNo(String prompt){
        System.out.print(prompt + " (Enter Y, Yes, or 1 for [Yes]; N, No, or 2 for [No]): ");
        String userinput = scanner.nextLine();
        return
                (userinput.equalsIgnoreCase("Y")||
               userinput.equalsIgnoreCase("YES")||
                userinput.equalsIgnoreCase("1"));
    }
    public static boolean PromptForYesNo(){
        System.out.print(" (Enter Y, Yes, or 1 for [Yes]; N, No, or 2 for [No]): ");
        String userinput = scanner.nextLine();

        return
                (
                        userinput.equalsIgnoreCase("Y")||
                                userinput.equalsIgnoreCase("YES")||
                                userinput.equalsIgnoreCase("1")
                );

    }
    public static void printStarsForSpacing() {
        System.out.println("\n");

        // Top border of stars
        for(int i = 0; i < 2; i++)
            System.out.println("***************************************");

        // Middle section with spaces for "Year Up"
        for(int j = 0; j < 4; j++)
            System.out.println("**********   Y E A R   U P   **********");

        // More stars to complete the block
        for (int k = 0; k < 2; k++)
            System.out.println("***************************************");

        // Additional rows with decorative star patterns
        for(int l = 0; l < 1; l++)
            System.out.println("*********   ****************   ********");

        for(int m = 0; m < 1; m++)
            System.out.println("************   **********   ***********");

        for (int n = 0; n < 1; n++)
            System.out.println("******************    *****************");

        // Bottom border of stars
        for(int o = 0; o < 2; o++)
            System.out.println("***************************************");

        System.out.println("\n");
    }

}