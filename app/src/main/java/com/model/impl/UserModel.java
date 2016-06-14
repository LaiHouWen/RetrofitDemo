package com.model.impl;

import com.bean.UserBean;
import com.model.IUserModel;

/**
 *
 * Created by Administrator on 2016/6/2.
 */
public class UserModel implements IUserModel {


    @Override
    public void setID(int id) {

    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {
        // 存储lastName
    }

    @Override
    public int getID() {
        // 获取id
        return 0;
    }

    @Override
    public UserBean load(int id) {
        // 查数据库或者联网获取id的userbean
        return new UserBean("11", "22");
    }
}
