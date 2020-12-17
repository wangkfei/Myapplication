package com.example.myapplication.contract;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.UserBean;
import com.example.myapplication.utils.net.INetCallBack;

public interface MainContract {
    public interface MainModel{
        <T>void getLoginData(String url, INetCallBack<T> callBack);
    }
    public interface IMainPresenter{
        void login(String name,String password);
        void loginResult(String result);
    }
    public interface IMainView extends BaseView {
        String getUserName();
        String getPassword();
        void getData(UserBean string);
    }
}
