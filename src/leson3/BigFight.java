package leson3;

/**
 * Created by Viktoriya.D on 7/7/2017.
 */
public class BigFight {

    public static void fightRound1(CatGamer opponent, CatGamer opponent2) {
        if (opponent.age >= opponent2.age) {
            if (opponent.age >= 50) {
                opponent2.fight_counter = opponent2.fight_counter + 5;
                System.out.println("Старина " + opponent.name + " исчерпал почти все свои жизни!");
            } else {
                opponent.fight_counter++;
                System.out.println("У нас тут прям мАлАдой хищник по кличке " + opponent.name + "!");
            }
        } else {
            System.out.println(("Понаберали молодняка!"));
            opponent.fight_counter++;
        }
    }

    public static void fightRound2(CatGamer opponent, CatGamer opponent2) {
        if (opponent2.playWithMice > opponent.playWithMice) {
            System.out.println(opponent2.name + " очень игривый!");
            opponent2.fight_counter = opponent2.fight_counter + 2;
            if (opponent2.peeInShoes.equals("y")) {
                System.out.println("Какой то гаденыш вам попался писающий :)");
                opponent2.fight_counter = opponent2.fight_counter - 1;
            } else System.out.println("К тому же и очень послушный :)");
            opponent2.fight_counter = opponent2.fight_counter + 2;
            System.out.println(opponent.name + " очень спокойный и сдержанный");
        } else {
            System.out.println(opponent.name + "дурашливый и милый!");
            opponent.fight_counter = opponent.fight_counter + 3;
            if (opponent.peeInShoes.equals("y")) {
                opponent.fight_counter = opponent.fight_counter - 1;
                System.out.println(opponent.name + "писающий котик! Ж)");
            }
        }
        if (opponent.weowVolume > opponent2.weowVolume) {
            opponent.fight_counter=opponent2.fight_counter+3;
            System.out.println(opponent.name + " голосистый!!!");
        } else {
            opponent2.fight_counter++;
            System.out.println(opponent2.name + " кричун!!!");
        }
    }

    public static void fightRound3(CatGamer opponent, CatGamer opponent2) {
        if (opponent.friendshipWithCats.equals("y")) {
            if (opponent.weowVolume >= 0 && opponent.weowVolume < 3) {
                opponent.fight_counter++;
                System.out.println("Общительная тихоня - " + opponent.name);
            } else if (opponent.weowVolume >= 3 && opponent.weowVolume < 7) {
                System.out.println("Дружелюбность у " + opponent.name + " на лицо!");
                opponent.fight_counter = opponent.fight_counter + 2;
            } else {
                opponent.fight_counter = opponent.fight_counter + 3;
                System.out.println("Дружелюбная няшка!)");
            }
        } else {
            if (opponent.weowVolume >= 0 && opponent.weowVolume < 3) {
                System.out.println("Одним словом: не дружелюбный котик " + opponent.name);
                opponent.fight_counter--;
            } else if (opponent.weowVolume >= 3 && opponent.weowVolume < 7) {
                System.out.println("Противный кот  " + opponent.name + " на ринге!!!!");
                opponent.fight_counter = opponent.fight_counter - 2;
            } else {
                opponent.fight_counter = opponent.fight_counter - 3;
                System.out.println("Скотина - " + opponent.name + "!)");
            }
        }
        if (opponent2.friendshipWithCats.equals("y")) {
            if (opponent2.weowVolume >= 0 && opponent2.weowVolume < 3) {
                opponent2.fight_counter++;
                System.out.println("Общительная тихоня - " + opponent2.name);
            } else if (opponent2.weowVolume >= 3 && opponent2.weowVolume < 7) {
                System.out.println("Дружелюбность у " + opponent2.name + " на лицо!");
                opponent2.fight_counter = opponent2.fight_counter + 2;
            } else {
                opponent2.fight_counter = opponent2.fight_counter + 2;
                System.out.println("Дружелюбная няшка!)");
            }
        } else {
            if (opponent2.weowVolume >= 0 && opponent2.weowVolume < 3) {
                System.out.println("Одним словом: не дружелюбный котик " + opponent2.name);
                opponent2.fight_counter--;
            } else if (opponent2.weowVolume >= 3 && opponent2.weowVolume < 7) {
                System.out.println("Противный кот  " + opponent2.name + " на ринге!!!!");
                opponent2.fight_counter = opponent2.fight_counter - 2;
            } else {
                opponent2.fight_counter = opponent2.fight_counter - 3;
                System.out.println("Скотина - " + opponent2.name + "!)");
            }
        }
        if (opponent.likeMilk.equals("y") && opponent2.likeMilk.equals("y")) {
            opponent.fight_counter = opponent.fight_counter + 2;
            opponent2.fight_counter = opponent2.fight_counter + 2;
            System.out.println("У нас тут любители молочка!Истинные коты - " + opponent.name + " и " + opponent2.name);
        } else if (opponent.likeMilk.equals("n") && opponent2.likeMilk.equals("n")) {
            opponent.fight_counter = opponent.fight_counter - 2;
            opponent2.fight_counter = opponent2.fight_counter - 2;
            System.out.println("Не любители молока...А битва становится интересной!Два лузера");
        } else if (opponent.likeMilk.equals("y") && opponent2.likeMilk.equals("n")) {
            opponent.fight_counter = opponent.fight_counter + 2;
            System.out.println("Нет сил, нет молока!!!" + opponent.name + " вырывается вперед!!");
        } else {
            opponent2.fight_counter = opponent2.fight_counter + 2;
            System.out.println("Нет сил, нет молока!!!" + opponent2.name + " вырывается вперед!!");
        }

    }

    public static CatGamer finalFight(CatGamer opponent, CatGamer opponent2){
        int counter = 0;
        CatGamer winner;
        counter = opponent.fight_counter - opponent2.fight_counter;
        int counter2 = Math.abs(counter);
        if (counter > 0) {
            System.out.print(opponent.name);
            winner = opponent;
        } else {
            System.out.print(opponent2.name);
            winner = opponent2;
        }
        if (counter2 >= 6) {
            System.out.println(" порвал в сало!");
        } else if (counter2 < 6 && counter2 >= 3) {
            System.out.println("  порвал в мясо!");
        } else if (counter2 < 3) {
            System.out.println(" накоцал!");
        }
        System.out.println("** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **");
        return winner;
    }
}
