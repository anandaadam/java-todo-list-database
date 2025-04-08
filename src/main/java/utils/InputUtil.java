package utils;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);
    public static String input(String todo) {
        System.out.print(todo + ": ");
        String data = scanner.nextLine();
        return data;
    }
}
