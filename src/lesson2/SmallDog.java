package lesson2;

/**
 * Created by Viktoriya.D on 6/26/2017.
 */
public class SmallDog extends Dog {
    protected String hair;
    protected int teeth=0;

    SmallDog(double age, String name, String gender, String type) {
        super(age, name, gender, type);
    }

    SmallDog(double age, String name, String gender, String type, String hair) {
        super(age, name, gender, type);
        this.hair = hair;
    }

    SmallDog(SmallDog dog) {
        super(dog.age, dog.name, dog.gender, dog.type);
        this.hair = dog.hair;
    }

    SmallDog() {
        counter++;
    }

    protected int setTeeth(int count) {
        if (count < 4 && this.age < 1) {
            teeth = (int) (count * age);
        } else teeth = count;
        return teeth;
    }

    protected void getTeeth(){
        System.out.println(teeth);
    }

    @Override
    public String toString() {
        return "I'm a small dog " + type + ":" + "\n" + "My age=" + age + "," + "\n" + "My name is " + name + ", " + '\n' + "My gender = " + gender + '\n' + "I have " + hair + " hair";
    }

}
