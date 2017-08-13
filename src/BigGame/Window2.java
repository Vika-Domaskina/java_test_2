package BigGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Viktoriya.D on 7/31/2017.
 */
public class Window2 {

    class FieldCellActionListener implements ActionListener {
        public FieldCellActionListener(int x, int y){
            //super();
            this.xPosit =x ;
            this.yPosit=y;
        }

        int xPosit;
        int yPosit;
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button =((JButton)e.getSource());
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
        }
    }

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
    JFrame frame;
    ImageIcon imageTypePlayer;
    ImageIcon defaultIcon = new ImageIcon("D:\\java_test_2\\src\\images\\krNol.png", "Krestiki/Noliki");
    static Battlefield battlefield = new Battlefield();

    public Window2() {
        frame = new JFrame("My Game");

        this.initArrayButtons();
        this.resetGame();
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        battlefield.resetField();

        button1.addActionListener(new FieldCellActionListener(0,0));
        button2.addActionListener(new FieldCellActionListener(1,0));
        button3.addActionListener(new FieldCellActionListener(2,0));
        button4.addActionListener(new FieldCellActionListener(0,1));
        button5.addActionListener(new FieldCellActionListener(1,1));
        button6.addActionListener(new FieldCellActionListener(2,1));
        button7.addActionListener(new FieldCellActionListener(0,2));
        button8.addActionListener(new FieldCellActionListener(1,2));
        button9.addActionListener(new FieldCellActionListener(2,2));
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
        for (int i = 0; i < 9; i++) {
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
        new Window2();

    }
}

