package src.utils;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // consume newline if needed
        return scanner.nextLine();
    }
}
