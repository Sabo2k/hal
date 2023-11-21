package com.hal.app;

/**
 * 
 * See https://refactoring.guru/design-patterns/command/java/example
 */
public abstract class Instruction
{
    /**
     * an instruction has a name (e.g. START, ADD, SUB, etc.)
     */
    public String name;

    /**
     * interpreter-object, the instruction is executed on
     */
    public Interpreter interpreter;

    /**
     * 
     * @param interpreter interpreter object
     * @param name name of the instruction
     */
    public Instruction(Interpreter interpreter, String name)
    {
        this.interpreter = interpreter;
        this.name = name;
    }

    /**
     * each instruction has a specific way of execution
     * @return
     */
    public abstract boolean execute();
}
