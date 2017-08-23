package lesson1;

import java.io.*;

/**
 * Created by Viktoriya.D on 8/23/2017.
 */
public class TstStream1 {//File file = new File("D:/java_test_2/src/lesson1/where_I_can_find_Phone_field.txt");

    public static void main(String args[]) throws IOException {
        System.out.println("Start copy your data");
        InputStream inputStream = new FileInputStream("D:/java_test_2/src/lesson1/where_I_can_find_Phone_field.txt");
        OutputStream outputStream= new FileOutputStream("D:/java_test_2/src/lesson1/writer.txt") ;
        while (inputStream.available()>0){
            int data = inputStream.read();
            outputStream.write(data);
        }
        System.out.println("End copy your data");
        inputStream.close();
        outputStream.close();
    }
}
