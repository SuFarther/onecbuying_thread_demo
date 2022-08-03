package com.onecbuying.thread5;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadLocalDemo01
 * @company 公司
 * @Description ThreadLocal本地局部变量,本地线程,为每一个线程提供一个局部变量
 *
 * ThreadLocal原理是什么？
 * Map集合+当前线程
 * set方法底层实现
 *
 * Map()
 * @createTime 2022年08月03日 16:22:22
 */
class ResNumber {
    /**
     * 生成序列号共享变量；
     */
    public static Integer count = 0;

    public static  ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return  0;
        };
    };

    public Integer getNumber(){
       int count = threadLocal.get() +1;
       threadLocal.set(count);
       return count;
    }
}

class LocalThreadDemo extends Thread {
    private  ResNumber resNumber;

    public LocalThreadDemo(ResNumber resNumber){
        this.resNumber = resNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i <3;i++){
            System.out.println(Thread.currentThread().getName()+",number:"+resNumber.getNumber());
        }
    }
}


public class ThreadLocalDemo01 {
    public static void main(String[] args) {
        ResNumber resNumber = new ResNumber();
        LocalThreadDemo t1 = new LocalThreadDemo(resNumber);
        LocalThreadDemo t2 = new LocalThreadDemo(resNumber);
        LocalThreadDemo t3 = new LocalThreadDemo(resNumber);
        t1.start();
        t2.start();
        t3.start();
    }
}
