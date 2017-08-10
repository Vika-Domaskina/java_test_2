package BigGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Viktoriya.D on 7/31/2017.
 */
public class Window2 {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    JPanel mainPanel;
    private JButton newGameButton;
    private ArrayList<JButton> buttonArrayList = new ArrayList<JButton>();
    int counterPlayer = 0;
    int typePlayer;
    int xPosit;
    int yPosit;
    ImageIcon imageTypePlayer;
    ImageIcon defaultIcon = new ImageIcon("D:\\java_test_2\\src\\images\\krNol.png", "Krestiki/Noliki");
    static Battlefield battlefield = new Battlefield();
    final JDialog jDialog=new JDialog(new JFrame(), "Now, do stroke player: " + typePlayer, null);

    public Window2() {


        button1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 0;
                yPosit = 0;
                System.out.println("Coordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button1.setIcon(imageTypePlayer);
                button1.setEnabled(false);
                button1.setText("");
            }
        });
        button2.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 1;
                yPosit = 0;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button2.setIcon(imageTypePlayer);
                button2.setEnabled(false);
                button2.setText("");
            }
        });
        button3.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 2;
                yPosit = 0;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button3.setIcon(imageTypePlayer);
                button3.setEnabled(false);
                button3.setText("");
            }
        });
        button4.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 0;
                yPosit = 1;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button4.setIcon(imageTypePlayer);
                button4.setEnabled(false);
                button4.setText("");
            }
        });
        button5.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 1;
                yPosit = 1;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button5.setIcon(imageTypePlayer);
                button5.setEnabled(false);
                button5.setText("");
            }
        });
        button6.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 2;
                yPosit = 1;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button6.setIcon(imageTypePlayer);
                button6.setEnabled(false);
                button6.setText("");
            }
        });
        button7.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 0;
                yPosit = 2;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button7.setIcon(imageTypePlayer);
                button7.setEnabled(false);
                button7.setText("");
            }
        });
        button8.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 1;
                yPosit = 2;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button8.setIcon(imageTypePlayer);
                button8.setEnabled(false);
                button8.setText("");
            }
        });
        button9.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosit = 2;
                yPosit = 2;
                System.out.println("Cordinate position: x:" + xPosit + "y:" + yPosit);
                int typePlayer = getTypePlayer();
               // popapWindow.
                if (battlefield.doStroke(xPosit, yPosit, typePlayer)){
                    for (int i=0;i<9;i++){
                        buttonArrayList.get(i).setEnabled(false);
                    }
                }
                button9.setIcon(imageTypePlayer);
                button9.setEnabled(false);
                button9.setText("");
            }
        });
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
    }

    public void resetGame() {
        for (int i=0;i<9;i++){
            buttonArrayList.get(i).setEnabled(true);
            buttonArrayList.get(i).setIcon(defaultIcon);
        }
    }

    public int getTypePlayer() {
        if (counterPlayer % 2 == 0) {
            typePlayer = 1;
            imageTypePlayer = new ImageIcon("D:\\java_test_2\\src\\images\\krestik.png", "Krestik");
        } else {
            typePlayer = 2;
            imageTypePlayer = new ImageIcon("D:\\java_test_2\\src\\images\\olik.png", "Nolik");
        }
        counterPlayer++;
        //jDialog.repaint(80000,150,150,80,70);
        jDialog.isVisible();
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Game");
        Window2 window2 = new Window2();
        window2.initArrayButtons();
        window2.resetGame();
        frame.setContentPane(window2.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        battlefield.resetField();
        //JDialog jDialog=new JDialog(frame, "Now, do stroke player: " + battlefield.tplayer, null);
        //battlefield.doStroke();
        //window2.getTypePlayer();

    }
}

