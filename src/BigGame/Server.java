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
    public static Socket fromclient = null;
    public static ServerSocket socket = null;
    public static InputStreamReader in;
    public static OutputStreamWriter out;
    public static InputStreamReader inu;
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
        System.out.println("Input your message:");
        inu = new InputStreamReader(System.in);
        out = new OutputStreamWriter(fromclient.getOutputStream());
        int i;
        while ((i = inu.read()) != -1) {
            out.write(i);
        }
        in = new InputStreamReader(fromclient.getInputStream());
        while ((readByte = in.read()) != -1) {
            System.out.println(readByte);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Server side");
        createServerConnection();
        while (true){
            chat();
        }


    }

}
