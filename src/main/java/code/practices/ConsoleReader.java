package code.practices;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public String readLine() {
        System.out.println("Please input you answer:");
        return scanner.nextLine();
    }
}
