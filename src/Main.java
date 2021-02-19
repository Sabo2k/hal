
public class Main
{
    public static void main(String[] argc)
    {
        Interpreter interpreter = new Interpreter();
        interpreter.readFile("performancetest.txt");
        interpreter.build();
    }
}
