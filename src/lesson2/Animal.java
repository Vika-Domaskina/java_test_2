package lesson2;

import java.util.ArrayList;

/**
 * Created by Viktoriya.D on 6/14/2017.
 */
class Animal {
    static protected long counter;
    protected int fight_counter = 10;
    protected double h;
    protected int weight;
    protected int tail;
    protected double age = 0;
    protected String name;
    protected String gender = "It";
    protected int feet;
    protected String colorsEyes[] = {"", ""};
    public static ArrayList<Animal> louser = new ArrayList<>();


    Animal(double age, String name, String gender) {
        counter++;
        this.age = age;
        this.name = name;
        if (gender.equals("f")) this.gender = gender;
        else if (gender.equals("m")) this.gender = gender;
    }

    Animal(Animal am) {
        counter++;
        this.age = am.age;
        this.name = am.name;
        //this.gender=am.gender;

    }

    Animal(String name, double age, double h, int weight, int tail) {
        this.name = name;
        this.age = age;
        this.h = h;
        this.weight = weight;
        this.tail = tail;

    }

    public Animal() {
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

    protected void go_to_Sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Animal fight(Animal opponent) {
        int counter = 0;
        Animal winner;
        if (opponent.age >= age) {
            if (opponent.age >= 50) {
                fight_counter = fight_counter + 5;
                opponent.weight = 1;
                System.out.println("Старая тварь - подертая тварь!");
            } else {
                opponent.fight_counter++;
                feet = feet - 1;
                System.out.println("Старше скотина, опытней скотина!");
            }
        } else System.out.println(("Понаберали молодняка!"));
        go_to_Sleep(500);
        if (opponent.h > h) {
            opponent.fight_counter = opponent.fight_counter + 2;
            feet = feet - 1;
            System.out.println(this.name + " малой еще навалять своему сопернику!По этому и лишился лапы. ");
        } else {
            fight_counter++;
            opponent.feet = opponent.feet - 1;
            System.out.println(opponent.name + " не дорос еще!По этому и лишился лапы.");
        }
        go_to_Sleep(500);
        if (opponent.weight > weight && opponent.age < 30 && age > 30) {
            fight_counter++;
            opponent.tail = 0;
            System.out.println("Жырный " + opponent.name + " остался без хвоста ");
        } else {
            opponent.fight_counter++;
            fight_counter = fight_counter - 3;
            System.out.println("Куда прешь шашлык!");
        }
        go_to_Sleep(500);
        if (opponent.tail > tail && opponent.feet > feet) {
            fight_counter++;
            System.out.println("Чувак! ты рыжая и хвостатая морда)))Да, да, это тебе " + opponent.name);
        } else if (opponent.feet < feet && tail > opponent.tail && opponent.name.length() < name.length()) {
            opponent.fight_counter = opponent.fight_counter + 2;
            System.out.println(name + ", ты шашлык безхвостый!");
        }
        go_to_Sleep(500);
        if (opponent.name.length() > 3 && name.length() < 5) {
            opponent.fight_counter++;
            System.out.println("Классное имя - " + opponent.name);
        } else {
            fight_counter++;
            System.out.println("Воу! " + name);
        }
        go_to_Sleep(500);
        System.out.println("Итоги битвы: ");
        go_to_Sleep(1000);
        System.out.println("***********************");
        counter = fight_counter - opponent.fight_counter;
        int counter2 = Math.abs(counter);
        if (counter > 0) {
            System.out.print(this.name);
            winner = this;
            louser.add(opponent);
        } else {
            System.out.print(opponent.name);
            winner = opponent;
            louser.add(this);
        }

        if (counter2 >= 6) {
            System.out.println(" порвал в сало!");
        } else if (counter2 < 6 && counter2 >= 3) {
            System.out.println("  порвал в мясо!");
        } else if (counter2 < 3) {
            System.out.println(" накоцал!");
        }
        System.out.println("***********************");
        go_to_Sleep(500);
        return winner;
    }

    @Override
    public String toString() {
        return "I'm Animal :\n" + "My age=" + age + ",\nMy name is " + name + ", \nMy gender=" + gender;
    }
}
