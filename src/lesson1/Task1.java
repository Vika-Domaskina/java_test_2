package lesson1;

import java.util.Scanner;

/**
 * Created by Viktoriya.D on 6/9/2017.
 */
public class Task1 {
    public static void main(String[] args) {
        double money, cours;
        money = readDoubleFromConsole("Input money:");
        cours = readDoubleFromConsole("Input course:");

        System.out.println("Your money:" + USD(money,cours));
        System.out.println("Random: " + USD(123.45, 12));

    }
    static double readDoubleFromConsole(String text){
        double money;
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        while (true) {

            try {
                money = Double.parseDouble(scanner.nextLine());
                if ((int) money < 0 || (int) money == 0 ) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(text);
            }
        }
        return money;
    }

    static double USD(double valuta, double cours) {
        return valuta * cours;
    }
}
