package FileTasks;

import java.io.IOException;
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
    static HashMap<Integer, User> dictionaryUsers = new HashMap<Integer, User>();

    public static HashMap createDictionaryUsers() throws IOException {
        fileIO.readFile();
        for (int i = 0; i < fileIO.masivUsers.length; i = i + 3) {
            dictionaryUsers.put(Integer.parseInt(fileIO.masivUsers[i + 0]), new User(Integer.parseInt(fileIO.masivUsers[i + 0]), fileIO.masivUsers[i + 1], fileIO.masivUsers[i + 2]));
        }
        return dictionaryUsers;
    }

    public static String chooseStatement() {
        System.out.println("Choose statement: ");
        statementNumber = consoleReader.readConsole();
        while (true) {
            if (statementNumber.equals("0")) {
                System.out.println("There should be select statement");
                selectStatement();
                break;
            } else if (statementNumber.equals("1")) {
                System.out.println("There should be insert statement");
                insertStatement();
                break;
            } else if (statementNumber.equals("2")) {
                System.out.println("There should be update statement");
                updateStatement();
                break;
            } else if (statementNumber.equals("3")) {
                System.out.println("There should be delete statement");
                deleteStatement();
                break;
            } else {
                System.out.println("Choose right number!");
                statementNumber = consoleReader.readConsole();
            }
        }
        return statementNumber;
    }


    public static int checkValidationID() {
        System.out.println("you should input ID at first! ");
        statementNumber = consoleReader.readConsole();
        if (Integer.parseInt(statementNumber) > 0 && Integer.parseInt(statementNumber) < 1000000000) {
            System.out.println("ID your user: " + statementNumber);
        }
        return Integer.parseInt(statementNumber);
    }

    public static String checkValidationName() {
        System.out.println("you should input name ! ");
        statementNumber = consoleReader.readConsole();
        if (statementNumber.length() < 100 && statementNumber.length() < 0) {
            System.out.println("Name : " + statementNumber);
        }
        return statementNumber;
    }

    public static String checkValidationPhone() {
        System.out.println("you should input phone! ");
        statementNumber = consoleReader.readConsole();
        if (Integer.parseInt(statementNumber) > 0 && Integer.parseInt(statementNumber) < 100) {
            System.out.println("Phone: " + statementNumber);
        }
        return statementNumber;
    }

    public static void selectStatement() {
        System.out.println("If you want to select some user you should input ID. If you want to select all users you should press 'Enter'." + "\n" + " So your choose! ");
        statementNumber = consoleReader.readConsole();
        if (statementNumber.equals("")) {
            Set<Map.Entry<Integer, User>> set = dictionaryUsers.entrySet();  //Returns a Set view of the mappings contained in this map.
            for (Map.Entry<Integer, User> me : set) {
                System.out.print(me.getKey() + " : ");
                System.out.println(me.getValue());
            }
        } else {
            if (dictionaryUsers.containsKey(Integer.parseInt(statementNumber))) {
                System.out.println(dictionaryUsers.get(Integer.parseInt(statementNumber)));
            }
        }
    }

    public static void insertStatement() {
        System.out.println("For insert statement you should input 3 field: ID, Name, Phone");
        int id = checkValidationID();
        String name = checkValidationName();
        String phone = checkValidationPhone();
        dictionaryUsers.put(id, new User(id, name, phone));
        /*Set<Map.Entry<Integer, User>> set = dictionaryUsers.entrySet();  //Returns a Set view of the mappings contained in this map.
        for (Map.Entry<Integer, User> me : set) {
            System.out.print(me.getKey() + " : ");
            System.out.println(me.getValue());
        }*/
        fileIO.writeFile(dictionaryUsers);
    }

    public static void updateStatement() {
        System.out.println("For update statement you should input existing user ID:");
        int id = checkValidationID();
        User updateUser;
        if (dictionaryUsers.containsKey(id)) {
            updateUser = dictionaryUsers.get(id);
        } else {
            System.out.println("User not found!");
            return;
        }

        System.out.println("What field you want update?" + "\n" +
                "If you input 1 -> you want update name for user" + "\n" +
                "If you input 2 -> you want update phone for user");
        System.out.println("Choose statement: ");
        statementNumber = consoleReader.readConsole();
        while (true) {
            if (Integer.parseInt(statementNumber) == 1) {
                System.out.println("You choose name field");
                updateUser.userName = checkValidationName();
                /*dictionaryUsers.get(Integer.parseInt(statementNumber))*/
                break;
            } else if (Integer.parseInt(statementNumber) == 2) {
                System.out.println("You choose phone field");
                updateUser.userPhone = checkValidationPhone();
                break;
            } else {
                System.out.println("Choose right number!");
                statementNumber = consoleReader.readConsole();
            }
        }
        fileIO.writeFile(dictionaryUsers);
    }


    public static void deleteStatement() {
        System.out.println("For delete statement you should input existing user ID:");
        int id = checkValidationID();
        if (dictionaryUsers.containsKey(id)) {
            System.out.println("Now deleting this user:");
            System.out.println(dictionaryUsers.get(id));
            dictionaryUsers.remove(id);
        }
        fileIO.writeFile(dictionaryUsers);
    }

    public static void showControl() {
        System.out.println("Hi, what do you want to do with our database?" + "\n" +
                "If you input 0 -> you want to do select statement" + "\n" +
                "If you input 1 -> you want to do insert statement" + "\n" +
                "If you input 2 -> you want to do update statement" + "\n" +
                "If you input 3 -> you want to do delete statement");
        chooseStatement();
    }

    public static void main(String[] args) throws IOException {
        createDictionaryUsers();
        while (true)
            showControl();

        //selectStatement();
    }
}
