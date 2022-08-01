package com.onecbuying.thread1;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Input
 * @company 公司
 * @Description 消费者线程,读的操作
 * @createTime 2022年07月31日 07:41:41
 */
public class Input extends Thread{
    private SharedResourceThread resource;

    public Input(SharedResourceThread resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        // 写操作 0：偶数 1： 奇数
        int count = 0;
        while(true) {
            synchronized(resource){
                if(resource.flag){
                    try {
                        // 当前线程变为等待，但是可以释放锁
                        resource.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(count  ==  0){
                    resource.userName = "小红";
                    resource.sex = "女";
                }else {
                    resource.userName = "小黑";
                    resource.sex = "男";
                }
                count = (count + 1) % 2;
                resource.flag = true;
                // 唤醒当前线程
                resource.notify();
            }
        }
    }
}
