package com.onecbuying.thread4;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StopThreadDemo2
 * @company 公司
 * @Description 让等待的线程停止,直接抛出异常
 * @createTime 2022年08月03日 15:58:58
 */

class StopThreadDemo2 extends Thread {
    private volatile boolean flag = true;

    @Override
    public synchronized void run() {
        System.out.println("子线程开始执行...");
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                stopThread2();
            }
        }
        System.out.println("子线程结束执行...");
    }

    public void stopThread2() {
        System.out.println("调用stopThread方法。。。");
        this.flag = false;
        System.out.println("已经将flag修改为"+flag);
    }
}


public class StopThread2 {
    public static void main(String[] args) throws InterruptedException {
        StopThreadDemo2 stopThreadDemo2 = new StopThreadDemo2();
        stopThreadDemo2.start();

        for (int i = 1; i < 10; i++) {
            System.out.println("我是主线程,i:"+i);
            Thread.sleep(1000);
            if(i == 3) {
                //当前等待的线程,直接抛出异常
              stopThreadDemo2.interrupt();
            }
        }
    }
}
