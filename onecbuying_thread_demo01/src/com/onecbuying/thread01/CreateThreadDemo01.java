package com.onecbuying.thread01;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName CreateThreadDemo01
 * @company 公司
 * @Description 使用继承Thread类方式,继承Thread类重写run方法
 * @createTime 2022年07月22日 14:29:29
 */
public class CreateThreadDemo01 extends Thread{
    /**
     * run就是线程需要执行的任务或者执行的代码
     */
    @Override
    public void run() {
        for (int  i=0; i< 30; i++) {
            System.out.println("run,i"+i);
        }
    }
}
