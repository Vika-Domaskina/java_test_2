package lesson1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by vika on 27.08.2017.
 */
public class TstStream4 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:/java_test_2/src/lesson1/where_I_can_find_Phone_field.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("D:/java_test_2/src/lesson1/writer.txt");

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
