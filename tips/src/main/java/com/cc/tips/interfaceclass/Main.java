package com.cc.tips.interfaceclass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //结：对于实现doService接口的实现类便展示了多态的样子

        DoService doService=new PhoneServiceImpl();
        //走的PhoneServiceImpl实现类 结果：手机phone play
        System.out.println(doService.play());
        PhoneServiceImpl phoneService=new PhoneServiceImpl();
        //走的PhoneServiceImpl实现类 结果：手机phone play
        System.out.println(phoneService.play());

        DoService computerService=new ComputerServiceImpl();
        //走的ComputerServiceImpl实现类 结果：电脑computer play
        System.out.println(computerService.play());

        DoService doService1=new DoService() {
            @Override
            public String play() {
                return "自定义实现";
            }
        };
        //走的是doService1自定义的实现 结果：自定义实现
        System.out.println(doService1.play());



    }



}
