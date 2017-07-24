package lesson4;

/**
 * Created by Viktoriya.D on 7/12/2017.
 */
public class Cat extends Animal{
    Cat(){
        setCounter();
    }
    static int counter;
    @Override
    public void swimming() {
        System.out.println("Cat is swimming");
    }

    @Override
    public void makeVoice() {
        System.out.println("Weow!");
    }

    @Override
    public void makeCry(int a) {
        System.out.println("WEEEEEEow!!!!!");
    }

     private void setCounter(){
        System.out.println("This set counter from class Cat");
        counter++;
        super.counter++;
    }

    @Override
    protected int getCounter(){
        System.out.println("This get counter from class Cat");
        System.out.println("Cat counter: "+counter);
        System.out.println("Animal counter: "+super.counter);
        return counter;
    }
}
