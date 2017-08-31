package BigGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Viktoriya.D on 7/28/2017.
 */
public class Window1 {
    private JButton clientButton;
    private JButton serverButton;
    private JTextField chooseYourTypeTextField;
    private JPanel mainPanel;
    private JTextField IPField;
    private JButton IPButton;
    private JFrame frame;

    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    Socket remoteClientSocket = null;
    BufferedWriter fromServerToClient = null;
    BufferedReader toServerFromClient = null;
    BufferedWriter fromClientToServer = null;
    BufferedReader toClientFromServer = null;

    Battlefield bg = null;

    public Window1() {
        serverButton = new JButton("I want to be a server!");
        IPButton = new JButton("Connect!");
        clientButton = new JButton("I want to be a client!");
        IPField.setColumns(24);
        IPButton = new JButton("Connect!");

        clientButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseYourTypeTextField.setText("Selected!");
                IPField.setEnabled(true);
                IPButton.setEnabled(true);
                clientButton.setVisible(false);
                serverButton.setVisible(false);
            }
        });

        serverButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseYourTypeTextField.setText("Selected!");
                InetAddress thisIp = null;
                try {
                    thisIp = InetAddress.getLocalHost();
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(null, "Fatal error! Can't get IP!", "Sorry, fatal error!", 1);
                    System.exit(1);
                }
                try {
                    serverSocket = new ServerSocket(1234);
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error!");
                    System.exit(1);
                }

                clientButton.setVisible(false);
                serverButton.setVisible(false);
                /*mainPanel.setVisible(false);*/
            }
        });
        IPButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                InetAddress ia = null;

                try {

                    remoteClientSocket = new Socket(ia = InetAddress.getByName(IPField.getText()), 1234);
                    fromClientToServer = new BufferedWriter(new OutputStreamWriter(remoteClientSocket.getOutputStream()));
                    toClientFromServer = new BufferedReader(new InputStreamReader(remoteClientSocket.getInputStream()));
                    bg = new Battlefield();
                } catch (UnknownHostException uhe) {
                    System.err.println("Don't know about host: " + ia.getHostAddress());
                    System.exit(1);
                } catch (IOException ioe) {
                    System.err.println("Couldn't get I/O for the connection to: " + ia.getHostAddress());
                    System.exit(1);
                }
                try {

                    clientSocket = serverSocket.accept();
                    fromServerToClient = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    toServerFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                } catch (IOException ety) {
                    JOptionPane.showMessageDialog(null, "Client disconnected...");
                    System.exit(1);
                }
            }
        });
        IPField.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (IPField.getText().equals("Input server's IP here...")) {

                    // clear the box...

                    IPField.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Game");
        frame.setContentPane(new Window1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
