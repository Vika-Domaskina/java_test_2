package FileTasks;

import sun.security.util.Length;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by vika on 27.08.2017.
 */
public class FileIO {
    static File fileDB = new File("D:/java_test_2/src/FileTasks/db.txt");


    static String[] masivUsers;

    static public String[] readFile() throws IOException {
        String file = "";
        try (FileInputStream fileInputStream = new FileInputStream(fileDB)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                file = file + ((char) i);
            }

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
        masivUsers = file.split(";");
        return masivUsers;
    }

    static public void writeFile(HashMap dictionary) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileDB, false);
        System.out.println("write array!!");
        Set<Map.Entry<Integer, User>> set = dictionary.entrySet();  //Returns a Set view of the mappings contained in this map.
        for (Map.Entry<Integer, User> me : set) {
            System.out.print(me.getKey() + " : ");
            System.out.println(me.getValue());
            String string = me.getValue().toString();
            for (int i = 0; i < string.length(); i++) {
                fileOutputStream.write(string.charAt(i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile());
        //writeFile(dictionaryUsers);
    }
}
