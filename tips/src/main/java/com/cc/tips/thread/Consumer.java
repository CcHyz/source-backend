package com.cc.tips.thread;

import com.cc.tips.fzJcDt.Extends.Person;

public class Consumer implements Runnable{
    private Students students;

    public Consumer(Students students){
        this.students=students;
    }

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
        for (int i=1;i<10;i++){
            System.out.println("消费者！"+i+"->"+students.get());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
