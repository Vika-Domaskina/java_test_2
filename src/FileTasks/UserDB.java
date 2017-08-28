package FileTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Viktoriya.D on 8/28/2017.
 */
public class UserDB {
    public static ConsoleReader consoleReader = new ConsoleReader();
    public static FileIO fileIO = new FileIO();
    public static String statementNumber = "";
    static HashMap dictionaryUsers = new HashMap<Integer, User>();
    static ArrayList<Integer> idUsers = new ArrayList<>();

    public static HashMap createDictionaryUsers() throws IOException {
        fileIO.readFile();
        for (int i = 0; i < fileIO.masivUsers.length; i = i + 3) {
            dictionaryUsers.put(Integer.parseInt(fileIO.masivUsers[i + 0]), new User(Integer.parseInt(fileIO.masivUsers[i + 0]), fileIO.masivUsers[i + 1], fileIO.masivUsers[i + 2]));
            idUsers.add(Integer.parseInt(fileIO.masivUsers[i + 0]));
        }
        return dictionaryUsers;
    }

    public static String chooseStatement() {
        System.out.println("Choose statement: ");
        statementNumber = consoleReader.readConsole();
        while (true) {
            if (statementNumber.equals("0")) {
                System.out.println("There should be select statement");
                break;
            } else if (statementNumber.equals("1")) {
                System.out.println("There should be insert statement");
                break;
            } else if (statementNumber.equals("2")) {
                System.out.println("There should be update statement");
                break;
            } else if (statementNumber.equals("3")) {
                System.out.println("There should be delete statement");
                break;
            } else {
                System.out.println("Choose right number!");
                statementNumber = consoleReader.readConsole();
            }
        }
        return statementNumber;
    }


    public static void checkValidationID() {
        System.out.println("you should input ID at first! ");
        statementNumber = consoleReader.readConsole();
        if (Integer.parseInt(statementNumber) > 0 && Integer.parseInt(statementNumber) < 1000000000) {
            System.out.println("ID your user: " + statementNumber);
        }
    }

    public static void checkValidationName() {
        System.out.println("you should input name ! ");
        statementNumber = consoleReader.readConsole();
        if (statementNumber.length() < 100 && statementNumber.length() < 0) {
            System.out.println("Name : " + statementNumber);
        }
    }

    public static void checkValidationPhone() {
        System.out.println("you should input phone! ");
        statementNumber = consoleReader.readConsole();
        if (Integer.parseInt(statementNumber) > 0 && Integer.parseInt(statementNumber) < 100) {
            System.out.println("Phone: " + statementNumber);
        }
    }

    public static void selectStatement() throws IOException {
        System.out.println("If you want to select some user you should input ID. If you want to select all users you should press 'Enter'." + "\n" + " So your choose! ");
        statementNumber = consoleReader.readConsole();
        if (statementNumber.equals("")) {
            Set<Map.Entry<Integer, User>> set = dictionaryUsers.entrySet();  //Returns a Set view of the mappings contained in this map.
            for (Map.Entry<Integer, User> me : set) {
                System.out.print(me.getKey() + " : ");
                System.out.println(me.getValue());
            }
        } else {
            for (int i = 0; i < idUsers.size(); i++) {
                if (Integer.parseInt(statementNumber) == idUsers.get(i)) {
                    System.out.println(dictionaryUsers.get(Integer.parseInt(statementNumber)));
                }
            }
        }
        fileIO.writeFile(dictionaryUsers);
    }

    public static void insertStatement() throws IOException {
        
    }

    public static void main(String[] args) throws IOException {
        /*System.out.println("Hi, what do you want to do with our database?" + "\n" +
                "If you input 0 -> you want to do select statement" + "\n" +
                "If you input 1 -> you want to do insert statement" + "\n" +
                "If you input 2 -> you want to do update statement" + "\n" +
                "If you input 3 -> you want to do delete statement");
        chooseStatement();*/
        createDictionaryUsers();
        selectStatement();
    }
}
