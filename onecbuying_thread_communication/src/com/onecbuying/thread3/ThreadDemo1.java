package com.onecbuying.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ThrradDemo1
 * @company 公司
 * @Description TODO
 * @createTime 2022年08月02日 16:43:43
 */
class   Res{
    public String userName;
    public String sex;
    public boolean flag=false;
    Lock lock = new ReentrantLock();
}

class  InputThread extends Thread {
    Res res;
    Condition newCondition;
    public InputThread(Res res,Condition newCondition){
        this.res =  res;
        this.newCondition = newCondition;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            res.lock.lock();
           try{
               if(res.flag){
                   try{
                       newCondition.await();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               if(count == 0){
                   res.userName = "小红";
                   res.sex = "女";
               }else{
                   res.userName = "小黑";
                   res.sex = "男";
               }
               count = (count + 1) % 2;
               res.flag = true;
               newCondition.signal();
           }catch (Exception e) {
               e.printStackTrace();
           }finally {
               res.lock.unlock();
           }
        }

    }
}

class OutThread  extends Thread {
    Res res;
    Condition newCondition;

    public OutThread(Res res, Condition newCondition) {
        this.res =  res;
        this.newCondition = newCondition;
    }

    @Override
    public void run() {
        while (true) {
            res.lock.lock();
            try{
                if (!res.flag){
                    try{
                        newCondition.await();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
                newCondition.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                res.lock.unlock();
            }
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Res res = new Res();
        Condition newCondition = res.lock.newCondition();
        InputThread inputThread = new InputThread(res,newCondition);
        OutThread outThrad = new OutThread(res,newCondition);
        inputThread.start();
        outThrad.start();
    }
}
