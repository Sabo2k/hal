package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

public class AddNumInstruction extends Instruction 
{
    /**
     * 
     */
    private double operand;

    /**
     * 
     * @param interpreter
     * @param operand
     */
    public AddNumInstruction(Interpreter interpreter, double operand, String name) 
    {
        super(interpreter, name);
        this.operand = operand;
    }

    /**
     *  Adds a number to accumulator
     */
    @Override
    public boolean execute() 
    {
        interpreter.accumulator += operand;
        return true;
    }
    
}
