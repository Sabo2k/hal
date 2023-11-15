package com.hal.app;

/**
 * 
 */
public class Instruction
{
    /**
     * contains the complete instruction with name and operand
     */
    private String fullInstruction;

    /**
     * Each instruction has a name
     */
    private String name;

    /**
     * An instruction can have an integer as operand (e.g. JUMP)
     */
    private int i_operand;
    
    /**
     * An instruction can have a double as operand (e.g. LOADNUM)
     */
    private double d_operand;

    /**
     * Standard constructor
     */
    public Instruction()
    {
        this.fullInstruction = null;
        this.name = null;
        this.i_operand = 0;
        this.d_operand = 0.0;
    }

    /**
     * constructor for an instruction with an Integer as operand
     * @param name
     * @param i_operand
     */
    public Instruction(String fullInstruction, String name, int i_operand)
    {
        this.fullInstruction = fullInstruction;
        this.name = name;
        this.i_operand = i_operand;
    }

    /**
     * constructor for an instruction with a Double as operand
     * @param name
     * @param d_operand
     */
    public Instruction(String fullInstruction, String name, double d_operand)
    {
        this.fullInstruction = fullInstruction;
        this.name = name;
        this.d_operand = d_operand;
    }

    /**
     * 
     * @return
     */
    public int getIntOperand()
    {
        return this.i_operand;
    }

    /**
     * 
     * @return
     */
    public double getDoubleOperand()
    {
        return this.d_operand;
    }

    /**
     * 
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * 
     * @param i_operand
     */
    public void setIntOperand(int i_operand)
    {
        this.i_operand = i_operand;
    }

    /**
     * 
     * @param d_operand
     */
    public void setDoubleOperand(double d_operand)
    {
        this.d_operand = d_operand;
    }

    /**
     * 
     * @return
     */
    public String getFullInstruction() 
    {
        return this.fullInstruction;
    }

    /**
     * 
     * @param full_instruction
     */
    public void setFullInstruction(String full_instruction) 
    {
        this.fullInstruction = full_instruction;
    }
}
