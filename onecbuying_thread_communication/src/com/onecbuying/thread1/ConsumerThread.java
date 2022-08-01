package com.onecbuying.thread1;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ConsumerThread
 * @company 公司
 * @Description 消费者线程,读的操作
 * @createTime 2022年07月30日 14:04:04
 */
public class ConsumerThread {
    public static void main(String[] args) {
        SharedResourceThread resource  = new SharedResourceThread();
        Out  out  = new Out(resource);
        Input input =  new Input(resource);
        out.start();
        input.start();
    }
}
