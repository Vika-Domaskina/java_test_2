package FileTasks;

import java.io.*;
import java.util.*;

/**
 * Created by vika on 27.08.2017.
 */
public class FileIO {
    static File fileDB = new File("D:/java_test_2/src/FileTasks/db.txt");
    static HashMap dictionaryUsers = new HashMap<Integer, User>();

    static public HashMap readFile() throws IOException {
        String file = "";
        String[] masivUsers;
        try (FileInputStream fileInputStream = new FileInputStream(fileDB)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                file = file + ((char) i);
            }

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        masivUsers = file.split(";");
        dictionaryUsers.put(Integer.parseInt(masivUsers[0]), new User(Integer.parseInt(masivUsers[0]), masivUsers[1], masivUsers[2]));
        return dictionaryUsers;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile());
    }
}
