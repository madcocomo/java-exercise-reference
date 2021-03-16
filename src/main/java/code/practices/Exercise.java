package code.practices;

public class Exercise {
    public static void main(String[] arg) {
        try {
            Argument argument = new Argument(arg);
            ConsoleReader consoleReader = new ConsoleReader();
            FizzBuzz fizzBuzz = new FizzBuzz(new ConsolePrinter(), consoleReader);

            fizzBuzz.countOff(argument.getUpLimit());
        } catch (NumberFormatException e) {
            System.out.println("Argument Error: please input a number as up limit");
        }
    }

}
