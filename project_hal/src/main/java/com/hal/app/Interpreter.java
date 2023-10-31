package com.hal.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

/**
 * The Interpreter processes instructions  
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
    public double accumulator;

    /**
     * the program counter is like a "pointer" to the instruction
     * it actually stores the linenumber of the Instruction
     */
    public int programCounter;
    
    /**
     * contains all the registers of HAL where stuff can be stored
     */
    public double[] registers;
    
    /**
     * each Instruktion has a name and 1 or 0 operand(s)
     */
    public ArrayList<Instruction> instructions;
    
    /**
     * Input and Output Unit
     */
    public double[] io_unit;
    
    /**
     * 
     */
    public boolean isRunning;
    
    /**
     * standard constructor sets everything to default value
     */
    public Interpreter()
    {
        this.accumulator = 0;
        this.programCounter = 0;
        this.registers = new double[16];
        this.instructions = new ArrayList<Instruction>();
        this.io_unit = new double[2];
    }

    /**
     * reads the file containing all the instructions for HAL
     * and converts them to Instruction objects
     * @param filepath contains instructions
     * @throws ParseException
     */
    void readFile(String filePath) throws ParseException
    {
        try
        {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                Instruction instruction = new Instruction();
                instruction.setName(scanner.next());

                if(scanner.hasNextInt())
                {
                    instruction.setIntOperand(Integer.parseInt(scanner.next()));
                }
                else if(scanner.hasNextDouble())
                {
                    instruction.setDoubleOperand(Double.parseDouble(scanner.next()));
                }

                this.instructions.add(instruction);
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    /**
     * prints the value of each component
     */
    public void printComponentInfo() 
    {
        System.out.println("========================== Component Info ==========================");
        for(int i = 0; i < this.registers.length; i++)
        {
            System.out.println("Register " + i + ": " + this.registers[i]);
        }
        System.out.println(GREEN + "ACC: " + this.accumulator + RESET);
        System.out.println(CYAN + "PC: " + this.programCounter + RESET);
        System.out.println("IO 0: " + this.io_unit[0]);
        System.out.println("IO 1: " + this.io_unit[1]);
        System.out.println("====================================================================");
    }

    /**
     * executes all instructions
     */
    public void executeAllInstructions()
    {
        isRunning = true;
        while(isRunning)
        {
            executeInstruction(instructions.get(this.programCounter));
        }
        printComponentInfo();
    }

    /**
     * Debug-Mode, which enables the User to 
     * go through a script instruction by 
     * instruction
     */
    public void runDebugMode()
    {
        isRunning = true;
        while(isRunning)
        {
            executeInstruction(instructions.get(this.programCounter));
            System.out.println("CURRENT INSTRUCTION: " + instructions.get(this.programCounter).getName());
            System.out.println("Press S to continue:");

            Scanner scanner = new Scanner(System.in);

            if(scanner.next().equals("s")) // then step
            {
                this.printComponentInfo(); // print all information
            }
            else
            {
                System.out.println(RED + "\nInvalid input. Press s to step.\n" + RESET);
            }
        }
    }

    /**
     * executes one instruction
     * @param instruction instruction-object
     */
    public void executeInstruction(Instruction instruction)
    {
        this.programCounter++;

        if(instruction.getIntOperand() != 0)
        {
            // print current instruction with int
            System.out.println(YELLOW + "CURRENT INSTRUCTION: " + instruction.getName() + 
                               " " + instruction.getIntOperand() + RESET); 
        }
        else
        {
            //  print current instruction with double 
            System.out.println(YELLOW + "CURRENT INSTRUCTION: " + instruction.getName() + 
                               " " + instruction.getIntOperand() + RESET); 
        }

        switch(instruction.getName())
        {
            case "START":
            {
                this.isRunning = true;
                break;
            }
            case "STOP":
            {
                this.isRunning = false;
                break;
            }
            case "OUT":
            {
                this.io_unit[instruction.getIntOperand()] = this.accumulator;
                break;
            }
            case "IN":
            {
                System.out.println("Input IO " + instruction.getIntOperand() + ": ");
                Scanner scanner = new Scanner(System.in);
                this.accumulator = scanner.nextDouble();
                scanner.close();
                break;
            }
            case "LOAD":
            {
                this.accumulator = this.registers[instruction.getIntOperand()];
                break;
            }
            case "LOADNUM":
            {
                this.accumulator = instruction.getDoubleOperand();
                break;
            }
            case "STORE":
            {
                this.registers[instruction.getIntOperand()] = this.accumulator;
                break;
            }
            case "JUMPNEG":
            {
                if(this.accumulator < 0.0)
                {
                    this.programCounter = instruction.getIntOperand();
                }
                break;
            }
            case "JUMPPOS":
            {
                if(this.accumulator >= 0.0)
                {
                    this.programCounter = instruction.getIntOperand();
                }
                break;
            }
            case "JUMPNULL":
            {
                if(this.accumulator == 0.0)
                {
                    this.programCounter = instruction.getIntOperand();
                }
                break;
            }
            case "JUMP":
            {
                this.programCounter = instruction.getIntOperand();
                break;
            }
            case "ADD":
            {
                this.accumulator += registers[instruction.getIntOperand()];
                break;
            }
            case "ADDNUM":
            {
                this.accumulator += instruction.getDoubleOperand();
                break;
            }
            case "SUB":
            {
                this.accumulator -= registers[instruction.getIntOperand()];
                break;
            }
            case "MUL":
            {
                this.accumulator *= registers[instruction.getIntOperand()];
                break;
            }
            case "DIV":
            {
                this.accumulator /= registers[instruction.getIntOperand()];
                break;
            }
            case "MULNUM":
            {
                this.accumulator *= instruction.getDoubleOperand();
                break;
            }
            case "DIVNUM":
            {
                this.accumulator /= instruction.getDoubleOperand();
                break;
            }
            case "SUBNUM":
            {
                this.accumulator -= instruction.getDoubleOperand();
                break;
            }
            default:
            {
                break;
            }
        }
    }
}

