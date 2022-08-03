package com.onecbuying.thread4;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StopThread
 * @company 公司
 * @Description 让线程停止
 * @createTime 2022年08月03日 15:58:58
 */

class StopThreadDemo extends Thread {
    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行...");
        while(flag){

        }
        System.out.println("子线程结束执行...");
    }

    public void stopThread() {
        System.out.println("调用stopThread方法。。。");
        this.flag = false;
        System.out.println("已经将flag修改为"+flag);
    }
}


public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        StopThreadDemo stopThreadDemo = new StopThreadDemo();
        stopThreadDemo.start();

        for (int i = 1; i < 10; i++) {
            System.out.println("我是主线程,i:"+i);
            Thread.sleep(1000);
            if(i == 6) {
                stopThreadDemo.stopThread();
            }
        }
    }
}
