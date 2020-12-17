package com.example.myapplication3.utils;

public interface INetCallBack<T> {
    public void success(T t);

    public void onFail(String str);
}
