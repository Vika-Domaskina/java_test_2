package BigGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Viktoriya.D on 7/31/2017.
 */
public class GameWindow {

    static class FieldCellActionListener implements ActionListener {
        int xPosit;
        int yPosit;

        public FieldCellActionListener(int XcordinatePositionButton, int YcordinatePositionButton) {
            //super();
            this.xPosit = XcordinatePositionButton;
            this.yPosit = YcordinatePositionButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = ((JButton) e.getSource());
            System.out.println("Coordinate position: x:" + xPosit + "y:" + yPosit);
            int typePlayer = getTypePlayer();
            button.setIcon(imageTypePlayer);
            if (battlefield.doStroke(xPosit, yPosit, typePlayer, frame)) {
                for (int i = 0; i < 9; i++) {
                    buttonArrayList.get(i).setEnabled(false);
                }
            }
            button.setEnabled(false);
            button.setText("");
            if (typePlayer == 1) {
                Client.writeInformationAboutStroke(sendInformationAboutStroke());
                Server.readeInformationAboutStroke();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                Server.writeInformationAboutStroke(sendInformationAboutStroke());
                Client.readeInformationAboutStroke();
            } else {
                Server.writeInformationAboutStroke(sendInformationAboutStroke());
                Client.readeInformationAboutStroke();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            Server.readeInformationAboutStroke();
            Client.writeInformationAboutStroke(sendInformationAboutStroke());
        }

        public String sendInformationAboutStroke() {
            return xPosit + ";" + yPosit + "\n";
        }

    }

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JPanel mainPanel;
    JButton newGameButton;
    JTextArea msg_area;
    JTextField msg_field;
    JButton sendButton;
    static ArrayList<JButton> buttonArrayList = new ArrayList<JButton>();
    static int counterPlayer = 0;
    static int typePlayer;
    static int opponent;
    static JFrame frame;
    static ImageIcon imageTypePlayer;
    ImageIcon defaultIcon = new ImageIcon("D:\\java_test_2\\src\\images\\krNol.png", "Krestiki/Noliki");
    static Battlefield battlefield = new Battlefield();

    public GameWindow() {
        frame = new JFrame("My Game");
        frame.setPreferredSize(new Dimension(1600, 1300));
        msg_area.setWrapStyleWord(true);
        msg_area.setLineWrap(true);
        this.initArrayButtons();
        this.resetGame();
        //mainPanel.add(dialogPanel);
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        battlefield.resetField();

        button1.addActionListener(new FieldCellActionListener(0, 0));
        button2.addActionListener(new FieldCellActionListener(1, 0));
        button3.addActionListener(new FieldCellActionListener(2, 0));
        button4.addActionListener(new FieldCellActionListener(0, 1));
        button5.addActionListener(new FieldCellActionListener(1, 1));
        button6.addActionListener(new FieldCellActionListener(2, 1));
        button7.addActionListener(new FieldCellActionListener(0, 2));
        button8.addActionListener(new FieldCellActionListener(1, 2));
        button9.addActionListener(new FieldCellActionListener(2, 2));
        newGameButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                imageTypePlayer = defaultIcon;
                counterPlayer = 0;
                resetGame();
                battlefield.resetField();
            }
        });

        sendButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                msg_area.append(msg_field.getText() + "\n");
                System.out.println(msg_field.getText());
                msg_field.setText("");
            }
        });
        msg_field.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (msg_field.getText().equals("")) {
                    sendButton.setEnabled(false);
                } else sendButton.setEnabled(true);
            }
        });
        msg_field.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been pressed.
             *
             * @param e
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    msg_area.append(msg_field.getText() + "\n");
                    System.out.println(msg_field.getText());
                    msg_field.setText("");
                    sendButton.setEnabled(true);
                }
            }
        });
    }


    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttonArrayList.get(i).setEnabled(true);
            buttonArrayList.get(i).setIcon(defaultIcon);
        }
    }

    public static int getTypePlayer() {
        if (counterPlayer % 2 == 0) {
            typePlayer = 1;
            opponent = 2;
            imageTypePlayer = new ImageIcon("D:\\java_test_2\\src\\images\\krestik.png", "Krestik");
        } else {
            typePlayer = 2;
            opponent = 1;
            imageTypePlayer = new ImageIcon("D:\\java_test_2\\src\\images\\olik.png", "Nolik");
        }
        counterPlayer++;
        return typePlayer;
    }

    public void initArrayButtons() {
        buttonArrayList.add(button1);
        buttonArrayList.add(button2);
        buttonArrayList.add(button3);
        buttonArrayList.add(button4);
        buttonArrayList.add(button5);
        buttonArrayList.add(button6);
        buttonArrayList.add(button7);
        buttonArrayList.add(button8);
        buttonArrayList.add(button9);
    }

    public void lockBatlefield(int myStroke) {
        if (typePlayer != myStroke) {
            frame.enable(false);
        }
    }

    public void unlockBatlefield() {
        /*JOptionPane.showMessageDialog(frame, "Your stroke!!!");*/
        frame.enable(true);
    }


    /*public static void main(String[] args) {
        new GameWindow();
        lockBatlefield(2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        unlockBatlefield();*/
}

