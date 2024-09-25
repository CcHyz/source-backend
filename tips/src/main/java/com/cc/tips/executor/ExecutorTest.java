package com.cc.tips.executor;


import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {


    public static void main(String[] args) {
         ExecutorService executor= Executors.newScheduledThreadPool(2);
        executor.submit(() -> {
            int maxAttempts = 5; // 最大尝试次数
            int attempt = 0;
            try {
            while (true){

                AppleService appleService = new AppleService();
                Apple apple = appleService.newApple();
                System.out.println(apple);
                break;
            }}catch (Exception e){
                attempt++;
                System.out.println("重试次数"+attempt);
                if (attempt >= maxAttempts) {
                    throw new RuntimeException("Failed after " + maxAttempts + " attempts", e);
                }
            }
        });

    }
}
