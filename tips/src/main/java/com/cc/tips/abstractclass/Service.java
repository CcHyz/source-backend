package com.cc.tips.abstractclass;

import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Date;

import static com.cc.tips.abstractclass.formatUtils.sdf;

public class Service {

    @SneakyThrows
    public void dos(Date date){
//        Date format1 = sdf.parse(date);
        String format2 = sdf.format(date);
        System.out.println(format2);

    }
}
