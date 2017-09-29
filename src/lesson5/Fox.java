package lesson5;

import java.awt.*;

/**
 * Created by Viktoriya.D on 9/28/2017.
 */
public class Fox implements Animal {
    public String getName() {

        return "Fox";

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Integer getAge() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Fox fox = new Fox();
        System.out.println(fox.getName());
    }
}
