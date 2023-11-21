package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * 
 */
public class SubNumInstruction extends Instruction
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
    public SubNumInstruction(Interpreter interpreter, double operand, String name) 
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
        interpreter.accumulator -= operand;
        return true;
    }
}