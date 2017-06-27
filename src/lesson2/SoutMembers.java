package lesson2;

/**
 * Created by Viktoriya.D on 6/14/2017.
 */
public class SoutMembers {
    public static void main(String[] args) {
       /* Animals exem = new Animals(0.2, "Grut", "m");
        Animals exem2 = new Animals(6, "Gera","f");
        Animals exem3 = new Animals(3, "Shashluk","gdrt");
        Animals exem4 = new Animals(2, "Lara","kjg");
        System.out.println(exem);
        exem.setFeet(2);
        System.out.println("My height : "+ exem.heightAnimal(4));
        System.out.println();
        System.out.println(exem2);
        exem2.setFeet(4);
        System.out.println("I have "+ exem2.getFeet() + " feets");
        System.out.println("My height : "+ exem2.heightAnimal(5));
        exem2.setColorsEyes("green","blue");
        System.out.print( "Color my eyes :");
        for (int i = 0; i<exem2.getColorsEyes().length; i++){
            System.out.print(exem2.colorsEyes[i]);
        }*/

        Dog dog1 = new Dog(4, "Chak", "m", "Staf");
        /*System.out.println("\n" + "\n");
        System.out.println(dog1);
        dog1.voice();
        System.out.println("\n" + "\n");
        Animals dog2 = new Animals(1, "Beer", "m");
        dog2 = dog1;
        System.out.println(dog2);
        dog2.voice();
        System.out.println(dog2.getClass().getName());*/

        /*Dog dog3 = new Dog();
        System.out.println("\n" + "\n");
        System.out.println(dog3);
        Animals dog4 = new Animals(1, "Beer", "m");
        System.out.println("\n" + "\n");
        System.out.println(dog4);
        dog4 = dog3;
        System.out.println("\n" + "\n");
        System.out.println(dog4);
        dog4.setFeet(2);
        dog4.age = 5;
        dog4.gender = "f";
        System.out.println(dog3.getAge());
        System.out.println(dog3.getFeet());
        System.out.println(dog3);
        System.out.println("\n" + "\n");
        System.out.println(dog4);
        dog3.name = "Lia";
        System.out.println("\n" + "\n");
        System.out.println(dog3);
        System.out.println("\n" + "\n");
        System.out.println(dog4);*/

        Animals anim1 = new Animals(7, "Din", "m");
        /*Animals anim2 = new Animals (anim1);
        System.out.println("\n" + "\n");
        System.out.println(anim1);
        System.out.println("\n" + "\n");
        System.out.println(anim2);
        anim1.age=34;
        System.out.println("\n" + "\n");
        System.out.println(anim1);
        System.out.println("\n" + "\n");
        System.out.println(anim2);*/

        /*Dog dog1 = new Dog(12,34);
        System.out.println(dog1);
        System.out.println("My feets : " + dog1.getFeet());
        dog1.show();
        System.out.println("My feets : " + dog1.getFeet(5));*/

        SmallDog sdog1 = new SmallDog(2.1, "Buba", "f", "picines", "green");
        /*SmallDog dog2 = new SmallDog(dog1);
        System.out.println(dog1);
        System.out.println();
        System.out.println(dog2);
        dog2.name="Huba";
        System.out.println();
        System.out.println(dog2)*/
        ;

        Cat cat1 = new Cat(3, "Barsik", "m");
        Cat cat2 = new Cat(6, "Barsikos", "m");
        /*System.out.println(cat1);
        cat1.voice();*/
        Animals[] array = {anim1, dog1, sdog1, cat1};
        for (int i = 0; i < array.length; i++) {
            array[i].voice();
        }
        System.out.println(cat1.fight(anim1));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cat1.fight(sdog1));
        System.out.println(cat1.fight(cat2));

    }
}
