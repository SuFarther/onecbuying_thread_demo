package com.onecbuying;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThreadVolatile
 * @company 公司
 * @Description
 *  public boolean flag = true;
 *  原先flag为true，存放在主内存中，存放的共享数据为flag = true
 *  因为主内存中有flag=true
 *  ThreadVolatileDemo开辟了一个线程,假设第一次为t1,在他本地私有内存中当走while(flag) {}那flag=true;然后t1把本地私有flag =  true刷新到
 *  主内存中，所以主内存中为true,后面threadVolatileDemo.setFlag(false);主线程修改值把值设置为false,主内存通知给t2
 *  两个线程之间操作是不可见的啊，加volatile让线程之间可见
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
