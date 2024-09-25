package com.cc.tips.interfaceclass;

public abstract class AbstractDo implements DoService{
    @Override
    public String play() {
        return "抽象 play";
    }
}
