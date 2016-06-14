package com.view;

/**
 * 根据需求可知，View可以对ID、FirstName、LastName这三个EditText进行读操作，
 * 对FirstName和LastName进行写操作
 * Created by Administrator on 2016/6/2.
 */
public interface IUserView {

    int getID();

    String getFristName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);
}
