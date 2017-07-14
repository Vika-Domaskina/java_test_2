package lesson4;

/**
 * Created by Viktoriya.D on 7/12/2017.
 */
public abstract class Animal implements Voicable,Swimable {
    protected double age = 0;
    protected String name;
    private static int counter=0;
    void setCounter(){
        System.out.println("This set counter from class Animal");
        counter++;
    }
    int getCounter(){
        System.out.println("This get counter from class Animal");
        return counter;
    }
}
