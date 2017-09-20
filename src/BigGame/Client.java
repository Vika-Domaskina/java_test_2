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
    static String[] masivStrokes;

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

    public static void writeInformationAboutStroke(String information) {
        if (connect) {
            try {
                System.out.println("Start write client");
                OutputStreamWriter out = null;
                out = new OutputStreamWriter(clientSocket.getOutputStream());
                out.write(information);
                out.flush();
                System.out.println("Stop write client");
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to server! ");  //+ ia.getHostAddress()
                System.exit(1);
            }
        }

    }

    public static void readeInformationAboutStroke() {
        if (connect) {
            try {
                System.out.println("Start read client");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String msg = in.readLine();
                System.out.println(msg);
                bg.lockBatlefield(bg.opponent);
                makeClick(masivStrokes[0], masivStrokes[1]);
                bg.unlockBatlefield();
                System.out.println("Stop read client");
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to server! ");  //+ ia.getHostAddress()
                System.exit(1);
            }
        }
    }

    private static void makeClick(String x, String y) {
        if (Integer.parseInt(x) == 0 && Integer.parseInt(y) == 0) {
            bg.button1.addActionListener(new BigGame.GameWindow.FieldCellActionListener(0, 0));
        } else if (Integer.parseInt(x) == 1 && Integer.parseInt(y) == 0) {
            bg.button2.addActionListener(new GameWindow.FieldCellActionListener(1, 0));
        } else if (Integer.parseInt(x) == 2 && Integer.parseInt(y) == 0) {
            bg.button3.addActionListener(new GameWindow.FieldCellActionListener(2, 0));
        } else if (Integer.parseInt(x) == 0 && Integer.parseInt(y) == 1) {
            bg.button4.addActionListener(new GameWindow.FieldCellActionListener(0, 1));
        } else if (Integer.parseInt(x) == 1 && Integer.parseInt(y) == 1) {
            bg.button5.addActionListener(new GameWindow.FieldCellActionListener(1, 1));
        } else if (Integer.parseInt(x) == 2 && Integer.parseInt(y) == 1) {
            bg.button6.addActionListener(new GameWindow.FieldCellActionListener(2, 1));
        } else if (Integer.parseInt(x) == 0 && Integer.parseInt(y) == 2) {
            bg.button7.addActionListener(new GameWindow.FieldCellActionListener(0, 2));
        } else if (Integer.parseInt(x) == 1 && Integer.parseInt(y) == 2) {
            bg.button8.addActionListener(new GameWindow.FieldCellActionListener(1, 2));
        } else if (Integer.parseInt(x) == 2 && Integer.parseInt(y) == 2) {
            bg.button9.addActionListener(new GameWindow.FieldCellActionListener(2, 2));
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

