package BigGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    int counterPlayer = 0;
    int typePlayer;
    int xPosit;
    int yPosit;
    ImageIcon imageTypePlayer;
    ImageIcon defaultIcon = new ImageIcon("D:\\java_test_2\\src\\images\\olik.png", "Krestiki/Noliki");
    ;
    static Battlefield battlefield = new Battlefield();

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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button1.setIcon(imageTypePlayer);
                button1.setEnabled(false);
                button1.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button2.setIcon(imageTypePlayer);
                button2.setEnabled(false);
                button2.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button3.setIcon(imageTypePlayer);
                button3.setEnabled(false);
                button3.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button4.setIcon(imageTypePlayer);
                button4.setEnabled(false);
                button4.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button5.setIcon(imageTypePlayer);
                button5.setEnabled(false);
                button5.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button6.setIcon(imageTypePlayer);
                button6.setEnabled(false);
                button6.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button7.setIcon(imageTypePlayer);
                button7.setEnabled(false);
                button7.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button8.setIcon(imageTypePlayer);
                button8.setEnabled(false);
                button8.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                battlefield.doStroke(xPosit, yPosit, typePlayer);
                button9.setIcon(imageTypePlayer);
                button9.setEnabled(false);
                button9.setText("");
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
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
                resetGame(button1);
                resetGame(button2);
                resetGame(button3);
                resetGame(button4);
                resetGame(button5);
                resetGame(button6);
                resetGame(button7);
                resetGame(button8);
                resetGame(button9);
                battlefield.resetField();
            }
        });
    }

    public void resetGame(JButton button) {
        button.setEnabled(true);
        button.setIcon(defaultIcon);
    }

    public int getTypePlayer() {
        if (counterPlayer % 2 == 0) {
            typePlayer = 1;
            imageTypePlayer = new ImageIcon("D:\\java_test_2\\src\\images\\krestik.png", "Krestik");
        } else {
            typePlayer = 2;
            imageTypePlayer = new ImageIcon("D:\\java_test_2\\src\\images\\olik.png", "Nolik");
        }
        System.out.println("Do stroke player : " + typePlayer);


        counterPlayer++;
        return typePlayer;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Game");
        Window2 window2 = new Window2();
        frame.setContentPane(window2.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        battlefield.resetField();
        //battlefield.doStroke();
        //window2.getTypePlayer();

    }
}

