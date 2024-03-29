package com.hal.app;

import java.text.ParseException;
import java.util.Scanner;

/**
 * 
 */
public class Main
{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";

    /**
     * prints a small menu with two modes:
     * - Normal Mode: executes a *.txt-file with instructions
     * - Debug Mode: lets the User "step" through each instruction
     */
    public static void printMenu()
    {             
        System.out.println("\n================================= Main Menu ======================================");
        System.out.println("[1] Normal Mode");
        System.out.println("[2] Debug Mode");
        System.out.println("[3] Exit");
        System.out.println("Your Input: ");
    }

    /**
     * prompts the user to choose a menu option
     * @param interpreter
     * @throws ParseException
     */
    public static void handleMenuLoop(Interpreter interpreter) throws ParseException
    {
        // read User Input
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while(true)
        {
            printMenu();
            userInput = scanner.next();
            switch(userInput)
            {
                case "1":
                {
                    System.out.println("Please enter a file path: ");
                    String filePath = scanner.next();

                    interpreter.readFile(filePath);
                    
                    final long start = System.currentTimeMillis(); // start counting time
                    System.out.println(YELLOW + "Executing Instructions..." + RESET);
                    interpreter.executeAllInstructions();
                    System.out.println(GREEN + "Done!" + RESET);
                    interpreter.printComponentInfo();

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
                    scanner.close();
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println(RED + "\nInvalid input. Please try again.\n" + RESET);
                    break;
                }
            }
        }
    }
    
    /**
     * main function
     * @param argc
     * @throws ParseException
     */
    public static void main(String[] argc) throws ParseException
    {
        Interpreter interpreter = new Interpreter();
        handleMenuLoop(interpreter);
    }
}