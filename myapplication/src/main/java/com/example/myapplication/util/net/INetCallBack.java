package com.example.myapplication.util.net;

public interface INetCallBack {
    public void success(T t);
    public void onFail(String str);
}
