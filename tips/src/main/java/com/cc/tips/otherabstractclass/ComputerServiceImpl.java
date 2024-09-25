package com.cc.tips.otherabstractclass;

import com.cc.tips.abstractclass.DoService;

public abstract class ComputerServiceImpl extends DoService {

    @Override
    public String play() {
        return "Computer play";
    }

    @Override
    public String play2() {
        return null;
    }


}
