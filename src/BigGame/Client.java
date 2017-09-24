package BigGame;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 8/22/2017.
 */
public class Client implements Network {

    public static Socket clientSocket;
    public static boolean connect;
    static GameWindow bg = null;
    static String[] masivStrokes;
    OutputStreamWriter outW = null;
    BufferedReader in = null;

    public String createClientConnection(String server) {
        System.out.println("Client connecting to server");
        try {
            clientSocket = new Socket(server, 4444);
            connect = true;
            outW = new OutputStreamWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
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

    public void makeGameForClient() {
        if (connect) {
            bg = new GameWindow(this, true, "Client");
        }
    }

    public void writeInformationAboutStroke(String information) {
        if (connect) {
            try {
                System.out.println("Start write client");
                outW.write(information);
                outW.flush();
                System.out.println("Stop write client");
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to server! ");  //+ ia.getHostAddress()
                System.exit(1);
            }
        }

    }

    public void readeInformationAboutStroke() {
        if (connect) {
            try {
                System.out.println("Start read client");
                bg.lockBatlefield(bg.opponent);
                String msg = in.readLine();
                masivStrokes = msg.split(";");
                System.out.println(masivStrokes[0]);

                if (masivStrokes[0].equals("Reset")) {
                    System.out.println("ResetBranch");
                    bg.unlockBatlefield();
                    System.out.println("Unlok");
                    bg.reset();
                    bg.battlefield.resetField();
                    System.out.println("Stop read client");
                } else {
                    bg.unlockBatlefield();
                    makeClick(masivStrokes[0], masivStrokes[1]);
                    System.out.println("Stop read client");
                }
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to server! ");  //+ ia.getHostAddress()
                System.exit(1);
            }
        }
    }

    private void makeClick(String x, String y) {
        int xn = Integer.parseInt(x);
        int yn = Integer.parseInt(y);
        bg.field[xn][yn].setIcon(bg.imageOpponent);
        bg.doOpponentStroke(xn, yn);
        bg.field[xn][yn].setEnabled(false);
    }

    @Override
    public String readStroke() {
        this.readeInformationAboutStroke();
        return "finish read server inform!";
    }

    @Override
    public void writeStroke(String stroke) {
        this.writeInformationAboutStroke(stroke);
    }

    @Override
    public void resetAllFilds() {
        bg.resetGame();
    }



   /* public static void main(String[] args){
        System.outW.println("Welcome to client side");
        createClientConnection("localhost");
        while (true) {
            try {
                chat();
            } catch (IOException e) {
                System.outW.println("Connection failed!");
            }
        }
    }*/
}

