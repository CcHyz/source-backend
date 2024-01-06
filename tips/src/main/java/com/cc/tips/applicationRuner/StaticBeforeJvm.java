package com.cc.tips.applicationRuner;

public class StaticBeforeJvm {
    private String a;

    {
        a="66666";
        System.out.println(a);
    }

    static {
        System.out.println("StaticBeforeJvm 加载！");
    }
}
