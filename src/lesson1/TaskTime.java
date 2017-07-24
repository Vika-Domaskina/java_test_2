package lesson1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by Viktoriya.D on 7/20/2017.
 */
public class TaskTime {
    public static void main(String args[]) {
//        Calendar calendar = Calendar.getInstance();
//        SimpleTimeZone simpleTimeZone=new SimpleTimeZone(+8, "UTC");
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar.get(Calendar.HOUR) + 6);
//        System.out.println(calendar.get(Calendar.MINUTE));
//        System.out.println(simpleTimeZone.getOffset(calendar.ERA,calendar.YEAR,calendar.MONTH,calendar.DAY_OF_MONTH));

        DateFormat dfm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
//        try {
//            date = dfm.parse("23-07-2017 17:26:31");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        System.out.println("Default time zone: " + dfm.getTimeZone().getID());
        dfm.setTimeZone(TimeZone.getTimeZone("Australia/Perth"));
        System.out.println("AU Time " + dfm.format(date));

        dfm.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
        System.out.println("UK Time " + dfm.format(date));


        Calendar cldr = GregorianCalendar.getInstance(TimeZone.getTimeZone("Australia/Perth"));
        System.out.println("--------------->>>>" + cldr.get(Calendar.HOUR));


    }
}
