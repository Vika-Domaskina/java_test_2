package lesson5;

/**
 * Created by Viktoriya.D on 9/28/2017.
 */
public class ContainsFlyMove implements Flyable {
    @Override
    public boolean speed() {
        return false;
    }

    @Override
    public double speed(Flyable flyable) {
        return 0;
    }
}
