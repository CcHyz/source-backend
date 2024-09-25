package com.cc.tips.interfaceclass;

public class ComputerServiceImpl implements DoService{
    @Override
    public String play() {
        return "电脑computer play";
    }

    @Override
    public String play2() {
        return null;
    }
}
