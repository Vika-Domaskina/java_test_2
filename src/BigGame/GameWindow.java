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


    NetworkIO nio = null;

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
    public JButton[][] field = new JButton[3][3];
    int counterPlayer = 0;
    int typePlayer = 0;
    int opponent = 0;
    static JFrame frame;
    static ImageIcon imageTypePlayer;
    ImageIcon defaultIcon = new ImageIcon(this.getClass().getResource("images\\krNol.png").getPath(), "Krestiki/Noliki");
    Battlefield battlefield = new Battlefield();
    public ImageIcon imageOpponent;

    class FieldCellActionListener implements ActionListener {
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
            button.setIcon(imageTypePlayer);
            if (battlefield.doStroke(xPosit, yPosit, typePlayer, frame)) {
                for (int i = 0; i < 9; i++) {
                    buttonArrayList.get(i).setEnabled(false);
                }
            }
            button.setEnabled(false);
            button.setText("");
            button.setIcon(imageTypePlayer);
            nio.writeStroke(sendInformationAboutStroke());

            SwingWorker worker = new SwingWorker<String, Void>() {
                @Override
                public String doInBackground() {
                    nio.readStroke();
                    return "Opponents turn done";
                }
            };
            worker.execute();

        }

        public String sendInformationAboutStroke() {
            return xPosit + ";" + yPosit +";\n";
        }

    }


    GameWindow(NetworkIO nio,boolean first,String windowName){
        this(first,windowName);
        this.nio = nio;
    }


    public GameWindow(Boolean firstMove,String windowName) {
        frame = new JFrame(windowName);
        frame.setPreferredSize(new Dimension(1600, 1300));
        msg_area.setWrapStyleWord(true);
        msg_area.setLineWrap(true);
        this.initArrayButtons();
        this.resetGame();
        this.initTypePlayer(firstMove);
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

        //if (!firstMove) nio.readStroke();
    }


    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttonArrayList.get(i).setEnabled(true);
            buttonArrayList.get(i).setIcon(defaultIcon);
        }
    }

    public int initTypePlayer(boolean first) {
        if (first) {
            typePlayer = 1;
            opponent = 2;
            imageTypePlayer = new ImageIcon(this.getClass().getResource("images\\krestik.png"), "Krestik");
            imageOpponent = new ImageIcon(this.getClass().getResource("images\\olik.png"), "Nolik");
        } else {
            typePlayer = 2;
            opponent = 1;
            imageTypePlayer = new ImageIcon(this.getClass().getResource("images\\olik.png"), "Nolik");
            imageOpponent = new ImageIcon(this.getClass().getResource("images\\krestik.png"), "Krestik");
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

        field[0][0] = button1;
        field[1][0] = button2;
        field[2][0] = button3;
        field[0][1] = button4;
        field[1][1] = button5;
        field[2][1] = button6;
        field[0][2] = button7;
        field[1][2] = button8;
        field[2][2] = button9;


    }

    public void lockBatlefield(int myStroke) {
        if (typePlayer != myStroke) {
            frame.enable(false);
        }
    }

    public void unlockBatlefield() {
        frame.enable(true);
    }

    void doOpponentStroke(int x, int y){
        battlefield.doStroke(x,y,opponent,frame);
    }

}


