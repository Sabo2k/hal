package com.hal.app.instructions;

import com.hal.app.Instruction;
import com.hal.app.Interpreter;

public class JumpInstruction extends Instruction
{
    /**
     * 
     */
    private int operand;

    /**
     * 
     * @param interpreter
     */
    public JumpInstruction(Interpreter interpreter, int operand, String name)
    {
        super(interpreter, name);
    }

    /**
     * 
     */
    @Override
    public boolean execute() 
    {
        interpreter.programCounter = this.operand;
        return true;
    }
}
