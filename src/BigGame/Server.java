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
public class Server implements NetworkIO {
    private Socket fromclient;
    private ServerSocket socket;
    static GameWindow bg = null;
    static String[] masivStrokes;

    OutputStreamWriter out = null;
    BufferedReader in = null;

    public void createServerConnection() {
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
            out = new OutputStreamWriter(fromclient.getOutputStream());
            in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
            System.out.println("Client connected");
        } catch (IOException e) {
            fromclient = null;
            System.out.println("Can't accept");
            System.exit(-1);
        }
    }

    public void makeGameForServer() {
        bg = new GameWindow(this,false,"Server");
        JOptionPane.showMessageDialog(new Frame(), "Your opponent stroke first!");
        //bg.frame.enable(false);
        this.readStroke();
    }

    public void writeInformationAboutStroke(String information) {
        try {
            System.out.println("Start write server");

            out.write(information);
            out.flush();
            System.out.println("Stop write server");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to client ");  //+ ia.getHostAddress()
            System.exit(1);
        }

    }

    public void readeInformationAboutStroke() {
        try {
            System.out.println("Start read server");
            System.out.println(fromclient);

            bg.lockBatlefield(bg.opponent);

            String msg = in.readLine();
            System.out.println(msg);
            masivStrokes = msg.split(";");


            bg.unlockBatlefield();
            makeClick(masivStrokes[0], masivStrokes[1]);
            System.out.println("Stop read server");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to client ");  //+ ia.getHostAddress()
            System.exit(1);
        }
    }

    private void makeClick(String x, String y) {
        int xn = Integer.parseInt(x);
        int yn = Integer.parseInt(y);
        bg.field[xn][yn].setIcon(bg.imageOpponent);
        bg.doOpponentStroke(xn,yn);
        bg.field[xn][yn].setEnabled(false);
    }

    @Override
    public String readStroke() {
        this.readeInformationAboutStroke();
        return "ok=(";
    }

    @Override
    public void writeStroke(String stroke) {
        this.writeInformationAboutStroke(stroke);
    }


    /*public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Server side");
        createServerConnection();
        while (true) {
            chat();
        }


    }*/

}
