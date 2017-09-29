package lesson5;

/**
 * Created by Viktoriya.D on 9/29/2017.
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("My current thread " + thread);
        thread.setName("My thread");
        System.out.println(thread);
        try{
            for (int i=5;i>0;i--){
                if(i==3) {
                    System.out.println(i);
                    thread.interrupt();
                    Thread.sleep(2000);
                }
            }
        }catch (InterruptedException e){
            System.out.println("main execution thread interrupted");
        }
    }
}
