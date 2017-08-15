package BigGame;


import javax.swing.*;

/**
 * Created by Viktoriya.D on 8/1/2017.
 */
public class Battlefield {
    private int tplayer;
    private Integer[][] arr = new Integer[3][3];

    public void resetField() {
        for (int i = 0; i < 3; i++) {
            /*System.out.println("\n"+i);*/
            for (int k = 0; k < 3; k++) {
                arr[i][k] = 0;
                /*System.out.print(arr[i][k]);*/
            }
        }
    }

    static void paintField(Integer[][] arr) {
        for (int i = 0; i < 3; i++) {
            /*System.out.println("\n" );*/
            for (int k = 0; k < 3; k++) {
                System.out.println(arr[i][k]);
            }
        }
    }

    public boolean isGameOver() {
        if ((arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0]) && arr[0][0] != 0) {
            return true;
        } else if ((arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1]) && arr[0][1] != 0) {
            return true;
        } else if ((arr[0][2] == arr[1][2] && arr[0][2] == arr[2][2]) && arr[0][2] != 0) {
            return true;
        } else if ((arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]) && arr[0][0] != 0) {
            return true;
        } else if ((arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2]) && arr[1][0] != 0) {
            return true;
        } else if ((arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2]) && arr[2][0] != 0) {
            return true;
        } else if ((arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) && arr[0][0] != 0) {
            return true;
        } else if ((arr[2][0] == arr[1][1] && arr[2][0] == arr[0][2]) && arr[2][0] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCanStroke() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doStroke(int xPosition, int yPosition, int player, JFrame frame) {
        tplayer = player;
        if (isGameOver()) {
            System.out.println("Game is over");
            return true;
        } else {
            if (isCanStroke()) {
                arr[xPosition][yPosition] = tplayer;
                if (isGameOver()) {
                    JOptionPane.showMessageDialog(frame, "Congrats, " + tplayer + " player win!");
                    System.out.println("Congrats, " + tplayer + " player win!");
                    return true;
                } else {
                    if (!isCanStroke()) {
                        JOptionPane.showMessageDialog(frame, "Game is over, have not strokes");
                        System.out.println("Game is over, have not strokes");
                        return true;
                    } else {
                        System.out.println("Do stroke player : " + tplayer);
                        return false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Game is over, have not strokes");
                System.out.println("Game is over, have not strokes");
                return true;
            }
        }
        /*if (!isGameOver() && isCanStroke()) {
            arr[xPosition][yPosition] = player;
        } else
            return;*/
    }

    public static void main(String[] args) {

    }

}
