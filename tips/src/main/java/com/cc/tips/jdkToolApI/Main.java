package com.cc.tips.jdkToolApI;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
//            Integer a=0;
//            if (a==0){
//                System.exit(0);
//            }
            String cc = System.getenv("aa");
            System.out.println(cc);
            String property = System.getProperty("cc");
            System.out.println(property);
            Properties properties = System.getProperties();
            Enumeration<?> enumeration = properties.propertyNames();
            Iterator<?> iterator = enumeration.asIterator();
            iterator.forEachRemaining(System.out::println);
            properties.put("a", "b");
            System.setProperty("d","d");
            System.out.println("------------------------------");
            Enumeration<?> enumeration1 = properties.propertyNames();
            Iterator<?> iterator2 = enumeration1.asIterator();
            iterator2.forEachRemaining(System.out::println);

            System.out.println(properties.getProperty("a"));
        } catch (Exception e){
            System.exit(1);
        }

        Runtime runtime = Runtime.getRuntime();
        runtime.freeMemory();//剩余内存
        runtime.totalMemory();//总内存
        runtime.maxMemory();//最大内存
        System.out.println("free"+runtime.freeMemory()+"total:"+runtime.totalMemory()+"max:"+runtime.maxMemory());
        runtime.gc();
//        runtime.exit(1);


    }
}
