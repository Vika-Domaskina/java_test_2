package BigGame;

import java.io.*;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Client {

    public static Socket clientSocket;
    public static OutputStream out;

    public static int readByte;

    public static void createClientConnection() throws IOException {
        System.out.println("Client connecting to server");
        clientSocket = new Socket("localhost", 4444);
    }

    public static void chat() throws IOException {
        System.out.println("Input your message:");
        BufferedReader inu = new BufferedReader (new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
        String reader = inu.readLine()+"\n";
        out.write(reader);
        out.flush();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String msg = in.readLine();
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to client side");
        createClientConnection();
        while (true) {
            chat();
        }
    }
}

