package com.cc.tips.fzJcDt.Extends;

public class Person {
     String name="I";
    private String age="20";

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println(name+age);
    }

    public void talk(String name){
        System.out.println(name);
    }

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
}
