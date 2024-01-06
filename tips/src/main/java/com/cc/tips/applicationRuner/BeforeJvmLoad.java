package com.cc.tips.applicationRuner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
* @description: 启动前加载类
* @author Cc
* @date 2023/12/17 15:53
*/
@Component
//@Order(1)
public class BeforeJvmLoad implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("BeforeJvmLoad 加载！");

    }
}
