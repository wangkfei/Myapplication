package com.example.myapplication.contract;

import com.example.myapplication.model.UserBean;
import com.example.myapplication.util.net.INetCallBack;

public class MainContract {
    public interface MainModel{
        <T> void getLoginData(String url, INetCallBack(T) callback);
    }
    public interface MainPersenterImpl{
        void login(String name, String password);
        void loginResult(String result);
    }

    public interface IMainView{
        String getUserName();
        String getPassword();
        void getData(UserBean String);
    }

}
