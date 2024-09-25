package com.cc.tips.finalTest;


public class Main {
    private final int i = 1;

    private final FinalC finalC;

    public Main(FinalC finalC) {
        this.finalC = finalC;
    }

    public static void main(String[] args) {
        FinalC c = new FinalC();
        c.setC("你好！");
        Main main = new Main(c);
        main.aVoid();
    }

    private void aVoid() {
        String message = finalC.returns();
        System.out.println("aVoid" + "--" + message);
    }
}
