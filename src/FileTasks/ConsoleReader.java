package FileTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vika on 27.08.2017.
 */
public class ConsoleReader {
    BufferedReader readOfConsole = new BufferedReader(new InputStreamReader(System.in));

    public String readConsole() {
        try {
            return readOfConsole.readLine();
        } catch (IOException e) {
            System.out.println("Error:" + e);
            return "";
        }

    }
}
