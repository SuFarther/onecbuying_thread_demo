package com.onecbuying;

import com.onecbuying.pojo.UserPojo;
import com.onecbuying.thread.UserSendThead;
import com.onecbuying.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName BacthSms
 * @company 公司
 * @Description 定义一个人发10万的短信
 *
 * 小项目可以这样实现，大项目不行,使用消息中间件,保证数据一致性
 * @createTime 2022年07月21日 19:25:25
 */
public class BacthSms  {
    public static void main(String[] args) {
        /**
         * 1、初始化数据
         * 2、定义每个线程分批发送大小
         * 3、计算每个线程需要分批跑的数据
         * 4、分配发送
         */
        List<UserPojo> initUser = initUser();
        int userCount = 2;
        List<List<UserPojo>> splitList = ListUtils.splitList(initUser, userCount);
       for (int i= 0; i< splitList.size();i++) {
           List<UserPojo> list = splitList.get(i);
           UserSendThead userSendThead = new UserSendThead(list);
           Thread thread = new Thread(userSendThead,"线程"+i);
           thread.start();
       }

    }

    public static List<UserPojo> initUser(){
        List<UserPojo> list = new ArrayList<UserPojo>();
        for(int i=1;i<=11;i++){
            list.add(new UserPojo("userId"+i,"userName"+i));
        }
        return list;
    }
}
