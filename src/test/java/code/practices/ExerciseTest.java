package code.practices;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

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

    @Test
    public void should_ask_input_and_end_game_for_wrong_answer() {
        mockInput("2\n");
        Exercise.main(new String[]{"3"});
        assertEquals("Please input you answer:\nWrong answer. Game over.\n", out.toString());
    }

    @Test
    public void should_ask_input_and_count_to_limit_number_when_right() {
        mockInput("1\n");
        Exercise.main(new String[]{"3"});
        assertEquals("Please input you answer:\n1\n2\nfizz\n", out.toString());
    }

    private void mockInput(String input) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteArrayInputStream);
    }
}