package com.cc.tips.applicationRuner;

import org.springframework.stereotype.Component;

@Component
public class StaticBeforeJvm {


    static {
        System.out.println("StaticBeforeJvm 加载！");
    }

    private final String a;

    {
        a = "66666";
        System.out.println(a);
    }

    public void sayHello() {
        System.out.println(a);
    }

}
