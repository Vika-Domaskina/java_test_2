package lesson4;

/**
 * Created by Viktoriya.D on 7/12/2017.
 */
public class Cat extends Animal{
    static int counter;
    @Override
    public void swimming() {
        System.out.println("I'm swimming");
    }

    @Override
    public void makeVoice() {
        System.out.println("Weow!");
    }

    @Override
    public void makeCry(int a) {
        System.out.println("WEEEEEEow!!!!!");
    }

    void setCounter(){
        System.out.println("This set counter from class Cat");
        counter++;
    }
    int getCounter(){
        System.out.println("This get counter from class Cat");
        return counter;
    }
}
