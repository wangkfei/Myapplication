package com.example.myapplication.persenter;

import com.example.myapplication.contract.MainContract;
import com.example.myapplication.model.MainModelImpl;
import com.example.myapplication.model.UserBean;
import com.example.myapplication.util.net.INetCallBack;

public class MainPersenterImpl implements MainContract.MainPersenterImpl {

    private  MainContract .MainModel mainModel;
    private  MainContract.IMainView iMainView;

    public MainPersenterImpl(MainContract.IMainView mainView){
        this.mainModel = new MainModelImpl(this);
        this.iMainView = mainView;
    }
    @Override
    public void login(String name, String password) {

    }

    @Override
    public void loginResult(String result) {

    }
}
