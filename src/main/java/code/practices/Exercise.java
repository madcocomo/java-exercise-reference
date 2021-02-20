package code.practices;

public class Exercise {
    public static void main(String[] arg) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        for (String s : fizzBuzz.countOff(100)) {
            System.out.println(s);
        }
    }
}
