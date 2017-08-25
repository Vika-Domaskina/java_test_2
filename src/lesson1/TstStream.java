package lesson1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Viktoriya.D on 8/23/2017.
 */
public class TstStream {
    public static void main(String args[]) throws IOException {
        System.out.println("Input file name please: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(br);
        File file = new File(scanner.nextLine());
        //File file = new File("D:/java_test_2/src/BigGame/where_I_can_find_Phone_field.txt");
        try (  FileInputStream fileInputStream = new FileInputStream(file)) {

            System.out.println("File size:" + fileInputStream.available());
            int size = fileInputStream.available();
            for (int i = 0; i < size; i++) {
                System.out.print((char) fileInputStream.read());
            }
            System.out.println(" ");
            System.out.println("Name your file: " + file.getName());
        } catch (FileNotFoundException t) {
            System.out.println("Wrong file name!");
        } catch (IOException e) {
            System.out.println("Failed!");
        } finally {
            try {
                br.close();
            } catch (IOException r) {
                System.out.println("Stream not closed. Something wrong!BUT FILE CLOSED!!!");
            }
        }
    }
}
