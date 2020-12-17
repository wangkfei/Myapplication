package com.example.myapplication2.utils;

import java.util.HashMap;

public interface InetWorkInterface {
    
    //不考虑回调的情况
    public <T> void get(String url,INetCallBack<T> callBack);
    public<T> void post(String url,INetCallBack<T> callBack);
    public<T> void post(String url, HashMap<String,String> map,INetCallBack<T> callBack);
}
