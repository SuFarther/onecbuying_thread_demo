package com.onecbuying;

import com.onecbuying.thread02.CreateThreadDemo02;
import com.onecbuying.thread03.CreateThreadDemo03;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadDemo01
 * @company 公司
 * @Description 如何创建多线程
 * @createTime 2022年07月21日 20:30:30
 */
public class ThreadDemo {

    /**
     * 什么是进程, 进程就是正在运行的应用程序,进程是线程的集合
     * 什么是线程， 线程就是一条执行路径,一个独立的执行单元
     * 什么是多线程 为了提高程序效率
     * 创建有哪些方式？
     * 1、使用继承Thread类方式,继承Thread类重写run方法
     * 2、使用实现runnable接口方式
     * 3、使用匿名内部类方式
     * 4、callable
     * 5、使用线程池创建线程
     *
     */
    public static void main(String[] args) {
        /**
         * 第一种实现方式 1、使用继承Thread类方式,继承Thread类重写run方法
         * 启动线程 不是调用run方法,而是调用start方法
         * 开启多线程后,代码不会从上往下执行
         */
//        CreateThreadDemo01 thread = new CreateThreadDemo01();
//        thread.start();
//        for(int i = 0; i <30;i++){
//            System.out.println("main,i"+i);
//        }


        /**
         *  使用实现runnable接口方式创建线程
         */
//        CreateThreadDemo02 t2 = new CreateThreadDemo02();
//        Thread thread = new Thread(t2);
//        thread.start();
//         for(int i = 0; i <30;i++){
//            System.out.println("主线程,i"+i);
//        }

        /**
         * 使用匿名内部类创建线程
         */
//        CreateThreadDemo03 t3 = new CreateThreadDemo03();
//        Thread thread = new Thread(t3);
//        thread.start();
//        for (int i = 0; i <10; i++) {
//            System.out.println("主线程,i"+i);
//        }
         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i <10; i++) {
                   System.out.println("子线程,i"+i);
                 }
             }
         });
        t1.start();
        for (int i = 0; i <10; i++) {
            System.out.println("主线程,i"+i);
        }
    }
}
