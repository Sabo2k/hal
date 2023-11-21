package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * 
 */
public class DivInstruction extends Instruction
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
    public DivInstruction(Interpreter interpreter, int operand, String name) 
    {
        super(interpreter, name);
    }

    /**
     * 
     */
    @Override
    public boolean execute() 
    {
        interpreter.accumulator /= interpreter.registers[operand];
        return true;
    }
}