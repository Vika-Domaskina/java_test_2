package BigGame;

import BigGame.GameWindow.FieldCellActionListener;

import javax.swing.*;
import java.awt.*;
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
    static GameWindow bg = null;
    static String[] masivStrokes;

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
            System.out.println("Waiting for a client...");
            fromclient = socket.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            fromclient = null;
            System.out.println("Can't accept");
            System.exit(-1);
        }
    }

    public static void makeGameForServer() {
        bg = new GameWindow();
        JOptionPane.showMessageDialog(new Frame(), "Your opponent stroke first!");
        bg.frame.enable(false);
    }

    public static void writeInformationAboutStroke(String information) {
        try {
            System.out.println("Start write server");
            OutputStreamWriter out = new OutputStreamWriter(fromclient.getOutputStream());
            out.write(information);
            out.flush();
            System.out.println("Stop write server");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to client ");  //+ ia.getHostAddress()
            System.exit(1);
        }

    }

    public static void readeInformationAboutStroke() {
        try {
            System.out.println("Start read server");
            System.out.println(fromclient);
            BufferedReader in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
            String msg = in.readLine();
            System.out.println(msg);
            masivStrokes = msg.split(";");
            bg.lockBatlefield(bg.opponent);
            makeClick(masivStrokes[0], masivStrokes[1]);
            bg.unlockBatlefield();
            System.out.println("Stop read server");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to client ");  //+ ia.getHostAddress()
            System.exit(1);
        }
    }

    private static void makeClick(String x, String y) {
        if (Integer.parseInt(x) == 0 && Integer.parseInt(y) == 0) {
            bg.button1.addActionListener(new BigGame.GameWindow.FieldCellActionListener(0, 0));
        } else if (Integer.parseInt(x) == 1 && Integer.parseInt(y) == 0) {
            bg.button2.addActionListener(new FieldCellActionListener(1, 0));
        } else if (Integer.parseInt(x) == 2 && Integer.parseInt(y) == 0) {
            bg.button3.addActionListener(new FieldCellActionListener(2, 0));
        } else if (Integer.parseInt(x) == 0 && Integer.parseInt(y) == 1) {
            bg.button4.addActionListener(new FieldCellActionListener(0, 1));
        } else if (Integer.parseInt(x) == 1 && Integer.parseInt(y) == 1) {
            bg.button5.addActionListener(new FieldCellActionListener(1, 1));
        } else if (Integer.parseInt(x) == 2 && Integer.parseInt(y) == 1) {
            bg.button6.addActionListener(new FieldCellActionListener(2, 1));
        } else if (Integer.parseInt(x) == 0 && Integer.parseInt(y) == 2) {
            bg.button7.addActionListener(new FieldCellActionListener(0, 2));
        } else if (Integer.parseInt(x) == 1 && Integer.parseInt(y) == 2) {
            bg.button8.addActionListener(new FieldCellActionListener(1, 2));
        } else if (Integer.parseInt(x) == 2 && Integer.parseInt(y) == 2) {
            bg.button9.addActionListener(new FieldCellActionListener(2, 2));
        }


    }


    /*public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Server side");
        createServerConnection();
        while (true) {
            chat();
        }


    }*/

}
