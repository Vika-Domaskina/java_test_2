package lesson2;

/**
 * Created by Viktoriya.D on 6/26/2017.
 */
public class Cat extends Animals {
    Cat(double age, String name, String gender) {
        super(age, name, gender);
    }

    Cat() {
    }

    void voice() {
        for (int i = 0; i < age; i++) {
            System.out.println("Meow!");
        }
    }

    void fight(Animals opponent) {
        int counter = 0;
        if (opponent.age >= age) {
            if (opponent.age>=50){
                fight_counter++;
                System.out.println("Старый кот обречен на поражение!");
            } else {
                opponent.fight_counter++;
                System.out.println("Старше кот, опытней кот!");
            }
        }
        if (opponent.h>h){
            opponent.fight_counter++;
            System.out.println(this.name + "малой еще навалять своему сопернику!");
        } else {
            fight_counter++;
            System.out.println(opponent.name + "не дорос еще!");
        }
        if (opponent.weight>weight){
            fight_counter++;
            System.out.println("Жырный " + opponent.name + " -мертвый "+ opponent.name);
        } else {
            opponent.fight_counter++;
            System.out.println("Куда прешь шашлык!");
        }
        if (opponent.tail>tail){
            fight_counter++;
            System.out.println("Чувак! ты рыжая и хвостатая морда)))Да, да, это тебе " + opponent.name);
        } else {
            opponent.fight_counter++;
            System.out.println(name + ", ты шашлык безхвостый!" );
        }
        if (opponent.name.length()>3 && name.length()<5){
            opponent.fight_counter++;
            System.out.println("Классное имя - " + opponent.name);
        } else {
            fight_counter++;
            System.out.println("Воу! " + name);
        }
        

    }

    @Override
    public String toString() {
        return "I'm a cat :" + "\n" + "My age = " + age + "," + "\n" + "My name is " + name + ", " + '\n' + "My gender = " + gender;
    }
}
