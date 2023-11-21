package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * 
 */
public class LoadNumInstruction extends Instruction
{
    /**
     * 
     */
    private double operand;

    /**
     * 
     * @param interpreter
     */
    public LoadNumInstruction(Interpreter interpreter, double operand, String name)
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
        interpreter.accumulator = operand;
        return true;
    }
}
