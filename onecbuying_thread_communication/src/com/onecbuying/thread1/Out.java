package com.onecbuying.thread1;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Out
 * @company 公司
 * @Description 生产者线程,写操作,发布资源
 * @createTime 2022年07月30日 14:14:14
 */
public class Out extends Thread{
    private SharedResourceThread resource;

    public Out(SharedResourceThread resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                System.out.println(resource.userName+","+resource.sex);
            }
        }
    }

}
