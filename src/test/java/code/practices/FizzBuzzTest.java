package code.practices;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    static class TestPrinter extends ConsolePrinter {
        private final List<String> allOutput = new ArrayList<>();
        @Override
        public void print(String output) {
            allOutput.add(output);
        }

        public List<String> getAllOutput() {
            return allOutput;
        }
    }

    static class TestReader extends ConsoleReader {
        private int readTimes;
        private List<String> input;

        public TestReader() {
            input = new ArrayList<>();
            input.add("1");
            input.add("11");
        }

        @Override
        public String readLine() {
            readTimes++;
            return input.remove(0);
        }

        public int getReadTimes() {
            return readTimes;
        }

        public void setTestInput(String... inputs) {
            input.clear();
            input.addAll(Arrays.asList(inputs));
        }
    }

    private final TestPrinter printer = new TestPrinter();
    private final TestReader reader = new TestReader();
    FizzBuzz fizzBuzz = new FizzBuzz(printer, reader);

    @Test
    public void should_transform_3_to_fizz() {
        assertEquals("fizz", fizzBuzz.transform(3));
        assertEquals("fizz", fizzBuzz.transform(12));
    }

    @Test
    public void should_transform_5_to_buzz() {
        assertEquals("buzz", fizzBuzz.transform(5));
        assertEquals("buzz", fizzBuzz.transform(10));
    }

    @Test
    public void should_transform_15_to_fizzbuzz() {
        assertEquals("fizzbuzz", fizzBuzz.transform(15));
        assertEquals("fizzbuzz", fizzBuzz.transform(60));
    }

    @Test
    public void should_not_transform_normal_number() {
        assertEquals("7", fizzBuzz.transform(7));
    }

    @Test
    public void should_count_off_to_up_limit_and_transform() {
       List<String> expected = Arrays.asList(
           "1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"
       );
       fizzBuzz.countOff(15);
       assertEquals(expected, printer.getAllOutput());
    }

    @Test
    public void should_stop_counting_when_read_wrong_answer() {
        reader.setTestInput("fizz");
        fizzBuzz.countOff(15);
        assertEquals(1, reader.getReadTimes());
    }

    @Test
    public void should_continue_read_answer_until_end() {
        reader.setTestInput("1", "11", "fizz", "31");
        fizzBuzz.countOff(35);
        assertEquals(4, reader.getReadTimes());
    }
}
