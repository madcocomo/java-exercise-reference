package code.practices;

import java.util.List;

public class Exercise {
    public static void main(String[] arg) {
        try {
            Argument argument = new Argument(arg);
            FizzBuzz fizzBuzz = new FizzBuzz();
            printAll(fizzBuzz.countOff(argument.getUpLimit()));
        } catch (NumberFormatException e) {
            System.out.println("Argument Error: please input a number as up limit");
        }
    }

    private static void printAll(List<String> output) {
        for (String s : output) {
            System.out.println(s);
        }
    }
}
