package lesson5;

import java.util.Scanner;

/**
 * Created by Viktoriya.D on 9/26/2017.
 */
public class ExeptionTasks {
    public void divisionByZero(int a, int b) {
        int s = a / b;
        System.out.println("a/b = " + a + "/" + b + "=" + s);
    }

    public void readData() {
        String sum="";
        try {
            while(true){
                System.out.println("Input text: ");
                Scanner scanner = new Scanner(System.in);
                String consoleInput = scanner.nextLine();
                sum=sum+Integer.valueOf(consoleInput)+"\n";
                System.out.println(sum);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input right number" + e);
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        try {
            new ExeptionTasks().divisionByZero(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero :" + e);
        }
        for (int i = 10; i >= 0; i--) {

            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new ExeptionTasks().readData();
    }
}
