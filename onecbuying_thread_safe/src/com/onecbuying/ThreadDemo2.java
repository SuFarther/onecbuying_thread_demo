package com.onecbuying;



/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadDemo
 * @company 公司
 * @Description 同步方法,在方法上加synchronized
 * @createTime 2022年07月24日 20:27:27
 */
class ThreadTrain2 implements Runnable {
    /**
     *  总共有一百张火车票
     */
     private int  trainCount2 = 100;
//     private Object object = new Object();
     public boolean flag = true;

    @Override
    public void run() {
     //为了能够模拟程序一直在抢票的话。
        if(flag) {
            // 执行同步代码块this锁
            while (trainCount2  > 0){
                synchronized(this) {
                    if(trainCount2 > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount2+1)+"票");
                        trainCount2--;
                    }
                }
            }
        }else{
            // 同步函数
            while(trainCount2 > 0){
                //出售火车票
                sale();
            }
        }
    }

    private synchronized void sale() { //只能有一个线程进行访问，必须拿到锁到时候才能访问
        //同步代码块 synchronized 包裹需要线程安全的问题 两个线程同时访问
        if(trainCount2 > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount2+1)+"票");
            trainCount2--;
        }
    }
}



public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadTrain2 threadTrain2 =  new ThreadTrain2();
        Thread t1 = new Thread(threadTrain2,"窗口1");
        Thread t2 = new Thread(threadTrain2,"窗口2");
        t1.start();
        Thread.sleep(40);
        threadTrain2.flag = false;
        t2.start();
    }
}
