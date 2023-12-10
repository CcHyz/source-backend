package com.cc.tips.javaBasic.classAndObject;

/*
* @description: BasicTest
* @author Cc
* @date 2023/11/26 10:41
*/
public class ClassExample {
    //static关键字：用它修饰的类，方法，属性在类的加载时就会被调用，程序不终止或者不卸载这个类就一直存在，存放在jvm的方法区中
    //静态变量：是放在方法区是全局公用的，程序不终止就一直存在。 如ab静态变量
    //不随类实列对象的销毁而销毁而普通成员变量会随着类的对象销毁而销毁 如c变量
    //静态方法：属于类的方法不属于类的实列方法所以不需要创建对象就可直接访问
    private static String a="a";
    private static String b;

    String c="c";
    String d;

    //静态快
    static {
        printStatic("before static");
        b="string-b";
        printStatic("after static");
    }

    public static void printStatic(String title){
        System.out.println("title:----------"+title);
        System.out.println("a=\""+a+"\"");
        System.out.println("b=\""+b+"\"");
    }

    public ClassExample(){
        print("before constructor");
        d="string-d";
        print("after constructor");
    }

    public void print(String title){
        System.out.println("title:----------"+title);
        System.out.println("a=\""+a+"\"");
        System.out.println("b=\""+b+"\"");
        System.out.println("c=\""+c+"\"");
        System.out.println("d=\""+d+"\"");
    }

    {
        print("before c a print");
        c="string-c";
        a="string-new a";
        print("before c a print");
    }

}
