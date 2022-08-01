package com.onecbuying.thread1;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName SharedResourceThread
 * @company 公司
 * @Description 共享资源
 * @createTime 2022年07月30日 14:10:10
 */
public class SharedResourceThread {
    public String userName;
    public String sex;

    /**
     * 线程通讯标识
     * true 生产者线程等待,消费者可以进行消费 false 生产者可以写, 消费者变为等待
     */
    public boolean flag =false;
}
