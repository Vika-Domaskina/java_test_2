package lesson2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Viktoriya.D on 7/3/2017.
 */
public class CatFighting {
    static Random random = new Random();
    static String a = "Танчо,Тошико,Або-Анс,Абен,Або,Абрек,Абур,Агар,Аюр,Аюрчи,Аякс,Аян,Зука,Зимушка,Агит,Аго";
    static String b = "Задира,Занга,Зара Зея,Зита,Зитта,Зунда,Адон,Азаделло,Айвар,Айгун,Айдан,Атос,Золмо,Запевка,Зита,Зурна";
    static String[] names1 = a.split(",");
    static String[] names2 = b.split(",");
    static ArrayList<Animal> team1= new ArrayList<>();
    static ArrayList<Animal> team2= new ArrayList<>();
    static ArrayList<Animal> winners1 = new ArrayList<>();
    static ArrayList<Animal> winners2 = new ArrayList<>();

    public static void main(String[] args) {
        reGroup(names1, names2);
        teamFighting(team1, team2);
        soutWinners(winners1,winners2);
    }

    static void reGroup(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            team1.add(new Cat(a[i], random.nextInt(20), random.nextInt(50), random.nextInt(25), random.nextInt(40)));
            //System.out.println(names1[i]);
        }
        for (int i = 0; i < b.length; i++) {
            team2.add(new Cat(b[i], random.nextInt(20), random.nextInt(50), random.nextInt(25), random.nextInt(40)));
            //System.out.println(names2[i]);
        }
    }

    static void teamFighting(ArrayList<Animal> team1, ArrayList<Animal> team2) {
        if (team1.size() > 1) {
            System.out.println("* * * * * * * 1/" + team1.size() + " финала! * * * * * *");
            for (int i = 0; i < team1.size(); i++) {
                if (i % 2 == 0) {
                    winners1.add(team1.get(i).fight(team2.get(i)));
                } else winners2.add(team1.get(i).fight(team2.get(i)));
            }
            team1 = new ArrayList<>(winners1);
            team2 = new ArrayList<>(winners2);
            winners1.clear();
            winners2.clear();
            teamFighting(team1,team2);
        } else {
            System.out.println("* * * * * * * Ф И Н А Л!!! * * * * * * *");
            System.out.println(team1.get(0).fight(team2.get(0)).toString());

        }

    }

    static void soutWinners(ArrayList<Animal> winners1, ArrayList<Animal> winners2) {
        for (Animal w : winners1) {
            System.out.println(w);
        }
        for (Animal w : winners2) {
            System.out.println(w);
        }
    }
}
