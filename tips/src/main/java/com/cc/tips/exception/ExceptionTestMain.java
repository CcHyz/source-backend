package com.cc.tips.exception;

import java.util.Comparator;

public class ExceptionTestMain implements Comparable {

    public static void main(String[] args) {
        try {
            aVoid();

        } catch (Exception e) {
            System.out.println(e);
        }
        bVoid();
    }

    public static void aVoid() throws Exception{
        throw new NullPointerException("空指针啦");
    }

    public static void bVoid() {
        int i=1;
        
        try {
            throw new MyException("我自己的异常!");
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    //比较两个值
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
