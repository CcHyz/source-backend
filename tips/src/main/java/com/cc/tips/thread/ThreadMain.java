package com.cc.tips.thread;

import lombok.SneakyThrows;

public class ThreadMain {


    public static void main(String[] args) {
        /*
         * @description: 注意都是操作的同一个对象
         */
        threadTest threadTest = new threadTest();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
        new Thread(threadTest).start();

    }

    public static class threadTest implements Runnable {

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
        int i = 5;
        String a= "a";
        @SneakyThrows
        public void run() {
            synchronized (this){
            while (true) {

                    if (i<=0){
                        break;
                    }
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "出售数量:" + i);
                    i-=1;
                }

            }
        }
    }

    private synchronized void a(){
        int i = 5;
        if (i>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "出售数量:" + i);
            i -= 1;
        }
    }
}
