package com.cc.tips.thread;

import com.cc.tips.fzJcDt.Extends.Person;

public class Main {

    public static void main(String[] args) {
        Students person=new Students();
        new Thread(new Product(person)).start();
        new Thread(new Consumer(person)).start();
        new Thread(new Consumer2(person)).start();
    }
}
