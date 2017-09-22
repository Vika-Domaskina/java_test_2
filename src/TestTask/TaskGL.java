package TestTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Viktoriya.D on 9/22/2017.
 * We have street temperature for current week in C° per each day.
 * Write code for function that finds:
 * ● average week value
 * ● prints first day of week that has temperature nearest to the week average value.
 */
public class TaskGL {
    public void averageTemperature(int[] temper) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        int average = 0;
        int winnerDay = -1;
        int diff1 = 9999999;
        for (int i = 0; i < temper.length; i++) {
            average = average + temper[i];
        }
        average = average / temper.length;
        System.out.println("Average temperature: " + average);
        for (int i = 0; i < temper.length; i++) {
            if (Math.abs(average - temper[i]) < diff1 && Math.abs(average - temper[i])!=diff1) {
                winnerDay = i;
                diff1 = Math.abs(average - temper[i]);
                /*System.out.println("winner day " + winnerDay);*/
            }
        }
        calendar.add(Calendar.DAY_OF_WEEK, winnerDay);
        System.out.println(average);
        System.out.println(calendar.getTime());
    }

    public static void main(String[] args) {
        TaskGL test=new TaskGL();
        int[] temperature = {10, 5, -7, 15, 21, 36, 55};
        test.averageTemperature(temperature);

    }
}
