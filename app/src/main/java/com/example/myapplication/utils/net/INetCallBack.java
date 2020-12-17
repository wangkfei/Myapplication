package com.example.myapplication.utils.net;

public interface INetCallBack<T> {
    public void success(T t);

    public void onFail(String str);
}
