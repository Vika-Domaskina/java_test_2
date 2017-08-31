package BigGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Server {
    private static Socket fromclient;
    private static ServerSocket socket;
    public static int readByte;

    public static void createServerConnection() {
        try {
            socket = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 4444");
            /*System.exit(-1);*/
            try {
                socket = new ServerSocket(4445);
            } catch (IOException k) {
                System.out.println("Fatality error");
                System.exit(21252);
            }

        }

        try {
            System.out.print("Waiting for a client...");
            fromclient = socket.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            fromclient = null;
            System.out.println("Can't accept");
            System.exit(-1);
        }
    }

    public static void chat() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
        String msg = in.readLine();
        System.out.println(msg);
        System.out.println("Input your message:");
        BufferedReader inu = new BufferedReader (new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(fromclient.getOutputStream());
        String reader = inu.readLine()+"\n";
        out.write(reader);
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Server side");
        createServerConnection();
        while (true) {
            chat();
        }


    }

}
