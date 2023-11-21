package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * 
 */
public class StoreInstruction extends Instruction
{
    /**
     * 
     */
    private int operand;

    /**
     * 
     * @param interpreter
     * @param operand
     */
    public StoreInstruction(Interpreter interpreter, int operand, String name) 
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
        interpreter.registers[operand] = interpreter.accumulator;
        return true;
    }
        
}
