package ru.job4j.synchmessaging.temp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
//        var dateToday = LocalDateTime.now();
//        System.out.println(dateToday);
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
//
//
//        var t = calendar.toString().split("T");
//        System.out.println(t[0]);
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
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
        System.out.println(st[0].equals(gf[0]));
    }
}
