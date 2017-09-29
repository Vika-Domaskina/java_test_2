package lesson5;

/**
 * Created by Viktoriya.D on 9/26/2017.
 */
public class Exeption123 {
    public static void main(String[] args) throws Exception {
//напишите тут ваш код
        try {
            method1();
        } catch (Exception3 s) {
            System.out.println(s + "intercepted33333!!!!!");
        } catch (Exception2 r) {
            System.out.println(r + "intercepted22222!!!!!!!");
        } catch (Exception1 e) {
            System.out.println(e + "intercepted11111!!!!!!");
        }

//напишите тут ваш код

    }

    public static void method1() throws Exception1, Exception2, Exception3, Exception4 {
        int i = (int) (Math.random() * 30); /*27;*/
        System.out.println(i);
        if (i == 0)
            throw new Exception1();
        if (i < 10)
            throw new Exception2();
        if (i < 100)
            throw new Exception3();
        if (i == 27)
            throw new Exception4();
    }
}

class Exception1 extends RuntimeException {
    public String toString() {
        return "RuntimeException [= 0]";
    }
}

class Exception2 extends Exception {
    public String toString() {
        return "MyException2 [<10]";
    }
}

class Exception3 extends Exception {
    public String toString() {
        return "MyException3 [< 100]";
    }
}

class Exception4 extends RuntimeException {
    public String toString() {
        return "RuntimeException [==27]";
    }
}


