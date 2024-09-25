package com.cc.tips.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        //获取时区
        System.out.println(TimeZone.getDefault().toZoneId());
        System.out.println(ZoneId.systemDefault());
        //获取时间戳
        System.out.println(instant.getNano());
        //获取UTC时间
        System.out.println(instant);
        //设置时区
        instant.atZone(ZoneId.of("GMT+8"));
        instant.atZone(ZoneId.of("UTC+8"));
        //向后偏移8小时
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8)));
        //localDate使用ZoneId
        System.out.println(LocalDate.now(ZoneId.of("GMT+8")));
        //instant转date
        System.out.println(Date.from(instant));
        //date
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);
        //format后的
        System.out.println(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(Date.from(instant)));

        System.out.println(java.sql.Date.from(Instant.now()));
        System.out.println(Date.from(Instant.now()));
    }
}
