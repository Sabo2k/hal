
public class Main
{
    /**
     * colors:
     */
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] argc)
    {
        final long start = System.currentTimeMillis(); // start counting time
        Interpreter interpreter = new Interpreter();
        interpreter.readFile("performancetest.txt");
        interpreter.build();
    }
}
