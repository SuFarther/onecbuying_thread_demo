package com.onecbuying.thread06;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JoinThreadDemo2
 * @company 公司
 * @Description 面试题
 * 现在有  T1、T2、T3三个线程,你怎样保T2在T1执行完后执行,T3在执行完毕后执行
 * @createTime 2022年07月24日 00:28:28
 */
public class JoinThreadDemo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是T1线程,i:"+i);
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是T2线程,i:"+i);
                }
            }
        });
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是T3线程,i:"+i);
                }
            }
        });
        t3.start();
    }
}
