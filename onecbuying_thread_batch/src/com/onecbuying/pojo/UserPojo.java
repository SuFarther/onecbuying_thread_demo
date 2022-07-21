package com.onecbuying.pojo;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserPojo
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月21日 19:09:09
 */
public class UserPojo implements Serializable {
    private  String userId;
    private  String userName;

    public UserPojo() {

    }

    public UserPojo(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
