package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 * Stops the program
 */
public class StopInstruction extends Instruction
{
    /**
     * 
     * @param interpreter
     */
    public StopInstruction(Interpreter interpreter, String name) 
    {
        super(interpreter, name);
    }

    /**
     * 
     */
    @Override
    public boolean execute() 
    {
        this.interpreter.isRunning = false;
        return true;
    }
}
