package com.example.myapplication3.contract;

import com.example.myapplication3.base.BaseView;
import com.example.myapplication3.model.UserBeam;
import com.example.myapplication3.utils.INetCallBack;

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
        void getData(UserBeam string);
    }
}
