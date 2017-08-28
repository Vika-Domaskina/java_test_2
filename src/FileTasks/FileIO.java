package FileTasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        for (int i = 0; i < masivUsers.length; i = i + 3) {
            dictionaryUsers.put(Integer.parseInt(masivUsers[i + 0]), new User(Integer.parseInt(masivUsers[i + 0]), masivUsers[i + 1], masivUsers[i + 2]));
        }
        return dictionaryUsers;
    }

    static public void writeFile(HashMap dictionary) throws IOException {
        System.out.println("write array!!");
        Set<Map.Entry<Integer, User>> set = dictionary.entrySet();  //Returns a Set view of the mappings contained in this map.
        for (Map.Entry<Integer, User> me : set) {
            System.out.print(me.getKey() + " : ");
            System.out.println(me.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile());
        writeFile(dictionaryUsers);
    }
}
