package com.example.myapplication.model;

import com.example.myapplication.contract.MainContract;
import com.example.myapplication.utils.net.INetCallBack;
import com.example.myapplication.utils.net.RetrofitUtils;

public class MainModelImpl implements MainContract.MainModel {

    private MainContract.IMainPresenter presenter;

    public MainModelImpl(MainContract.IMainPresenter presenter){
       this.presenter = presenter;
    }



    @Override
    public <T> void getLoginData(String url ,INetCallBack<T> callBack) {

//        这里有一千行代码。
//        结果返回了
//        网络请求
//        这一行只是昨天测试MVP用的,现在用接口回调了,用不上了,但是还是留着理解MVP把
        presenter.loginResult("登录成功了");
//        当前代码先放着,因为还需要改动
        RetrofitUtils.getInstance().get(url,callBack);

    }
}
