package com.example.myapplication.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.model.UserBean;
import com.example.myapplication.presenter.MainPresenterImpl;

public class LoginActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView{

    private EditText editTextPersonName;
    private EditText editTextTextPassword;




    @Override
    protected void initView() {
        editTextPersonName=findViewById(R.id.editTextPersonName);
        editTextTextPassword =findViewById(R.id.editTextTextPassword);

        editTextPersonName.setOnClickListener(asdafesfed);
    }

    public View.OnClickListener asdafesfed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected void initData() {
        presenter.login(getUserName(),getPassword());
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }
    /*
*登录按钮
*
*
* */

    public void loginButton(View view) {
        if (!TextUtils.isEmpty(getUserName()) && !TextUtils.isEmpty(getPassword())){
            presenter.login(getUserName(),getPassword());
        }
    }

    @Override
    public String getUserName() {
        return editTextPersonName.getText().toString();
    }

    @Override
    public String getPassword() {
        return editTextTextPassword.getText().toString();
    }

    @Override
    public void getData(UserBean string) {

        //网络请求返回

    }





}