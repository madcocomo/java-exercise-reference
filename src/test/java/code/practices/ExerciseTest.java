package code.practices;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ExerciseTest {

    private PrintStream originalOut;
    private OutputStream out;

    @Before
    public void setUp() throws Exception {
        originalOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    @Test
    public void should_show_usage_when_argument_error() {
        Exercise.main(new String[]{"NA"});
        assertEquals("Argument Error: please input a number as up limit\n", out.toString());
    }
}