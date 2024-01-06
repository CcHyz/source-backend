package com.cc.tips.fzJcDtCopy;

import com.cc.tips.fzJcDt.PublicClass;

/*
 * @description: 修饰符测试类
 * 修饰符： default public protected private
 * 测试fzJcDt包下的类,方法
 * @author Cc
 * @date 2023/12/30 16:39
 */
public class ModifierTestClass {


    public static void test() {

        //1、fzJcDt包下default修饰的类：DefaultClass无法被实列，找不到，
        //so:default修饰的只能被当前包下所调用
        //即：在fzJcDt包下ModifierTestClass可以访问
        //DefaultClass defaultClass =new DefaultClass();

//----------------------------------------------------------------------------------------------------------------//

        //2、fzJcDt包下PublicClass类可被实列
        PublicClass aClass = new PublicClass();
        //当PublicClass类属性不存在get，set时:
        //public修饰的属性可以直接通过对象.属性进行get,set.
        //如果存在则可获取其他属性的get，set
        aClass.b = "b";
        //protected修饰的方法只能在同包下访问，所以报错，
        //即：在fzJcDt包下ModifierTestClass可以访问
        //aClass.protectedMethod();

        // default修饰的方法只能在同包下访问，所以报错，
        //即：在fzJcDt包下ModifierTestClass可以访问
        //aClass.defaultMethod();

        //private修饰的方法只能在类下访问，所以报错
        //aClass.privateMethod();

        //而public修饰的方法可以调用
        aClass.publicMethod();
        System.out.println(aClass.b);//输出b
        System.out.println();//换行

    }

    public static void main(String[] args) {
        test();
    }


}
