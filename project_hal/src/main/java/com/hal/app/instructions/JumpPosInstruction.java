package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

public class JumpPosInstruction extends Instruction
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
    public JumpPosInstruction(Interpreter interpreter, int operand, String name) 
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
        if(interpreter.accumulator >= 0.0)
        {
            interpreter.programCounter = operand;
            return true;
        }
        return false;
    }
}
