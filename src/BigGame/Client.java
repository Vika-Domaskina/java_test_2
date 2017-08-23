package BigGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Client {
    static String serverIP;

    public Client(String ip) {
        this.serverIP = ip;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Client side");
        Socket clientSocket = null;
        clientSocket = new Socket(serverIP, 4444); //Tim replace for IP
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
    }
}