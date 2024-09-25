package com.cc.tips.basic;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String date = "2024-01-01";
        System.out.println(DateUtil.parse(date));
        LocalDate now = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        System.out.println(now);
        System.out.println(!LocalDate.of(2025, 12, 1).isAfter(LocalDate.of(2024, 12, 31)));
    }
}
