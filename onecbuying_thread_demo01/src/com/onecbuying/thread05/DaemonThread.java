package com.onecbuying.thread05;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName DaemonThread
 * @company 公司
 * @Description
 *  用户线程 是主线程创建的线程。 非守护线程
 *  守护线程 和主线程一起销毁
 *  主线程死掉 gc线程(回收垃圾)不会继续回收,后面也会一起死掉
 * @createTime 2022年07月22日 22:54:54
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int  i = 0; i< 4; i++){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("子线程:i"+i);
                }
            }
        });
        t1.setDaemon(true); //  该线程为守护线程 和主线程一起销毁
        t1.start();
        for (int  i = 0; i< 5; i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("主线程:i"+i);
        }
        System.out.println("主线程执行完毕.......");
    }
}
