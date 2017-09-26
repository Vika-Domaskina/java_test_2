package lesson5;

import java.io.*;

/**
 * Created by Viktoriya.D on 9/26/2017.
 */
public class ExeptionsTask2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        InputStream fileInputStream = getInputStream(sourceFileName);//D:\java_new_2\java_test_2\src\lesson5\vika.txt
        OutputStream fileOutputStream = getOutputStream(destinationFileName);//D:\java_new_2\java_test_2\src\lesson5\vikaCopy.txt

        int size=fileInputStream.available();
        for (int i=0;i<size;i++) {
            int data =(char) fileInputStream.read();
            fileOutputStream.write(data);
            System.out.println((char) fileInputStream.read());
        }

        System.out.println("Скопировано байт " + size);

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}
