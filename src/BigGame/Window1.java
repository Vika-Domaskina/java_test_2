package BigGame;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 * Created by Viktoriya.D on 7/28/2017.
 */
public class Window1 {
    private JButton clientButton;
    private JButton xButton;
    private JTextField chooseYourTypeTextField;
    private JPanel mainPanel;

    public Window1() {
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseYourTypeTextField.setText("Selected!");
                clientButton.setVisible(false);
                xButton.setVisible(false);
                /*mainPanel.setVisible(false);*/
            }
        });

        xButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseYourTypeTextField.setText("Selected!");
                clientButton.setVisible(false);
                xButton.setVisible(false);
                /*mainPanel.setVisible(false);*/
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
