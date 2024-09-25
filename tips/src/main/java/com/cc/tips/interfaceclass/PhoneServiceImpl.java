package com.cc.tips.interfaceclass;

public  class PhoneServiceImpl implements DoService{
    @Override
    public String play() {
        return "手机phone play";
    }

    @Override
    public String play2() {
        return null;
    }
}
