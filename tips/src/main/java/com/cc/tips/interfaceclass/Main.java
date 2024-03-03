package com.cc.tips.interfaceclass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
        public static void main(String[] args) {
            List<String> list1 = new ArrayList<>();
            list1.add("A");
            list1.add("B");
            list1.add("C");
            list1.add("C");
            list1.add("C");
            list1.add("C");
            list1.add("C");
            list1.add("C");
            list1.add("C");
            list1.add("C");

            double forCount= Math.ceil((double) list1.size() /3);
            int size= (int) 3;
            for (int i=0;i<forCount;i++){
                List<String> approvalDoList = list1.subList(i, i + 3);

            }
        }



}
