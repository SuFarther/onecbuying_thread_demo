package com.onecbuying;



/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadDemo
 * @company 公司
 * @Description 模拟100人同时抢票
 * @createTime 2022年07月24日 20:27:27
 */
class ThreadTrain1 implements Runnable {
    /**
     *  总共有一百张火车票
     */
     private int  trainCount1 = 100;
     private Object object = new Object();

    @Override
    public void run() {
     //为了能够模拟程序一直在抢票的话。
        while(trainCount1 > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //出售火车票
            sale();
        }
    }

    private void sale() {
        //同步代码块 synchronized 包裹需要线程安全的问题 两个线程同时访问
       synchronized(object){ //只能有一个线程进行访问，必须拿到锁到时候才能访问
           if(trainCount1 > 0) {
               System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount1+1)+"票");
               trainCount1--;
           }
       }
    }
}



public class ThreadDemo {
    public static void main(String[] args) {
        ThreadTrain1 threadTrain1 =  new ThreadTrain1();
        Thread t1 = new Thread(threadTrain1,"窗口1");
        Thread t2 = new Thread(threadTrain1,"窗口2");
        t1.start();
        t2.start();
    }
}
