import java.util.Scanner;

public class Main
{
    /**
     * colors:
     */
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";

    public static void printMenu()
    {
        System.out.println(YELLOW + "\n************************** Welcome to HAL Interpreter 2020 **************************\n");
        System.out.print( "[1] Normal Mode\n");
        System.out.println("[2] Debug Mode\n");
        System.out.println("Your Input: " + RESET);
    }

    public static void main(String[] argc)
    {
        final long start = System.currentTimeMillis(); // start counting time
        Interpreter interpreter = new Interpreter();
        interpreter.readFile("add.txt");
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String userinput = scanner.next(); // read user input

        if(userinput.equals("1"))
        {
            interpreter.build();
        }
        else if(userinput.equals("2"))
        {
            interpreter.debug();
        }
        else
        {
            System.out.println("\nInvalid input. Please type 1 or 2.\n");
        }

        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println("Runtime: " + sec + " seconds");
    }
}
