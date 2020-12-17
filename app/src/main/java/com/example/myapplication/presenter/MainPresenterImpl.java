package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.model.MainModelImpl;
import com.example.myapplication.model.UserBean;
import com.example.myapplication.utils.net.INetCallBack;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView>implements MainContract.IMainPresenter{

    private MainContract.MainModel mainModel;
    //private MainContract.IMainView iMainView;

    public MainPresenterImpl(MainContract.IMainView mainView){
        this.mainModel =new MainModelImpl(this);
        //this.iMainView = mainView;
    }

    @Override
    public void login(String name,String password) {
        mainModel.getLoginData("", new INetCallBack<UserBean>() {
            @Override
            public void success(UserBean userBean) {

                iView.getData(userBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }

    @Override
    public void loginResult(String result) {

    }
}
