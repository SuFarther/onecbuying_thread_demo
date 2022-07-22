package com.onecbuying.thread04;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadDemo04
 * @company 公司
 * @Description 使用常用的线程api
 * getId() 线程id
 * @createTime 2022年07月22日 15:31:31
 */

class CreateThreadDemo05 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i <5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("线程id:"+getId()+":子线程:"+i+",name:"+getName());
            System.out.println("线程id:"+Thread.currentThread().getId()+":子线程:"+i+",name:"+Thread.currentThread().getName());
//            if(i == 4) {
//                stop(); //不安全。不建议使用
//            }
        }
    }
}

class CreateThreadDemo06 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i <5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程id:"+Thread.currentThread().getId()+":子线程:"+i+",name:"+Thread.currentThread().getName());
            if(i == 4) {
                Thread.currentThread().stop(); //不安全。不建议使用
            }
        }
    }
}

public class ThreadDemo04 {
    public static void main(String[] args) {
        // 获取主线程的id
        //任何一个程序肯定有一个主线程
//        System.out.println("主线程:"+Thread.currentThread().getId()+",name:"+Thread.currentThread().getName());
//        CreateThreadDemo05 t1 = new CreateThreadDemo05();
//        t1.start();
//        for (int i= 0; i< 3; i ++ ) {
//            CreateThreadDemo05 t1 = new CreateThreadDemo05();
//            t1.start();
//        }
        //  Thread.currentThread() 获取当前线程
        CreateThreadDemo06 createThreadDemo06 = new CreateThreadDemo06();
        Thread thread = new Thread(createThreadDemo06, "子线程");
        thread.start();
    }
}
