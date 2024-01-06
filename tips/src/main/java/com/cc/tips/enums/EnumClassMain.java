package com.cc.tips.enums;

import java.util.EnumMap;
import java.util.EnumSet;

enum a {
    A("a"),
    B("b"),
    D("d");
    final String a;
    a(String a) {
        this.a=a;
    }
}
public class EnumClassMain {
    enum a {A,B,C};

    public static void main(String[] args) {
        //EnumMap和EnumSet是针对枚举的map 和set
        EnumMap<a,String> enumMap=new EnumMap<>(a.class);
        enumMap.put(a.B,"b");
        enumMap.put(a.C,"c");
        enumMap.put(a.A,"a");


        EnumSet enumSet=EnumSet.allOf(a.class);

        enumSet.iterator().forEachRemaining(System.out::println);

    }
}
