package com.cc.tips.executor;

import java.util.Random;

public class AppleService {

    public Apple newApple(){
        int maxAttempts = 5; // 最大尝试次数
        int attempt = 0;

        Apple appleService = null;
//        while (true) {
//            try {
                Random random = new Random();
                appleService = new Apple(String.valueOf(random.nextInt()), null);
//                break;
//            } catch (Exception e) {
//                attempt++;
//                System.out.println("重试次数"+attempt);
//                if (attempt >= maxAttempts) {
//                    throw new RuntimeException("Failed after " + maxAttempts + " attempts", e);
//                }
//            throw e;
//            }
//        }
        return appleService;
    }
}
