package lesson2;

/**
 * Created by Viktoriya.D on 6/14/2017.
 */
class Animals {
    static protected long counter;
    protected double age = 0;
    protected String name;
    protected String gender = "It";
    protected int feet;
    protected String colorsEyes[] = {"", ""};

    Animals(double age, String name, String gender) {
        counter++;
        this.age = age;
        this.name = name;
        if (gender.equals("f")) this.gender = gender;
        else if (gender.equals("m")) this.gender = gender;
    }

    Animals(Animals am) {
        counter++;
        this.age=am.age;
        this.name=am.name;
        //this.gender=am.gender;

    }

    public Animals() {
        counter++;
    }

    public double getAge() {
        return age;
    }

    public static long getCounter() {
        return counter;
    }

    void voice() {
        for (int i = 0; i < age; i++) {
            System.out.println("I`m");
        }
    }

    /*String gender (String gender){

    }*/
    protected void setFeet(int feet) {
        this.feet = feet;
    }

    protected int getFeet() {
        return this.feet;
    }

    double heightAnimal(double weight) {
        double h;
        if (this.age < 1) {
            h = this.age * weight;
        } else if (this.gender.equals("f")) {
            h = weight * 2;
        } else h = weight * 3;
        return h;
    }

    protected void setColorsEyes(String eye1) {
        this.colorsEyes[1] = eye1;
    }

    protected void setColorsEyes(String eye1, String eye2) {
        this.colorsEyes[0] = eye1;
        this.colorsEyes[1] = eye2;
    }

    protected String[] getColorsEyes() {
        return this.colorsEyes;
    }

    @Override
    public String toString() {
        return "I'm Animals :" + "\n" + "My age=" + age + "," + "\n" + "My name is " + name + ", " + '\n' + "My gender=" + gender;
    }
}
