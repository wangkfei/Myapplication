package com.example.myapplication.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T> extends AppCompatActivity {

    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter ==null){
            presenter = getPresenter();
        }
        setContentView(getLayoutID());

        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();

    protected abstract T getPresenter();
}
