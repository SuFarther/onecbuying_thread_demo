package com.onecbuying;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadVolatile
 * @company 公司
 * @Description
 *Volatile作用是保证两个线程之间的可见性,主内存中存放着共享数据public volatile boolean flag = true;当ThreadVolatileDemo这个线程子线程开始执行时,其实他原先本地内存就有一个本地私有内存 flag = true,当线程运行run方法后,执行while(flag) {}，flag = true把自己当本地私有内存的flag = true及时刷新到主内存中去,主内存得到值flag=tr
 *ue,通知给主线程中的本地私有内存，ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();主内存原先本地私有内存为flag= true;当他执行threadVolatileDemo.setFlag(false);主线程的本地私有内存为flag=false;
 *子线程为true,主线程为false,主内存为true,我想让子线程访问主线程中的值，本来线程之间是不可见的，用Volatile让他可见v
 * @createTime 2022年07月27日 14:08:08
 */
class ThreadVolatileDemo extends  Thread {
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行...");
        while(flag) {}
        System.out.println("子线程执行结束...");
    }

    public  void setFlag(boolean flag) {
        this.flag  = flag;
    }
}



public class ThreadVolatile {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(3000);
        threadVolatileDemo.setFlag(false);
        System.out.println("flag 已经修改成false！");
        Thread.sleep(1000);
        System.out.println(threadVolatileDemo.flag);
    }
}
