package code.practives;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

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
           "1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz"
       );
       assertEquals(expected, fizzBuzz.countOff(15));
    }
}
