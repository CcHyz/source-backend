package com.cc.tips.fzJcDt.Extends;

import lombok.Data;


public class Student extends Person{
    private String school;

    public Student(String name,String age,String school) {
        //注：super時如果要使用父類的属性父类就要有有参数构造
        super(name,age);
        this.school = school;
    }

    public Student(String name,String school) {
        super.name=name;
        this.school = school;
    }

    public Student(String school) {
        name="a";
        this.school = school;
    }

     Student() {
         super();
     }

     //继承后如果方法属性返回值与父类相同则会直接覆写即不调用父类的这个方法
    public void talk(String name){
        System.out.println(name+"a");
    }
}
