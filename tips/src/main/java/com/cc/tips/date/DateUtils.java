package com.cc.tips.date;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Slf4j
public class DateUtils {
    public static LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date datePart(Date date) {
        return toDate(toLocalDate(date));
    }

    //JAVA获取某段时间内的所有日期
    public static List<LocalDate> findDates(Date dStart, Date dEnd) {
        LocalDate start = toLocalDate(dStart);
        LocalDate end = toLocalDate(dEnd);

        List<LocalDate> localDates = start.datesUntil(end).collect(Collectors.toList());

        return localDates;
    }

    //获取昨天的零时零分零秒时间
    public static Date getFirstTimeByDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    //获取昨天的23:59:59时间
    public static Date getLastTimeByDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    public static Date timeZoneTransfer(Date time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + 8));
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(time));
        } catch (ParseException e) {
            return null;
        }
    }

    public static String yearMonthToString(YearMonth source) {
        return String.format("%s月", source.toString().replace("-", "年"));
    }

    public static Object Date2anyTime(Date date, String time, String flag) {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        if (flag.equals("String"))
            return format.format(StringUtils.isEmpty(date) ? new Date(time) : date);

        return StringUtils.isEmpty(date) ? new Date(time) : date;
    }

    public static String lastYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, -1);
        int year = c.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    public static int compareTo(Date time1, Date time2) {
        if (ObjectUtils.isEmpty(time1) || ObjectUtils.isEmpty(time2)) {
            return -2;
        }
        LocalDate newDateTime = time1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate oldDateTime = time2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return newDateTime.compareTo(oldDateTime);
    }

    /**
     * 获取当前时间 加减月份
     *
     * @param month 加几个月 或者 减少几个月
     * @return
     */
    public static Date nextMonthFirstDay(int month) {
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        // 将月份加1，得到下个月
        calendar.add(Calendar.MONTH, month);
        // 设置日期为1，即下个月的第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static long betweenMonth(Date dateOne, Date dateTow) {
        // 将 Date 转换为 Instant
        Instant instant1 = dateOne.toInstant();
        Instant instant2 = dateTow.toInstant();

        // 将 Instant 转换为 LocalDate
        LocalDate localDate1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = instant2.atZone(ZoneId.systemDefault()).toLocalDate();

        // 计算两个日期之间的月份数
        return ChronoUnit.MONTHS.between(localDate1, localDate2);
    }


}
