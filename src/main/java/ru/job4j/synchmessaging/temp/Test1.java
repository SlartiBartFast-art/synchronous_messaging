package ru.job4j.synchmessaging.temp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test1 {

    static Date subtractDays(int day, boolean flag) {
        Date date = new Date(System.currentTimeMillis());
        int days = day;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        if (!flag) {
            cal.add(Calendar.DATE, -days);
            return cal.getTime();
        }
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static void main(String[] args) {
        /* var dateToday = LocalDateTime.now();
        System.out.println(dateToday);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        var t = calendar.toString().split("T");
        System.out.println(t[0]);*/

   /*     Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);
        var st = timestamp.toString().split(" ");
        System.out.println(st[0]);
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        var rt =  formatter.format(d);
        System.out.println("->" + rt);
        var gf = rt.split(" ");
        System.out.println(gf[0]);
        System.out.println(st[0].equals(gf[0]));*/

        var minys = subtractDays(1, false);
        var plus = subtractDays(90, true);
        System.out.println(minys);
        System.out.println(plus);
    }
}
