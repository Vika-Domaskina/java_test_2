package BigGame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;

/**
 * Created by Viktoriya.D on 7/28/2017.
 */
public class Window1 {
    private JButton clientButton;
    private JButton xButton;
    private JTextField chooseYourTypeTextField;
    private JPanel mainPanel;
    private JTextArea textArea1;

    public Window1() {
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientButton.setText("Clicked!");
            }
        });
        textArea1.addComponentListener(new ComponentAdapter() {
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
