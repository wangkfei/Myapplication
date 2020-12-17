package com.example.myapplication.model;

import com.example.myapplication.contract.MainContract;

public class MainModelImpl implements MainContract.MainModel {

    private MainContract.MainPersenterImpl presenter;

    public MainModelImpl(MainContract.MainPersenterImpl presenter){
        this.presenter = presenter;
    }

    @Override
    public <T> void getLoginData(String url) {

        presenter.loginResult("登录成功了");
    }
}
