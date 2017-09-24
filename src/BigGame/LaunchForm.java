package BigGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Viktoriya.D on 7/28/2017.
 */
public class LaunchForm {
    private JButton clientButton;
    private JButton serverButton;
    private JTextField chooseYourTypeTextField;
    private JPanel mainPanel;
    private JTextField IPField;
    private JButton connectButton;
    private JFrame frame2;


    boolean isServer;

    public LaunchForm() {
        frame2 = new JFrame("My Game");
        frame2.setPreferredSize(new Dimension(1600, 1300));
        frame2.setContentPane(this.mainPanel);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
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
                isServer = false;
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
                isServer = true;

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
                if (!isServer && !IPField.getText().equals("")) {
                    Client client = new Client();
                    JOptionPane.showMessageDialog(frame2, client.createClientConnection(IPField.getText()));
                    if (!client.connect) {
                        serverButton.setEnabled(true);
                        clientButton.setEnabled(true);
                    } else {
                        client.makeGameForClient();
                    }
                } else if (isServer) {
                    Server server = new Server();
                    server.createServerConnection();
                    server.makeGameForServer();
                } else {
                    JOptionPane.showMessageDialog(frame2, "Could you please input IP server in text box!!!");
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
                if (IPField.getText().equals("")) {
                   // JOptionPane.showMessageDialog(frame2, "Please input in text box server address for connecting");
                }
                serverButton.setEnabled(true);
            }
        });
    }

    public static void main(String[] args) {
        new LaunchForm();

    }
}
