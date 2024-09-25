package com.cc.tips.finalTest;

public class FinalC {
    private final int a = 1;

    private final String b = "b";

    private String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String returns() {
        return a + c;
    }
}
