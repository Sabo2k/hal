package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

/**
 *  Starts the program
 */
public class StartInstruction extends Instruction 
{
    /**
     * 
     * @param interpreter
     */
    public StartInstruction(Interpreter interpreter, String name) 
    {
        super(interpreter, name);
    }

    /**
     * 
     * @return
     */
    @Override
    public boolean execute() 
    {
        this.interpreter.isRunning = true;
        return true;
    }
}