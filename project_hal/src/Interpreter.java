import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The Interpreter is the actual processor of the instrucitons  
 */
public class Interpreter
{
    /**
     * colors for the output
     */
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    /**
     * the accumulator stores results from operations such as "ADDNUM" etc.
     */
    public double acc;
    
    /**
     * the program counter is like a "pointer" to the instruction
     * it actually stores the linenumber of the Instruction
     */
    public int pc;
    
    /**
     * contains all the registers of HAL where stuff can be stored
     */
    public double[] registers;
    
    /**
     * contains all the Instructions HAL needs to execute
     */
    public ArrayList<Instruction> instructions;
    
    /**
     * Input and Output Unit
     */
    public double[] IO;
    
    /**
     * 
     */
    public boolean status;
    
    /**
     * standard constructor sets everything to default value
     */
    public Interpreter()
    {
        this.acc = 0;
        this.pc = 0;
        this.registers = new double[16];
        this.instructions = new ArrayList<Instruction>();
        this.IO = new double[2];
    }

    /**
     * reads the file containing all the instructions for HAL
     * and converts them to Instruction objects. 
     */
    void readFile(String f)
    {
        try
        {
            Scanner s = new Scanner(new File(f));
            Instruction start = new Instruction(); // first Instruction is always "START"
            start.line = Integer.parseInt(s.next()); // read line number
            start.instructionname = s.next(); // read "START"
            this.instructions.add(start); // save that instruction

            while(s.hasNextLine()) // while there is a line to read:
            {
                Instruction operation = new Instruction(); // new instruction
                operation.line = Integer.parseInt(s.next()); // read line number
                operation.instructionname = s.next(); // read instruction

                if(operation.instructionname.equals("STOP")) // if that instruction was "STOP"...
                {
                    if(!s.hasNextLine()) // ...and there is no instruction after that
                    {
                        this.instructions.add(operation); // save that instruction
                        break; // and stop reading
                    }
                    this.instructions.add(operation); // else save this instruction
                    s.nextLine(); // go to next line
                    continue; // and keep reading
                }
                if(s.hasNextInt()) // if there is an Integer after the instruction:
                {
                    operation.i_operand = Integer.parseInt(s.next()); // save operator as integer
                } else if(s.hasNext()) // else it's a double
                {
                    operation.f_operand = Double.parseDouble(s.next()); // save operator as double
                }
                operation.determineInstruction();
                this.instructions.add(operation); // save complete instruction
                if(!s.hasNextLine())
                {
                    break;
                }
                s.nextLine();
            }

            s.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * prints all information about the Interpreter
     */
    public void print() // print all information about the Interpreter
    {
        for(int i = 0; i < this.registers.length; i++)
        {
            System.out.println( "Register " + i + ": " + this.registers[i]);
        }
        System.out.println(GREEN + "ACC: " + this.acc + RESET);
        System.out.println(CYAN +"PC: " + this.pc + RESET);
        System.out.println("IO 0: " + this.IO[0]);
        System.out.println("IO 1: " + this.IO[1]);
        System.out.println(" \n\n");
    }
    
    /**
     * whereever the pc is, get the instruction
     */
    public Instruction fetchInstr() 
    {
        return this.instructions.get(this.pc);
    }

    /**
     *  executes all instructions
     */
    public void build()
    {
        while(this.status != true)
        {
            this.execInstr(fetchInstr());
        }
        this.print();
    }

    /**
     * debug mode similar to that of an IDE
     */
    public void debug()
    {
        while(this.status != true)
        {
            System.out.println("Type s to step");
            Scanner eingabe2 = new Scanner(System.in); // Stepinput
            if(eingabe2.next().equals("s")) // then step
            {
                this.execInstr(this.fetchInstr()); // execute instruction
                this.print(); // print all information
            }
            else
            {
                System.out.println(RED + "\nInvalid input. Press s to step!\n" + RESET);
            }
        }
    }

    /**
     * executes one single instruction
     */
    public void execInstr(Instruction instr) 
    {
        this.pc++;
        if(instr.i_operand != 0)
        {
            System.out.println(YELLOW + "CURRENT INSTRUCTION: " + instr.instructionname + " " + instr.i_operand + RESET); // print current instruction with int
        }
        else
        {
            System.out.println(YELLOW + "CURRENT INSTRUCTION: " + instr.instructionname + " " + instr.f_operand + RESET); //  print current instruction with float 
        }

        switch(instr.instructionname) // instruction set
        {
            case "START":
            {
                this.status = false;
                break;
            }
            case "STOP":
            {
                this.status = true;
                break;
            }
            case "OUT":
            {
                this.IO[instr.i_operand] = this.acc;
                break;
            }
            case "IN":
            {
                System.out.println("EINGABE IO " + instr.i_operand + ": ");
                Scanner s = new Scanner(System.in);
                this.acc = s.nextDouble();
                break;
            }
            case "LOAD":
            {
                this.acc = this.registers[instr.i_operand];
                break;
            }
            case "LOADNUM":
            {
                this.acc = instr.f_operand;
                break;
            }
            case "STORE":
            {
                this.registers[instr.i_operand] = this.acc;
                break;
            }
            case "JUMPNEG":
            {
                if(this.acc < 0.0)
                {
                    this.pc = instr.i_operand;
                }
                break;
            }
            case "JUMPPOS":
            {
                if(this.acc >= 0.0)
                {
                    this.pc = instr.i_operand;
                }
                break;
            }
            case "JUMPNULL":
            {
                if(this.acc == 0.0)
                {
                    this.pc = instr.i_operand;
                }
                break;
            }
            case "JUMP":
            {
                this.pc = instr.i_operand;
                break;
            }
            case "ADD":
            {
                this.acc += registers[instr.i_operand];
                break;
            }
            case "ADDNUM":
            {
                this.acc += instr.f_operand;
                break;
            }
            case "SUB":
            {
                this.acc -= registers[instr.i_operand];
                break;
            }
            case "MUL":
            {
                this.acc *= registers[instr.i_operand];
                break;
            }
            case "DIV":
            {
                this.acc /= registers[instr.i_operand];
                break;
            }
            case "MULNUM":
            {
                this.acc *= instr.f_operand;
                break;
            }
            case "DIVNUM":
            {
                this.acc /= instr.f_operand;
                break;
            }
            case "SUBNUM":
            {
                this.acc -= instr.f_operand;
                break;
            }
            default:
            {
                break;
            }
        }
    }
}

