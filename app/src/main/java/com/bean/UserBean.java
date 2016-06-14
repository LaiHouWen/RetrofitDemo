package com.bean;

/**
 * Created by Administrator on 2016/6/2.
 */
public class UserBean {

    private String mFirstName;
    private String mLastName;

    public UserBean(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }
}
