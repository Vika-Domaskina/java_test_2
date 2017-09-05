package BigGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Viktoriya.D on 7/28/2017.
 */
public class Window1 {
    private JButton clientButton;
    private JButton serverButton;
    private JTextField chooseYourTypeTextField;
    private JPanel mainPanel;
    private JTextField IPField;
    private JButton connectButton;
    private JFrame frame;


    Window2 bg = null;
    boolean isServer;

    public Window1() {
        frame = new JFrame("My Game");
        frame.setPreferredSize(new Dimension(1600, 1300));
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        IPField.setColumns(24);

        clientButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseYourTypeTextField.setText("Selected client!");
                JOptionPane.showMessageDialog(frame, "Please input in text box IP server for connecting");
                isServer=false;
                serverButton.setEnabled(true);
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
                chooseYourTypeTextField.setText("Selected server!");
                clientButton.setEnabled(true);
                isServer=true;

            }
        });
        connectButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServer && !IPField.getText().equals("")){
                        Client.createClientConnection(IPField.getText());
                    while (true) {
                        Client.chat();
                    }
                } else if(isServer){
                    Server.createServerConnection();
                } else {
                    JOptionPane.showMessageDialog(frame, "Could you please input IP server in text box!!!");
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
                serverButton.setEnabled(true);
            }
        });
    }

    public static void main(String[] args) {
        new Window1();

    }
}
