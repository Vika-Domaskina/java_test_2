package lesson5;

/**
 * Created by Viktoriya.D on 9/26/2017.
 */
public class Exeption123 {
    public static void main(String[] args) throws Exception {
//напишите тут ваш код

        method1();

//напишите тут ваш код

    }

    public static void method1() throws Exception1, Exception2, Exception3 {
        int i = (int) (Math.random() * 3);
        if (i <100)
            throw new Exception1();
        if (i <10)
            throw new Exception2();
        if (i == 0)
            throw new Exception3();
    }
}

class Exception1 extends Exception {
    
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception2 {
}


