package com.onecbuying.thread2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName OutInputThread
 * @company 公司
 * @Description 手动加锁lock锁
 * @createTime 2022年08月01日 14:24:24
 */

class  Res {
    public  String userName;
    public  String sex;
    public boolean flag = false;
    /**
     * 可重入锁
     */
    Lock lock = new ReentrantLock();
}

class  Input extends Thread {
    Res res;
    public  Input(Res res){
        this.res = res;
    }
    @Override
    public void run() {
        int count = 0;
        while(true) {
            // 开始上锁
            res.lock.lock();
            try{
                if(count == 0){
                    res.userName = "小红";
                    res.sex = "女";
                }else{
                    res.userName = "小黑";
                    res.sex = "男";
                }
                count = (count + 1) % 2;
                res.flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }
        }
    }
}

class Out extends Thread {
    Res res;
    public Out(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.lock.lock();
            try {
                System.out.println(res.userName+","+res.sex);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }
        }
    }
}

public class OutInputThread {
    public static void main(String[] args) {
        Res  res = new Res();
        Out out = new Out(res);
        Input input = new Input(res);
        out.start();
        input.start();
    }
}
