package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * 
 */
public class SubInstruction extends Instruction
{
    /**
     * 
     */
    private int operand;

    /** 
     * 
     */
    public SubInstruction(Interpreter interpreter, int operand, String name) 
    {
        super(interpreter, name);
        this.operand = operand;
    } 


    @Override
    public boolean execute() 
    {  
        interpreter.accumulator -= interpreter.registers[operand];
        return true;
    }
}
