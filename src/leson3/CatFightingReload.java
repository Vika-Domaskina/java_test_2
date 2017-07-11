package leson3;

import lesson2.Animal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Viktoriya.D on 7/6/2017.
 */
public class CatFightingReload {
    static CatGamer gamer1 = new CatGamer();
    static CatGamer gamer2 = new CatGamer();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        gamer1.name=inputName("Введите имя питомцА!");
        gamer1.age=inputAge("Введите возраст своего питомцА!");
        gamer2.name=inputName("Введите имя питомцА!");
        gamer2.age=inputAge("Введите возраст своего питомцА!");
        introduceCat(gamer1);
        System.out.println("** ** ** ** ** ** ** ** **");
        introduceCat(gamer2);
        Animal.go_to_Sleep(500);
        System.out.println("* * * Раунд 1: Знакомство * * *");
        Animal.go_to_Sleep(500);
        BigFight.fightRound1(gamer1, gamer2);
        System.out.println("** ** ** ** ** ** ** ** ** ** ** ** ** ** **  **");
        Animal.go_to_Sleep(500);
        System.out.println("* * * Раунд 2: проверка базовых навыков * * *");
        Animal.go_to_Sleep(500);
        askOwner(gamer1);
        gamer1.playWithMice = inputInteger("Сколько времени ваш кот играется с мышкой? (от 1 до 10)");
        Animal.go_to_Sleep(500);
        askOwner(gamer2);
        gamer2.playWithMice = inputInteger("Сколько времени ваш кот играется с мышкой? (от 1 до 10)");
        Animal.go_to_Sleep(500);
        askOwner(gamer1);
        gamer1.peeInShoes=inputText("Ваш кот хоть раз писал в тапки? (y/n)");
        Animal.go_to_Sleep(500);
        askOwner(gamer2);
        gamer2.peeInShoes=inputText("Ваш кот хоть раз писал в тапки? (y/n)");
        Animal.go_to_Sleep(500);
        askOwner(gamer1);
        gamer1.weowVolume=inputInteger("Гровкость мурчания (от 1 до 10)");
        Animal.go_to_Sleep(500);
        askOwner(gamer2);
        gamer2.weowVolume=inputInteger("Гровкость мурчания (от 1 до 10)");
        System.out.println("<--------------->");
        Animal.go_to_Sleep(500);
        BigFight.fightRound2(gamer1, gamer2);
        Animal.go_to_Sleep(500);
        System.out.println("** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **");
        System.out.println("* * * Раунд 3: завязка сюжета * * *");
        Animal.go_to_Sleep(500);
        askOwner(gamer1);
        gamer1.friendshipWithCats=inputText("Как ваш кот относится к чужим котам?  (y-хорошо/n-плохо)");
        Animal.go_to_Sleep(500);
        askOwner(gamer2);
        gamer2.friendshipWithCats=inputText("Как ваш кот относится к чужим котам?  (y-хорошо/n-плохо)");
        Animal.go_to_Sleep(500);
        askOwner(gamer1);
        gamer1.likeMilk=inputText("Любит ли ваш кот молоко? (y/n)");
        Animal.go_to_Sleep(500);
        askOwner(gamer2);
        gamer2.likeMilk=inputText("Любит ли ваш кот молоко? (y/n)");
        Animal.go_to_Sleep(500);
        BigFight.fightRound3(gamer1, gamer2);
        System.out.println("** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **");
        BigFight.finalFight(gamer1, gamer2);

    }

    public static String inputText(String question) {
        String row;
        System.out.println(question);
        while (true) {
            try {
                row = reader.readLine();
                if (row.equals("y") || row.equals("n")) {
                    break;
                }
                throw new NullPointerException();
            } catch (Exception e) {
                System.out.println("Не правильное значение, предпологается получить y/n");
            }
        }
        return row;
    }

    public static int inputInteger(String question) {
        int row;
        System.out.println(question);
        while (true) {
            try {
                row = Integer.valueOf(reader.readLine());
                if (row > 0 && row <= 10) {
                    break;
                }
                throw new NumberFormatException();
            } catch (Exception e) {
                System.out.println("Не правильное значение, предпологается получить от 1 до 10");
            }
        }
        return row;
    }

    public static String inputName(String question) {
        String row;
        System.out.println(question);
        while (true) {
            try {
                row = reader.readLine();
                if (row.length()<265 && row.length()>0) {
                    break;
                }
                throw new NullPointerException();
            } catch (Exception e) {
                System.out.println("Введите корректное имя");
            }
        }
        return row;
    }

    public static int inputAge(String question) {
        int row;
        System.out.println(question);
        while (true) {
            try {
                row = Integer.valueOf(reader.readLine());
                if (row > 0 && row < 100) {
                    break;
                }
                throw new NumberFormatException();
            } catch (Exception e) {
                System.out.println("ВВедите правильный возраст");
            }
        }
        return row;
    }

    public static void introduceCat(CatGamer cat) {
        System.out.println("Поприветствуем игрока!");
        System.out.println(cat);
    }

    public static void askOwner(CatGamer cat){
        System.out.println("ХАзяин кота " + cat.name + " ответьте на вопрос:");
    }
}

