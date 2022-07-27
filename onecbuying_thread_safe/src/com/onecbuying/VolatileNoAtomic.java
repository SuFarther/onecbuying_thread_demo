package com.onecbuying;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName VolatileNoAtomic
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月28日 05:17:17
 */
public class VolatileNoAtomic extends Thread {
    /**
     * 需要10个线程
     * static修饰关键字,存放在静态区,只会存放一次，所有线程都共享
     * jddk1.5中都并发包 AtomicInteger
     * AtomicInteger解决同步问题,线程的原子性
     * AtomicInteger计算属性来的
     */
//    private static int  count = 0;

    private static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            count++;
            count.incrementAndGet();
        }
//        System.out.println(getName()+","+count);
        System.out.println(getName() + "," + count.get());
    }

    public static void main(String[] args) {
        //创建10个线程
        VolatileNoAtomic[] volatileNoAtomicList = new VolatileNoAtomic[10];
        for (int i = 0; i < volatileNoAtomicList.length; i++) {
            volatileNoAtomicList[i] = new VolatileNoAtomic();
        }

        for (int i = 0; i < volatileNoAtomicList.length; i++) {
            volatileNoAtomicList[i].start();
        }
    }
}
