package BigGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Server side");
        BufferedReader in;
        PrintWriter out;
        Socket fromclient;
        ServerSocket socket = null; //Notice no user to connect to this time.
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

        in = new BufferedReader(new InputStreamReader(fromclient.getInputStream())); //Read data from a stream
        out = new PrintWriter(fromclient.getOutputStream(), true);//Write data from a stream
    }

}
