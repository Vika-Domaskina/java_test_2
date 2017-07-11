package lesson2;

import java.util.ArrayList;
import java.util.Random;

//import static lesson2.Animal.louser;

/**
 * Created by Viktoriya.D on 7/3/2017.
 */
public class CatFighting {
    static Random random = new Random();
    static String strnamesCat = "Танчо,Тошико,Або-Анс,Абен,Або,Абрек,Абур,Агар,Аюр,Аюрчи";
    static String strnamesCat2 = "Задира,Занга,Зара Зея,Зита,Зитта,Зунда,Адон,Азаделло,Айвар,Айгун";
    static String strnamesDog = "Барон,Буч,Боня,Бим,Бадди,Барни,Балу,Барс,Балто,Мася";
    static String strnamesDog2 = "Баксик,Байкал,Бони,Буран,Бёрн,Босс,Блэк,Бой,Мила,Мелиса";
    static String strnamesPig1 = "Бакстер,Блэйк,Бима,Борман,Буян,Барт,Боби,Багги,Бас,Беня";
    static String strnamesPig2 = "Барсик,Бублик,Бумер,Бутч,Бруно,Бонни,Боцман,Бек,Бандит,Бари";
    static String[] namesCat1 = strnamesCat.split(",");
    static String[] namesCat2 = strnamesCat2.split(",");
    static String[] namesDog1 = strnamesDog.split(",");
    static String[] namesDog2 = strnamesDog2.split(",");
    static String[] namesPig1 = strnamesPig1.split(",");
    static String[] namesPig2 = strnamesPig2.split(",");
    static ArrayList<Animal> team1 = new ArrayList<>();
    static ArrayList<Animal> team2 = new ArrayList<>();
    static ArrayList<Animal> winners1 = new ArrayList<>();
    static ArrayList<Animal> winners2 = new ArrayList<>();

    public static void main(String[] args) {
        reGroup(namesCat1, namesCat2, "c");
        reGroup(namesDog1, namesDog2, "d");
        reGroup(namesPig1, namesPig2, "p");
        teamFighting(team1, team2);
        soutWinner(winners1, winners2);

    }

    static void reGroup(String[] arrayNames1, String[] arrayNames2, String typeFighter) {
        for (int i = 0; i < arrayNames1.length; i++) {
            if (typeFighter.equals("c")) {
                team1.add(new Cat(arrayNames1[i], random.nextInt(20), random.nextInt(30), random.nextInt(25), random.nextInt(40)));
            } else if (typeFighter.equals("d")) {
                team1.add(new Dog(arrayNames1[i] + "(D)", random.nextInt(20), random.nextInt(50), random.nextInt(25), random.nextInt(40)));
            } else
                team1.add(new Pig(arrayNames1[i] + "(P)", random.nextInt(20), random.nextInt(50), random.nextInt(100), random.nextInt(40)));
        }
        for (int i = 0; i < arrayNames2.length; i++) {
            if (typeFighter.equals("c")) {
                team2.add(new Cat(arrayNames2[i], random.nextInt(20), random.nextInt(50), random.nextInt(25), random.nextInt(40)));
            } else if (typeFighter.equals("d")) {
                team2.add(new Dog(arrayNames2[i] + "(D)", random.nextInt(20), random.nextInt(50), random.nextInt(25), random.nextInt(40)));
            } else
                team2.add(new Pig(arrayNames2[i] + "(P)", random.nextInt(20), random.nextInt(50), random.nextInt(100), random.nextInt(40)));
        }
    }

    static void teamFighting(ArrayList<Animal> team1, ArrayList<Animal> team2) {
        if (team1.size() > 1) {
            System.out.println("* * * * * * * 1/" + team1.size() + " финала! * * * * * *");
            if ((team1.size() + team2.size()) % 2 != 0) {
                if (team1.size() > team2.size()) {
                    System.out.println("* * * * *");
                    team2.add(new Cat(Animal.louser.get(random.nextInt(Animal.louser.size() - 1)).name + " ZOMBI", random.nextInt(40), random.nextInt(7000000), random.nextInt(410000000), random.nextInt(5000000)));
                    System.out.println("Бог рандома воскресил одного животного:\n" + team2.get(team2.size() - 1));
                    System.out.println("* * * * *");
                } else {
                    System.out.println("* * * * *");
                    team1.add(new Cat(Animal.louser.get(random.nextInt(Animal.louser.size() - 1)).name + " ZOMBI", random.nextInt(40), random.nextInt(7000000), random.nextInt(44100005), random.nextInt(500000)));
                    System.out.println("Бог рандома воскресил одного животного:\n" + team1.get(team1.size() - 1));
                    System.out.println("* * * * *");
                }
            }
            for (int i = 0; i < team1.size(); i++) {
                if (i % 2 == 0) {
                    winners1.add(team1.get(i).fight(team2.get(i)));
                } else winners2.add(team1.get(i).fight(team2.get(i)));
            }
            team1 = new ArrayList<>(winners1);
            team2 = new ArrayList<>(winners2);
            winners1.clear();
            winners2.clear();
            teamFighting(team1, team2);
        } else {
            System.out.println("* * * * * * * Ф И Н А Л!!! * * * * * * *");
            Animal winner = team1.get(0).fight(team2.get(0));
            System.out.println(winner);

        }

    }

    static void soutWinner(ArrayList<Animal> winners1, ArrayList<Animal> winners2) {
        for (Animal w : winners1) {
            System.out.println(w);
        }
        for (Animal w : winners2) {
            System.out.println(w);
        }
    }
}
