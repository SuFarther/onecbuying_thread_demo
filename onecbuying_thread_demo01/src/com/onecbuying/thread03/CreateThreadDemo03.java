package com.onecbuying.thread03;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName CreateThreadDemo03
 * @company 公司
 * @Description 使用匿名内部类方式创建线程
 * @createTime 2022年07月22日 14:29:29
 */
public class CreateThreadDemo03 implements Runnable {


    @Override
    public void run() {
        for(int i = 0; i < 10; i++ ){
            System.out.println("子线程,i"+i);
        }
    }
}
