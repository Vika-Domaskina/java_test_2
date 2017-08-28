package FileTasks;

/**
 * Created by Viktoriya.D on 8/28/2017.
 */
public class UserDB {
    public static ConsoleReader consoleReader = new ConsoleReader();
    public static FileIO fileIO = new FileIO();
    public static String statementNumber = "";

    public static String chooseStatement() {
        System.out.print("Choose statement: ");
        consoleReader.readConsole();
        statementNumber = consoleReader.readConsole();
        System.out.println(statementNumber);
        while (true) {
            if (statementNumber.equals("0")) {
                System.out.println("There should be select statement");
                System.out.println(statementNumber);
                break;
            } else if (statementNumber.equals("1")) {
                System.out.println("There should be insert statement");
                System.out.println(statementNumber);
                break;
            } else if (statementNumber.equals("2")) {
                System.out.println("There should be update statement");
                System.out.println(statementNumber);
                break;
            } else if (statementNumber.equals("3")) {
                System.out.println("There should be delete statement");
                System.out.println(statementNumber);
                break;
            } else {
                System.out.println("Choose right number!");
                System.out.println(statementNumber);
                consoleReader.readConsole();
                statementNumber = consoleReader.readConsole();
                System.out.println(statementNumber);
            }
        }
        return statementNumber;
    }

    public static void main(String[] args) {
        System.out.println("Hi, what do you want to do with our database?" + "\n" +
                "If you input 0 -> you want to do select statement" + "\n" +
                "If you input 1 -> you want to do insert statement" + "\n" +
                "If you input 2 -> you want to do update statement" + "\n" +
                "If you input 3 -> you want to do delete statement");
        chooseStatement();
    }
}
