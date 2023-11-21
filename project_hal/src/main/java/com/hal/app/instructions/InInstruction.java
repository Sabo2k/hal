package com.hal.app.instructions;

import java.util.Scanner;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

public class InInstruction extends Instruction 
{
    /**
     * 
     */
    private int operand;

    /**
     * 
     * @param interpreter
     */
    public InInstruction(Interpreter interpreter, int operand, String name) 
    {
        super(interpreter, name);
        this.operand = operand;
    }

    /**
     * 
     */
    @Override
    public boolean execute() 
    {
        System.out.println("Input IO " + operand + ": ");
        Scanner scanner = new Scanner(System.in);
        interpreter.accumulator = scanner.nextDouble();
        scanner.close();
        return true;
    }
        
}
