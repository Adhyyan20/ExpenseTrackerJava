package src.utils;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // flush newline
        return scanner.nextLine();
    }
}

