package code.practives;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String BUZZ = "buzz";
    public static final String FIZZ = "fizz";
    public static final int FIZZ_NUMBER = 3;
    public static final int BUZZ_NUMBER = 5;

    String transform(int i) {
        if (isDividedBy(i, BUZZ_NUMBER) && isDividedBy(i, FIZZ_NUMBER)) {
            return FIZZ+BUZZ;
        }
        if (isDividedBy(i, FIZZ_NUMBER)) {
            return FIZZ;
        }
        if (isDividedBy(i, BUZZ_NUMBER)) {
            return BUZZ;
        }
        return String.valueOf(i);
    }

    private boolean isDividedBy(int number, int divisor) {
        return number % divisor == 0;
    }

    public List<String> countOff(int upLimit) {
        List<String> result = new ArrayList<>(upLimit);
        for (int i = 1; i < upLimit+1; i++) {
            result.add(transform(i));
        }
        return result;
    }
}
