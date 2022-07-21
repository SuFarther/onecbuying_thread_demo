package com.onecbuying.thread;

import com.onecbuying.pojo.UserPojo;


import java.util.List;

/**
 * @author 苏东坡1
 * @version 1.0
 * @ClassName UserSendThead
 * @company 公司
 * @Description 用户发送信息线程类
 * @createTime 2022年07月21日 20:12:12
 */
public class UserSendThead implements Runnable {
    private List<UserPojo> listUser;

    public UserSendThead(List<UserPojo> listUser){
        this.listUser = listUser;
    }

    @Override
    public void run() {
        for(UserPojo userPojo: listUser) {
            System.out.println(Thread.currentThread().getName() + "," + userPojo.toString());
        }
        System.out.println();
    }
}
