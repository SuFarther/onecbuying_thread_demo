package com.onecbuying;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadDemo3
 * @company 公司
 * @Description 静态同步函数(静态同步方法)加的锁是当前类的字节码文件
 * @createTime 2022年07月24日 20:27:27
 */
class ThreadTrain3 implements Runnable {
    /**
     * 总共有一百张火车票
     */
    private static int trainCount3 = 100;
    public boolean flag = true;

    @Override
    public void run() {
        //为了能够模拟程序一直在抢票的话。
        if (flag) {
            // 执行同步代码块this锁
            while (trainCount3 > 0) {
                synchronized (ThreadTrain3.class) {
                    if (trainCount3 > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - trainCount3 + 1) + "票");
                        trainCount3--;
                    }
                }
            }
        } else {
            // 同步函数
            while (trainCount3 > 0) {
                //出售火车票
                sale();
            }
        }
    }

    private static  synchronized void sale() { //只能有一个线程进行访问，必须拿到锁到时候才能访问
        //同步代码块 synchronized 包裹需要线程安全的问题 两个线程同时访问
        if (trainCount3 > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - trainCount3 + 1) + "票");
            trainCount3--;
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadTrain3 threadTrain3 =  new ThreadTrain3();
        Thread t1 = new Thread(threadTrain3,"窗口1");
        Thread t2 = new Thread(threadTrain3,"窗口2");
        t1.start();
        Thread.sleep(40);
        threadTrain3.flag = false;
        t2.start();
    }
}
