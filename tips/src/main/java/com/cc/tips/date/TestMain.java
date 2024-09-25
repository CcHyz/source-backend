package com.cc.tips.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestMain {

    public static void main(String[] args) throws ParseException {
        Instant now = Instant.now();
        Date datePart = DateUtils.datePart(Date.from(now));
        System.out.println(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(datePart));
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(datePart);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); // date actually start with int 0;
        System.out.println(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    }
}
