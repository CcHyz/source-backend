package com.cc.tips.abstractclass;

public class ComputerServiceImpl extends DoService{

    @Override
    public String play() {
        return "Computer play";
    }

    @Override
    public String go() {
        String a="Computer go";
        a=super.go();
        return a;
    }
}
