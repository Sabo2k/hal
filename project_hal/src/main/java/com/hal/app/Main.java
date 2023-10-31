package com.hal.app;

import java.text.ParseException;
import java.util.Scanner;

public class Main
{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    /**
     * prints a small menu with two modes:
     * - Normal Mode: executes a *.txt-file with instructions
     * - Debug Mode: lets the User "step" through each instruction
     */
    public static void printMenu()
    {             
        System.out.println("\n================================= Main Menu ======================================");
        System.out.print("[1] Normal Mode\n");
        System.out.println("[2] Debug Mode");
        System.out.println("[3] Exit");
        System.out.println("===================================================================================");
        System.out.println("Your Input: ");
    }

    /**
     * 
     * @param argc
     * @throws ParseException
     */
    public static void main(String[] argc) throws ParseException
    {
        Interpreter interpreter = new Interpreter();

        printMenu();
        
        // read User Input
        Scanner scanner = new Scanner(System.in);
        String userinput = scanner.next();

        switch(userinput)
        {
            case "1":
            {
                System.out.println("Please enter a file path: ");
                String filePath = scanner.next();
                interpreter.readFile(filePath);
                final long start = System.currentTimeMillis(); // start counting time

                interpreter.executeAllInstructions();

                long end = System.currentTimeMillis();
                float sec = (end - start) / 1000F;
                System.out.println("Runtime: " + sec + " seconds");
                break;
            }
            case "2":
            {
                System.out.println("Please enter a file path: ");
                String filePath = scanner.next();
                interpreter.readFile(filePath);
                interpreter.runDebugMode();
                break;
            }
            case "3":
            {
                break;
            }
            default:
            {
                System.out.println(RED +"\nInvalid input. Please try again.\n" + RESET);
                break;
            }
        }
        scanner.close();
    }
}
