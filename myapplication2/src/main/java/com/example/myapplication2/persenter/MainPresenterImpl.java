package com.example.myapplication2.persenter;

import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.contract.MainContract;
import com.example.myapplication2.model.MainModelImpl;
import com.example.myapplication2.model.UserBean;
import com.example.myapplication2.utils.INetCallBack;
import com.example.myapplication2.utils.InetWorkInterface;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {


    private MainContract.MainModel mainModel;
    //private MainContract.IMainView iMainView;

    public MainPresenterImpl(MainContract.IMainView mainView){
        this.mainModel = new MainModelImpl(this);
        //this.iMainView = mainView;
    }
    @Override
    public void login(String name, String password) {
        mainModel.getLoginData("",new INetCallBack<UserBean>());
    }

    @Override
    public void loginResult(String result) {

    }
}
