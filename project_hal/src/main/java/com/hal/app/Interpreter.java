package com.hal.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

import com.hal.app.instructions.AddInstruction;
import com.hal.app.instructions.AddNumInstruction;
import com.hal.app.instructions.DivInstruction;
import com.hal.app.instructions.DivNumInstruction;
import com.hal.app.instructions.InInstruction;
import com.hal.app.instructions.JumpInstruction;
import com.hal.app.instructions.JumpNegInstruction;
import com.hal.app.instructions.JumpNullInstruction;
import com.hal.app.instructions.JumpPosInstruction;
import com.hal.app.instructions.LoadInstruction;
import com.hal.app.instructions.LoadNumInstruction;
import com.hal.app.instructions.MulInstruction;
import com.hal.app.instructions.MulNumInstruction;
import com.hal.app.instructions.OutInstruction;
import com.hal.app.instructions.StartInstruction;
import com.hal.app.instructions.StopInstruction;
import com.hal.app.instructions.StoreInstruction;
import com.hal.app.instructions.SubInstruction;
import com.hal.app.instructions.SubNumInstruction;

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
     * list of all instructions
     */
    public List<Instruction> instructions = new ArrayList<>();
    
    /**
     * Input and Output Unit
     */
    public double[] io_unit;
    
    /**
     * TRUE: interpreter is executing instructions 
     * FALSE: interpreter has no more instructions to execute
     */
    public boolean isRunning;
    
    /**
     * sets everything to default values
     */
    public Interpreter()
    {
        this.accumulator = 0;
        this.programCounter = 0;
        this.registers = new double[16];
        this.instructions = new ArrayList<Instruction>();
        this.io_unit = new double[2];
        this.isRunning = false;
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
                String instructionName = scanner.next();

                switch(instructionName)
                {
                    case "START":
                    {
                        instructions.add(new StartInstruction(this, instructionName));
                        break;
                    }
                    case "STOP":
                    {
                        instructions.add(new StopInstruction(this, instructionName));
                        break;
                    }
                    case "IN":
                    {
                        instructions.add(new InInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "OUT":
                    {
                        instructions.add(new OutInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "LOAD":
                    {
                        instructions.add(new LoadInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "LOADNUM":
                    {
                        instructions.add(new LoadNumInstruction(this, scanner.nextDouble(), instructionName));
                        break;
                    }
                    case "STORE":
                    {
                        instructions.add(new StoreInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "JUMPNEG":
                    {
                        instructions.add(new JumpNegInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "JUMPPOS":
                    {
                        instructions.add(new JumpPosInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "JUMPNULL":
                    {
                        instructions.add(new JumpNullInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "JUMP":
                    {
                        instructions.add(new JumpInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "ADD":
                    {
                        instructions.add(new AddInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "ADDNUM":
                    {
                        instructions.add(new AddNumInstruction(this, scanner.nextDouble(), instructionName));
                        break;
                    }
                    case "SUB":
                    {
                        instructions.add(new SubInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "SUBNUM":
                    {
                        instructions.add(new SubNumInstruction(this, scanner.nextDouble(), instructionName));
                        break;
                    }
                    case "MUL":
                    {
                        instructions.add(new MulInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "MULNUM":
                    {
                        instructions.add(new MulNumInstruction(this, scanner.nextDouble(), instructionName));
                        break;
                    }
                    case "DIV":
                    {
                        instructions.add(new DivInstruction(this, scanner.nextInt(), instructionName));
                        break;
                    }
                    case "DIVNUM":
                    {
                        instructions.add(new DivNumInstruction(this, scanner.nextDouble(), instructionName));
                        break;
                    }
                    default:
                    {
                        break;
                    }
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Could not find file: " + filePath + "\nPlease enter a valid file path");
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
        System.out.println("ACC: " + this.accumulator);
        System.out.println("PC: " + this.programCounter);
        System.out.println("IO 0: " + this.io_unit[0]);
        System.out.println("IO 1: " + this.io_unit[1]);
    }

    /**
     * executes all instructions
     */
    public void executeAllInstructions()
    {
        isRunning = true;

        while(isRunning)
        {
            executeSingleInstruction(instructions.get(this.programCounter));
        }
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
            executeSingleInstruction(instructions.get(this.programCounter));
            System.out.println("CURRENT INSTRUCTION: " + instructions.get(this.programCounter).name);
            System.out.println("Press S to continue:");

            Scanner scanner = new Scanner(System.in);

            if(scanner.next().equals("S"))
            {
                this.printComponentInfo(); // print all information
            }
            else
            {
                System.out.println(RED + "\nInvalid input. Please press S to step.\n" + RESET);
            }
        }
    }

    /**
     * increases the programCounter and executes a single instruction 
     * @param instruction Instruction-Object containing all information about the instruction
     */
    public void executeSingleInstruction(Instruction instruction)
    {
        instruction.execute();
        this.programCounter++;
    }
}