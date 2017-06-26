package lesson1;

/**
 * Created by Viktoriya.D on 6/12/2017.
 */
public class Task2 {
    public static void main(String[] args) {
        double[] masiv = new double[]{1, 78, 41, 9};
        System.out.println("Original array : ");
        getMasiv(masiv);
        System.out.println("Increased array: ");
        getMasiv(increasedMasiv(masiv, 0.005));

    }

    static double[] increasedMasiv(double[] masiv, double pursent) {
        if (pursent > 1) pursent = pursent / 100;

        double[] clon_masiv = new double[masiv.length];
        for (int i = 0; i < masiv.length; i++) {
            clon_masiv[i] = masiv[i] * (1  + pursent);
        }
        return clon_masiv;
    }

    static void getMasiv(double[] masiv) {
        for (int i = 0; i < masiv.length; i++) {
            System.out.println("element " + i + " = " + masiv[i]);
        }
    }
}
