package com.example.myapplication3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication3.R;
import com.example.myapplication3.base.BaseActivity;
import com.example.myapplication3.contract.MainContract;
import com.example.myapplication3.model.UserBeam;
import com.example.myapplication3.persenter.MainPresenterImpl;

public class LoginActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {
    private EditText editTextPersonName;
    private EditText editTextTextPassword;


    @Override
    public String getUserName() {
        return editTextPersonName.getText().toString();
    }

    @Override
    public String getPassword() {
        return editTextTextPassword.getText().toString();
    }

    @Override
    public void getData(UserBeam string) {

    }

    @Override
    protected void initData() {
        presenter.login(getUserName(),getPassword());
    }

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
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }
}