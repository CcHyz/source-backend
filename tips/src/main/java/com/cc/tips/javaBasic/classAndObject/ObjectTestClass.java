package com.cc.tips.javaBasic.classAndObject;

import lombok.Data;


public class ObjectTestClass {
    private String name;
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void talk(){
        System.out.println("name"+this.name+"age:"+age);
    }
}
