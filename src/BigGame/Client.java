package BigGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Client {

    public static Socket clientSocket;
    public static InputStreamReader in;
    public static OutputStreamWriter out;
    public static InputStreamReader inu;
    public static int readByte;

    public static void createClientConnection() throws IOException {
        System.out.println("Client connecting to server");
        clientSocket = new Socket("localhost", 4444);
    }

    public static void chat() throws IOException {
        System.out.println("Input your message:");
        inu = new InputStreamReader(System.in);
        out = new OutputStreamWriter(clientSocket.getOutputStream());
        int i;
        while ((i = inu.read()) != -1) {
            out.write(i);
        }
        in = new InputStreamReader(clientSocket.getInputStream());
        while ((readByte = in.read()) != -1) {
            System.out.println(readByte);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to client side");
        createClientConnection();
        while (true) {
            chat();
        }
    }
}

