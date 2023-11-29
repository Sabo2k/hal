package com.hal.app;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
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
     * interpreter object containing all memory information
     */
    private Interpreter interpreter;

    /**
     * file containing various instructions for test purposes
     */
    private String filePath = "/home/sabo/dev/hal/project_hal/src/test.txt";

    /**
     * prepares everything for the test case,
     * called before every test case
     * @throws ParseException
     */
    @Before
    public void setUp() throws ParseException
    {
        interpreter = new Interpreter();
    }

    /**
     * deletes all data created for the test case, 
     * called after every test case
     */
    @After
    public void tearDown()
    {
        interpreter = null;
    }

    /**
     * checks, whether the correct amount of  
     * instructions was read
     * @throws FileNotFoundException
     */
    @Test
    public void testReadFile() throws ParseException, FileNotFoundException
    {
        interpreter.readFile(filePath);
        assertEquals(15, interpreter.instructions.size());
    }

    /**
     * executes the instructions of the test-file   
     * and evaluates its results 
     * @throws ParseException
     * @throws FileNotFoundException
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
