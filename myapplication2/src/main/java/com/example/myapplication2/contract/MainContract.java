package com.example.myapplication2.contract;

import com.example.myapplication2.base.BaseView;
import com.example.myapplication2.model.UserBean;

public interface MainContract {
    public interface MainModel{
        void getLoginData(String url);
    }
    public interface IMainPresenter{
        void login(String name,String password);
        void loginResult(String result);
    }
    public interface IMainView extends BaseView {
        String getUserName();
        String getPassword();
        void getData(UserBean String);
    }
}
