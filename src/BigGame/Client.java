package BigGame;

import java.io.*;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Client {

    public static Socket clientSocket;
    public static OutputStream out;


    public static void createClientConnection(String server) {
        System.out.println("Client connecting to server");
        try {
            clientSocket = new Socket(server, 4444);
        } catch (IOException e) {
            e.printStackTrace() ;
            System.out.println("Can't connect to server!");
        }
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

    public static void main(String[] args){
        System.out.println("Welcome to client side");
        createClientConnection("localhost");
        while (true) {
            try {
                chat();
            } catch (IOException e) {
                System.out.println("Connection failed!");
            }
        }
    }
}

