package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Viktoriya.D on 8/25/2017.
 */
public class TstStream3 {
    public static void main(String args[]) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("drgxdrgxdxdrgxd");
        printWriter.println(5);
        Integer ii = 534534;
        printWriter.println(ii);
        System.out.println("Input text: ");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] array = new String[100];
            for (int i = 0; i < 100; i++) {
                String temp = bufferedReader.readLine();
                if (temp.equals("stop")) {
                    break;
                }
                array[i] = temp;
            }
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);

            }
        } catch (IOException e){
            System.out.println("Program working inccorect");
        } finally {
            try {
                bufferedReader.close();
                System.out.println("Reader closed!");
            } catch (IOException t) {
                System.out.println("Reader not closed");
            }
        }
    }
}
