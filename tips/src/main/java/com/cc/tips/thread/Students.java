package com.cc.tips.thread;

public class Students {
    public String name;
    public int age;
    public boolean flag;

    public synchronized String get() {
        if (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String a=this.name+"->"+this.age;
        notify();
        return a;
    }

    public synchronized void set(String name,int age) {
        if (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.name = name;
        this.age = age;
        flag=true;
        notify();

    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized int getAge() {
        return age;
    }

    public synchronized void setAge(int age) {
        this.age = age;
    }
}
