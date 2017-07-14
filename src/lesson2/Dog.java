package lesson2;

/**
 * Created by Viktoriya.D on 6/22/2017.
 */
public class Dog extends Animal {
    public String type;

    Dog(double age, String name, String gender, String type) {
        super(age, name, gender);
        this.type = type;
    }

    Dog(double age, String name, String gender) {
        super(age, name, gender);
    }

    Dog(int feet, int age) {
        super.feet=feet;
        this.feet=age;
    }
    Dog(String name, double age, double h, int weight, int tail) {
        super(name, age, h, weight, tail);
    }

    Dog() {
        counter++;
    }

    void show(){
        System.out.println("This " + this.feet);
        System.out.println("Super " + super.feet);
    }

    protected int getFeet(int u) {
        System.out.println("*********************************************");
        System.out.println(this.feet);
        System.out.println(super.feet);
        System.out.println("*********************************************");
        return this.feet;
    }


    void voice() {
        for (int i = 0; i < this.age; i++) {
            System.out.println("Gav!");
        }
    }

    @Override
    public String toString() {
        return "I'm " + type + ":" + "\n" + "My age=" + age + "," + "\n" + "My name is " + name + ", " + '\n' + "My gender = " + gender+ "\nMy height " + h + "\nMy weight " + weight + "\nMy tail " + tail;
    }
    @Override
    public void eatSomething() {
        System.out.println("ЖРАТЬ СОБАКЕ!");
    }
}
