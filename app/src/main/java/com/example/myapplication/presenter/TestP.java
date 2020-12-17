package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.MainContract;

public class TestP extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter
{

    @Override
    public void login(String name, String password) {

    }

    @Override
    public void loginResult(String result) {

    }
}
