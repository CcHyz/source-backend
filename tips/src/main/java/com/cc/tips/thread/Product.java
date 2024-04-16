package com.cc.tips.thread;

public class Product implements Runnable{
    private Students students;

    public Product(Students yeyasua){
        this.students=yeyasua;
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
//    @Override
//    public void run() {
//        for (int i=1;i<=10;i++){
//            if (i%2==0){
//
//                students.setName("李");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                students.setAge(10);
//                System.out.println("if 生成者！"+i+"->"+"李"+10);
//            }else {
//                students.setName("张");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                students.setAge(5);
//                System.out.println("else 生成者！"+i+"->"+"张"+5);
//            }
//        }
//    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            if (i%2==0){

                students.set("李",10);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("if 生成者！"+i+"->"+"李"+10);
            }else {
                students.set("张",5);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("else 生成者！"+i+"->"+"张"+5);
            }
        }
    }
}
