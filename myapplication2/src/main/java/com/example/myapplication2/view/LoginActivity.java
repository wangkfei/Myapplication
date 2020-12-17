package com.example.myapplication2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication2.R;
import com.example.myapplication2.base.BaseActivity;
import com.example.myapplication2.contract.MainContract;
import com.example.myapplication2.model.MainModelImpl;
import com.example.myapplication2.model.UserBean;
import com.example.myapplication2.persenter.MainPresenterImpl;

public class LoginActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {

    private EditText editTextPersonName;
    private EditText editTextTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    protected MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
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
    public void getData(UserBean String) {

    }
}