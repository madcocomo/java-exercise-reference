package code.practices;

public class FizzBuzz {

    public static final String BUZZ = "buzz";
    public static final String FIZZ = "fizz";
    public static final int FIZZ_NUMBER = 3;
    public static final int BUZZ_NUMBER = 5;
    public static final int PLAYER_POISTION = 1;
    public static final int PLAYER_NUMBERS = 10;
    private final ConsolePrinter printer;
    private final ConsoleReader reader;

    public FizzBuzz(ConsolePrinter printer, ConsoleReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

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

    public void countOff(int upLimit) {
        for (int i = 1; i < upLimit+1; i++) {
            String transformed = transform(i);
            if (isPlayersTurn(i) && playerNotAnswer(transformed)) {
                return;
            }
            printer.print(transformed);
        }
    }

    private boolean playerNotAnswer(String transformed) {
        String answer = reader.readLine();
        if (!answer.equals(transformed)) {
            printer.print("Wrong answer. Game over.");
            return true;
        }
        return false;
    }

    private boolean isPlayersTurn(int i) {
        return i % PLAYER_NUMBERS == PLAYER_POISTION;
    }
}
