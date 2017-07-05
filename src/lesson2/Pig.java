package lesson2;

/**
 * Created by Viktoriya.D on 7/5/2017.
 */
public class Pig extends Animal {
    Pig(String name, double age, double h, int weight, int tail) {
        super(name, age, h, weight, tail);
    }
    @Override
    public String toString() {
        return "I'm a pig :" + "\n" + "My age = " + age + "," + "\n" + "My name is " + name + ", " + '\n' + "My gender = " + gender+ "\nMy height " + h + "\nMy weight " + weight + "\nMy tail " + tail;
    }
}
