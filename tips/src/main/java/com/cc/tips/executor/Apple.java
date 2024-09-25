package com.cc.tips.executor;

public class Apple {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Apple(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
