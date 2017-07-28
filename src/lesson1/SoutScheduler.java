package lesson1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Viktoriya.D on 7/20/2017.
 */
public class SoutScheduler {

    static Date date2 = new Date();

    private static Timer timer = new Timer();
    private static TaskTime taskTime = new TaskTime();

    public static void main(String args[]) {


        double startTime = System.currentTimeMillis();
//        System.out.println(startTime + System.currentTimeMillis());
        timer.schedule(taskTime, 0, 1000);
//        if (System.currentTimeMillis() - startTime > 0.10000) {
//            timer.cancel();
//            System.out.println("fwefwefwefwef");
//        }

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("fwefwefwefwef");


//        Calendar calendar = Calendar.getInstance();
//        SimpleTimeZone simpleTimeZone=new SimpleTimeZone(+8, "UTC");
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar.get(Calendar.HOUR) + 6);
//        System.out.println(calendar.get(Calendar.MINUTE));
//        System.out.println(simpleTimeZone.getOffset(calendar.ERA,calendar.YEAR,calendar.MONTH,calendar.DAY_OF_MONTH));

//        System.out.println("Default time zone: " + dateFormat.getTimeZone().getID());
//        dateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Perth"));
//        System.out.println("AU Time " + dateFormat.format(date));
//        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
//        System.out.println("UK Time " + dateFormat.format(date));


    }


    static class TaskTime extends TimerTask {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        public void printDateByDateFormat(String timeZone) {
            dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
            Date date = new Date();
            System.out.println("Time " + dateFormat.getTimeZone().getID() + ": " + dateFormat.format(date));

        }


        @Override
        public void run() {
            printDateByDateFormat("Australia/Perth");
            printDateByDateFormat("Europe/Kiev");

        }
    }


}
