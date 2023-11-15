package com.hal.app;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class InterpreterTest 
{
    /**
     * 
     */
    private Interpreter interpreter;

    /**
     * 
     */
    private String filePath = "project_hal/src/test.txt";

    /**
     * 
     * @throws ParseException
     */
    @Before
    public void setUp() throws ParseException
    {
        interpreter = new Interpreter();
        interpreter.readFile(filePath);
    }

    /**
     * 
     */
    @After
    public void tearDown()
    {
        interpreter = null;
    }

    /**
     * 
     * @throws ParseException
     */
    @Test
    public void testReadFile() throws ParseException
    {
        assertEquals(17, interpreter.instructions.size());
    }

    /**
     * 
     */
    @Test
    public void testPrintComponentInformation()
    {

    }

    /**
     * 
     */
    @Test 
    public void testExecuteSingleInstruction()
    {
        
    }

    /**
     * 
     */
    @Test
    public void testExecuteAllInstructions()
    {
        interpreter.executeAllInstructions();
        assertEquals(5.0, interpreter.registers[0], 0);
        assertEquals(6.0, interpreter.registers[1], 0);
        assertEquals(7.0, interpreter.registers[3], 0);
        assertEquals(8.0, interpreter.registers[4], 0);
        assertEquals(interpreter.accumulator, 64.0, 0);
    }
}
