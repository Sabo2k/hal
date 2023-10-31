package com.hal.app;

/**
 * simple Pair-Class, which stores two values
 * See https://stackoverflow.com/a/4777636
 */
public class Instruction
{
    /**
     * contains the complete instruction with name and operand
     */
    private String instructionString;

    /**
     * Each instruction has a name
     */
    private String name;

    /**
     * An instruction can have an integer as operand (e.g. JUMP)
     */
    private int i_operand;
    
    /**
     * 
     */
    private double d_operand;

    /**
     * 
     */
    public Instruction()
    {
        this.instructionString = "UNDEFINED";
        this.name = "UNDEFINED";
        this.i_operand = 0;
        this.d_operand = 0.0;
    }

    /**
     * 
     * @param name
     * @param i_operand
     */
    public Instruction(String fullInstruction, String name, int i_operand)
    {
        this.instructionString = fullInstruction;
        this.name = name;
        this.i_operand = i_operand;
    }

    /**
     * 
     * @param name
     * @param d_operand
     */
    public Instruction(String fullInstruction, String name, double d_operand)
    {
        this.instructionString = fullInstruction;
        this.name = name;
        this.d_operand = d_operand;
    }

    public int getIntOperand()
    {
        return this.i_operand;
    }

    public double getDoubleOperand()
    {
        return this.d_operand;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setIntOperand(int i_operand)
    {
        this.i_operand = i_operand;
    }

    public void setDoubleOperand(double d_operand)
    {
        this.d_operand = d_operand;
    }

    public String getInstructionString() 
    {
        return this.instructionString;
    }

    public void setInstructionString(String full_instruction) 
    {
        this.instructionString = full_instruction;
    }

}
