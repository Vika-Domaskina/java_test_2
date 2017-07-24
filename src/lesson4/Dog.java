package lesson4;

/**
 * Created by Viktoriya.D on 7/19/2017.
 */
public class Dog extends Animal {
    Dog(){
        setCounter();
    }
    static int counter;

    @Override
    public void swimming()  {
        System.out.println("Dog is swimming");
    }

    @Override
    public void makeVoice() {
        System.out.println("Gav!");
    }

    @Override
    public void makeCry(int a) {
        System.out.println("Aaavvv!");
    }

    private void setCounter() {
        System.out.println("This set counter from class Dog");
        counter++;
        super.counter++;
    }

    @Override
    protected int getCounter() {
        System.out.println("This get counter from class Dog");
        System.out.println("Dog counter: "+counter);
        System.out.println("Animal counter: "+super.counter);
        return counter;
    }
}
