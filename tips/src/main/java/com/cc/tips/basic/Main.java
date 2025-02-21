package com.cc.tips.basic;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String date = "2024-01-01";
        System.out.println(DateUtil.parse(date));
        LocalDate now = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        System.out.println(now);
        System.out.println(!LocalDate.of(2025, 12, 1).isAfter(LocalDate.of(2024, 12, 31)));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(2);
        list3.add(1);

        System.out.println(list1.equals(list2)); // true
        System.out.println(list1.equals(list3)); // false
    }
}
