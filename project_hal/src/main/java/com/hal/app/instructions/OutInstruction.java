package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * 
 */
public class OutInstruction extends Instruction 
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
    public OutInstruction(Interpreter interpreter, int operand, String name) 
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
        interpreter.io_unit[operand] = interpreter.accumulator;
        return true;
    }
}
