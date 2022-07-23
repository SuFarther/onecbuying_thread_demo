package com.onecbuying.thread06;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName JoinThread
 * @company 公司
 * @Description join方法的使用
 * Join正在A线程，另一个线程B,A线程调用B的这个join方法，作用:  A等待B线程执行完毕之后(释放我的CPU执行权),在继续执行
 * 优先级
 * @createTime 2022年07月24日 00:21:21
 */
public class JoinThread {
    public static void main(String[] args) {
        Thread t = new  Thread(new Runnable() {
            @Override
            public void run() {
               for (int i = 0; i < 10; i++) {
                   System.out.println("子线程,i:"+i);
               }
            }
        });
        t.start();
        //让子线程优先执行
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程,i:"+i);
        }
    }
}
