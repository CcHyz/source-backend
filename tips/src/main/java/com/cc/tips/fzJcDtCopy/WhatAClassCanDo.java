package com.cc.tips.fzJcDtCopy;
/*
* @description: 一个类可以干什么
* @author Cc
* @date 2023/12/30 16:55
*/

import com.cc.tips.fzJcDt.PublicClass;

public class WhatAClassCanDo {
    //一个类可以定义属性，方法，内部类
    //属性：用来描述这个类能干啥 private String a;
    //方法：用来描述类的行为 private void a(){do someting};
    //内部类：可以定义外部的任何形式的类


    //只有在类的方法中才能使用get,set,调用别的方法，等一系列操作。
    //把方法中的操作直接在类上无法操作任何
    //如下publicClass直接在类中实例化只能当成为一个属性而无法在去获取publicClass类的属性和方法.
    // 但如果在test方法中去定义publicClass则可获取类的属性和方法.
     PublicClass publicClass=new PublicClass();

    public void test(){
         PublicClass publicClass=new PublicClass();
    }
}
