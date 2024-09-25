package com.cc.tips.thread.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {
        ThreadLocalWarp threadLocalWarp=new ThreadLocalWarp();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(()->{

            threadLocalWarp.set(new User("a"));

            System.out.println("submit:"+threadLocalWarp.get()+"threadid"+Thread.currentThread().getId());
        });
        threadLocalWarp.set(new User("b"));
        System.out.println("------"+threadLocalWarp.get().getClass().getName()+"threadid"+Thread.currentThread().getId());

        Runnable runnable = new Runnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                System.out.println("run:"+threadLocalWarp.get().getClass().getName()+"threadid"+Thread.currentThread().getId());
            }
        };
        runnable.run();
    }
}
