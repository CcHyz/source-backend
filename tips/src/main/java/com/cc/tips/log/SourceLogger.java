package com.cc.tips.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SourceLogger {

    public static final Logger CONTROL = LoggerFactory.getLogger("com.cc.tips.log.controller");
    public static final Logger Source = LoggerFactory.getLogger("com.cc.tips.log.SourceCC");

    public static void main(String[] args) {
        CONTROL.info("CONTROL 打的 log");
        Source.info("CONTROL 打的 log");
    }
}
