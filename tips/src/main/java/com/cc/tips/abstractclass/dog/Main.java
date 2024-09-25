package com.cc.tips.abstractclass.dog;

public class Main {

    public static void main(String[] args) {
        ConnectResetResponse connectResetResponse = new ConnectResetResponse();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorInfo(1, "1");
        System.out.println(connectResetResponse);
    }
}
