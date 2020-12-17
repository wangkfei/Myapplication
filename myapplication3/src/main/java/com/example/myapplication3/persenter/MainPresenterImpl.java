package com.example.myapplication3.persenter;

import com.example.myapplication3.base.BasePresenter;
import com.example.myapplication3.contract.MainContract;
import com.example.myapplication3.model.MainModelImpl;
import com.example.myapplication3.model.UserBeam;
import com.example.myapplication3.utils.INetCallBack;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {

    private MainContract.MainModel mainModel;

    public MainPresenterImpl(MainContract.IMainView mainView){
        this.mainModel = new MainModelImpl(this);
    }

    @Override
    public void login(String name, String password) {
        mainModel.getLoginData("", new INetCallBack<UserBeam>() {
            @Override
            public void success(UserBeam userBeam) {
                iView.getData(userBeam);
            }

            @Override
            public void onFail(String str) {

            }
        });
    }

    @Override
    public void loginResult(String result) {

    }
}
