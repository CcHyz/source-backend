package com.cc.tips.applicationRuner;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*
* @description: @PostConstruct
* @author Cc
* @date 2023/12/17 16:05
*/
@Component
public class StartForPostConstruct {

    @PostConstruct
    public void init(){
        System.out.println("StartForPostConstruct 加载！");
    }
}
