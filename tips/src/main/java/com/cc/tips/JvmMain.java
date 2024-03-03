package com.cc.tips;

public class JvmMain {
    public static void main(String[] args) {
        String str1="1";
        String str2="1";
        String str3=new String("1");
        String str4=new String("1");
        int a=1;
        int b=1;
        Integer integer=new Integer(1);
        Integer integer2=new Integer(1);

        /*
         * new 之后开辟的是新的堆内存空间
         * 而对于直接定义的栈引用str1和str2或者a,b值相同情况下
         * 只能保存一块堆内存的物理内存
         * 所以str1和str2都指向了同一块堆内存，所以地址也就相等
         * 等效于String str5=str1;一样的效果
         * 而str4和str5都是new后的在堆中新开辟了内存所以
         * 使用==就为false,但值相等所以equals为true
         * 对于System.out.println(a==integer2);返回true,为什么
         */

        System.out.println(str1==str2);//true
        System.out.println(str3==str4);//false
        System.out.println(str3==str1);//false

        System.out.println(str1.equalsIgnoreCase(str2));//true
        System.out.println(str3.equalsIgnoreCase(str4));//true
        System.out.println(str3.equalsIgnoreCase(str1));//true

        System.out.println(a==b);//true
        System.out.println(integer==integer2);//false
        System.out.println(a==integer2);//true
    }
}
