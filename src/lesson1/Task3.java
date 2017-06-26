package lesson1;

import java.util.Scanner;

/**
 * Created by Viktoriya.D on 6/12/2017.
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println("Input text: ");
        Scanner scanner = new Scanner(System.in);
        String consoleInput = scanner.nextLine();
        String newString = replaceWords(consoleInput);
        System.out.println(newString);
    }

    static String replaceWords(String a) {
        return a.replace("e", "a");

    }
}
