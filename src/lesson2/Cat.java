package lesson2;

/**
 * Created by Viktoriya.D on 6/26/2017.
 */
public class Cat extends Animals {
    Cat(double age, String name, String gender) {
        super(age, name, gender);
    }

    Cat(String name, double age, double h, int weight, int tail) {
        super(name, age, h, weight, tail);
    }

    void voice() {
        for (int i = 0; i < age; i++) {
            System.out.println("Meow!");
        }
    }

    void fight(Animals opponent) {
        int counter = 0;
        if (opponent.age >= age) {
            if (opponent.age >= 50) {
                fight_counter = fight_counter + 5;
                opponent.weight = 1;
                System.out.println("Старый кот - подертый кот!");
            } else {
                opponent.fight_counter++;
                feet = feet - 1;
                System.out.println("Старше кот, опытней кот!");
            }
        } else  System.out.println(("Понаберали молодняка!"));
        go_to_Sleep(3000);
        if (opponent.h > h) {
            opponent.fight_counter = opponent.fight_counter + 2;
            feet = feet - 1;
            System.out.println(this.name + " малой еще навалять своему сопернику!По этому и лишился лапы. ");
        } else {
            fight_counter++;
            opponent.feet = opponent.feet - 1;
            System.out.println(opponent.name + " не дорос еще!По этому и лишился лапы.");
        }
        go_to_Sleep(3000);
        if (opponent.weight > weight && opponent.age < 30 && age > 30) {
            fight_counter++;
            opponent.tail = 0;
            System.out.println("Жырный " + opponent.name + " остался без хвоста ");
        } else {
            opponent.fight_counter++;
            fight_counter = fight_counter - 3;
            System.out.println("Куда прешь шашлык!");
        }
        go_to_Sleep(3000);
        if (opponent.tail > tail && opponent.feet > feet) {
            fight_counter++;
            System.out.println("Чувак! ты рыжая и хвостатая морда)))Да, да, это тебе " + opponent.name);
        } else if (opponent.feet < feet && tail > opponent.tail && opponent.name.length() < name.length()) {
            opponent.fight_counter = opponent.fight_counter + 2;
            System.out.println(name + ", ты шашлык безхвостый!");
        }
        go_to_Sleep(3000);
        if (opponent.name.length() > 3 && name.length() < 5) {
            opponent.fight_counter++;
            System.out.println("Классное имя - " + opponent.name);
        } else {
            fight_counter++;
            System.out.println("Воу! " + name);
        }
        go_to_Sleep(3000);
        System.out.println("Итоги битвы: ");
        go_to_Sleep(5000);
        counter = fight_counter - opponent.fight_counter;
        int counter2 = Math.abs(counter);
        if (counter > 0) {
            System.out.print("Ты его");
        } else System.out.print("Тебя");

        if (counter2 == 6) {
            System.out.println(" порвал в сало!");
        } else if (counter2 < 6 && counter2 >= 3) {
            System.out.println("  порвал в мясо!");
        } else if (counter2 < 3) {
            System.out.println(" накоцал!");
        }


    }

    @Override
    public String toString() {
        return "I'm a cat :" + "\n" + "My age = " + age + "," + "\n" + "My name is " + name + ", " + '\n' + "My gender = " + gender;
    }
}
