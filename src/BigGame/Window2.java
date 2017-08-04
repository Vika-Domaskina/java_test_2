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
    int counterPlayer = 0;
    int typePlayer;
    int xPosit;
    int yPosit;
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
                button1.setText(typePlayer + "");
                button1.setEnabled(false);
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
                button2.setText(typePlayer + "");
                button2.setEnabled(false);
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
                button3.setText(typePlayer + "");
                button3.setEnabled(false);
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
                button4.setText(typePlayer + "");
                button4.setEnabled(false);
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
                button5.setText(typePlayer + "");
                button5.setEnabled(false);
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
                button6.setText(typePlayer + "");
                button6.setEnabled(false);
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
                button7.setText(typePlayer + "");
                button7.setEnabled(false);
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
                button8.setText(typePlayer + "");
                button8.setEnabled(false);
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
                button9.setText(typePlayer + "");
                button9.setEnabled(false);
                if (battlefield.isGameOver()) {
                    System.out.println("Congrats");
                } else {
                    System.out.println("The next player walks");
                }
            }
        });
    }

    public int getTypePlayer() {
        if (counterPlayer % 2 == 0) {
            typePlayer = 1;
        } else typePlayer = 2;
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

