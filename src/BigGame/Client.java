package BigGame;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Client {

    public static Socket clientSocket;
    public OutputStream out;
    public static boolean connect;
    static GameWindow bg = null;

    public static String createClientConnection(String server) {
        System.out.println("Client connecting to server");
        try {
            clientSocket = new Socket(server, 4444);
            connect = true;
            return "Connection created!";
        } catch (ConnectException c) {
            connect = false;
            System.out.println("Can't find server");
            return "Can't find server" + server + "!!!Please try again";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't connect to server!");
            return "Can't connect to server " + server + "!Please try again";
        }
    }

    public static void makeGameForClient() {
        if (connect) {
            bg = new GameWindow();
        }
    }

    public static void chat() {
        if (connect) {
            System.out.println("Input your message:");
            try {
                BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
                OutputStreamWriter out = null;
                out = new OutputStreamWriter(clientSocket.getOutputStream());
                String reader = inu.readLine() + "\n";
                out.write(reader);
                out.flush();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String msg = in.readLine();
                System.out.println(msg);

            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to server! ");  //+ ia.getHostAddress()
                System.exit(1);
            }
        }

    }

   /* public static void main(String[] args){
        System.out.println("Welcome to client side");
        createClientConnection("localhost");
        while (true) {
            try {
                chat();
            } catch (IOException e) {
                System.out.println("Connection failed!");
            }
        }
    }*/
}

