package com.presenter;

import com.bean.UserBean;
import com.model.IUserModel;
import com.model.impl.UserModel;
import com.view.IUserView;

/**
 * Presenter就能通过接口与View及Model进行交互
 * Created by Administrator on 2016/6/2.
 */
public class UserPresenter {

    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser(int id, String firstName, String lastName) {
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id) {
        UserBean user = mUserModel.load(id);
        mUserView.setFirstName(user.getmFirstName());// 通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.getmLastName());
    }

}
