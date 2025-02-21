package com.cc.tips.controller;

import com.cc.tips.applicationRuner.StaticBeforeJvm;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticController {

    static {
        StaticBeforeJvm staticBeforeJvm = new StaticBeforeJvm();
        staticBeforeJvm.sayHello();
    }

    private final StaticBeforeJvm staticBeforeJvm;

    public StaticController(StaticBeforeJvm staticBeforeJvm) {
        this.staticBeforeJvm = staticBeforeJvm;
    }

}
