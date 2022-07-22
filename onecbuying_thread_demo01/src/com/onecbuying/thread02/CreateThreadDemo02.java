package com.onecbuying.thread02;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName CreateThreadDemo02
 * @company 公司
 * @Description 使用实现runnable接口方式创建线程
 * @createTime 2022年07月22日 14:29:29
 */
public class CreateThreadDemo02 extends Thread{
    /**
     * run就是线程需要执行的任务或者执行的代码
     */
    @Override
    public void run() {
        for (int  i=0; i< 30; i++) {
            System.out.println("子线程,i"+i);
        }
    }
}
