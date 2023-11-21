package com.hal.app;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * tests basic functionalities of the Interpreter
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
    private String filePath = "/home/sabo/dev/hal/project_hal/src/test.txt";

    /**
     * 
     * @throws ParseException
     */
    @Before
    public void setUp() throws ParseException
    {
        interpreter = new Interpreter();
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
     * @throws FileNotFoundException
     */
    @Test
    public void testReadFile() throws ParseException, FileNotFoundException
    {
        interpreter.readFile(filePath);
        assertEquals(15, interpreter.instructions.size());
    }

    /**
     * 
     */
    @Test 
    public void testExecuteSingleInstruction()
    {
        
    }

    /**
     * @throws ParseException
     * @throws FileNotFoundException
     * 
     */
    @Test
    public void testExecuteAllInstructions() throws ParseException, FileNotFoundException
    {
        interpreter.readFile(filePath);
        interpreter.executeAllInstructions();
        assertEquals(5.0, interpreter.registers[1], 0);
        assertEquals(6.0, interpreter.registers[2], 0);
        assertEquals(7.0, interpreter.registers[3], 0);
        assertEquals(8.0, interpreter.registers[4], 0);
        assertEquals(interpreter.accumulator, 64.0, 0);
        assertEquals(interpreter.programCounter, 15);
    }
}
