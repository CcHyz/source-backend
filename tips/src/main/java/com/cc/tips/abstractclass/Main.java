package com.cc.tips.abstractclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main{


//    public static void main(String[] args) {
//        DoService doService=new ComputerServiceImpl();
//        System.out.println(doService.play());
//        System.out.println(doService.go());
//
//        DoService doService1=new PhoneServiceImpl();
//        System.out.println(doService1.play());
//        System.out.println(doService1.go());
//
//        DoService doService2=new DoService() {
//            @Override
//            public String play() {
//                return "自定义实现";
//            }
//        };
//        System.out.println(doService2.play());
//        System.out.println(doService2.go());
//
//
//
//    }




        public static void main(String[] args) {
            Calendar c = Calendar.getInstance();
            c.set(2017,10,1);
                 //通过日历对象得到日期对象
                 Date date = c.getTime();

            Calendar c1 = Calendar.getInstance();
            c1.set(2016,10,1);
            //通过日历对象得到日期对象
            Date date1 = c1.getTime();
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.execute(()->new Service().dos(date));
            executorService.execute(()->new Service().dos(date1));
            executorService.shutdown();
        }



}
