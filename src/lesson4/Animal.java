package lesson4;

/**
 * Created by Viktoriya.D on 7/12/2017.
 */
public abstract class Animal implements Voicable,Swimable {
    protected double age = 0;
    protected String name;
    protected static int counter=0;
    protected abstract int getCounter();
}
