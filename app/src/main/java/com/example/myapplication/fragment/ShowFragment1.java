package com.example.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.Api;
import com.example.myapplication.R;
import com.example.myapplication.bean.HomeBean;
import com.example.myapplication.view.adapter.FragGrid2Adapter;
import com.example.myapplication.view.adapter.FragGridAdapter;
import com.example.myapplication.view.adapter.FragmentLinerAdapter;
import com.example.myapplication.view.adapter.MyAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ShowFragment1 extends Fragment {


    private EditText search_edit;
    private RecyclerView recy;
    private Banner banner1;
    private ColumnLayoutHelper columnLayoutHelper;
    private ArrayList<HomeBean.DataBean.ChannelBean> list;
    private MyAdapter myAdapter;
    private DelegateAdapter adapter;
    private RecyclerView recy1;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private FragGridAdapter fragGridAdapter;
    private VirtualLayoutManager virtualLayoutManager;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private FragGrid2Adapter fragGrid2Adapter;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private FragmentLinerAdapter fragmentLinerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show1, container, false);
        initview(view);
        initData();
        return view;

    }

    private void initData() {
        new Retrofit.Builder().baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        .create(Api.class)
        .get()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<HomeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull HomeBean homeBean) {
                Log.d("TAG1", "onNext: "+homeBean.getData().getBanner().toString());
                List<HomeBean.DataBean.BannerBean> bannerS = homeBean.getData().getBanner();
                banner1.setImages(bannerS).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBean.DataBean.BannerBean bannerBean= (HomeBean.DataBean.BannerBean) path;
                        Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
                    }
                }).start();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        new Retrofit.Builder().baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class)
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HomeBean homeBean) {
                        Log.d("TAG1", "onNext: "+homeBean.getData().getChannel().toString());
                        List<HomeBean.DataBean.ChannelBean> channel = homeBean.getData().getChannel();

                        list.addAll(channel);
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



        new Retrofit.Builder().baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class)
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HomeBean homeBean) {
                        Log.d("TAG1", "onNext: "+homeBean.getData().getBrandList().toString());
                        List<HomeBean.DataBean.BrandListBean> brandList = homeBean.getData().getBrandList();
                        brandListBeans.addAll(brandList);
                        fragGridAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



                new Retrofit.Builder()
                        .baseUrl(Api.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
                        .create(Api.class)
                        .get()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<HomeBean>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull HomeBean homeBean) {
                                Log.d("TAG1", "onNext: "+homeBean.getData().getNewGoodsList().toString());
                                List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = homeBean.getData().getNewGoodsList();
                                newGoodsListBeans.addAll(newGoodsList);
                                fragGrid2Adapter.notifyDataSetChanged();

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


        new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class)
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HomeBean homeBean) {
                        Log.d("TAG1", "onNext: "+homeBean.getData().getHotGoodsList().toString());
                        List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList = homeBean.getData().getHotGoodsList();
                        hotGoodsListBeans.addAll(hotGoodsList);
                        fragmentLinerAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        adapter = new DelegateAdapter(virtualLayoutManager,true);
        adapter.addAdapter(myAdapter);
        adapter.addAdapter(fragGridAdapter);
        adapter.addAdapter(fragGrid2Adapter);
        adapter.addAdapter(fragmentLinerAdapter);


        recy.setAdapter(adapter);

    }

    private void initview(View view) {
        search_edit = view.findViewById(R.id.search_edit);
        banner1 = view.findViewById(R.id.banner);
        recy = view.findViewById(R.id.Recy);


        virtualLayoutManager = new VirtualLayoutManager(getActivity());

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();

        recy.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,10);

        recy.setLayoutManager(virtualLayoutManager);




        /**
         设置栏格布局
         */
        columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        list = new ArrayList<>();
        myAdapter = new MyAdapter(columnLayoutHelper,getActivity(), list);


        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        brandListBeans = new ArrayList<>();
        fragGridAdapter = new FragGridAdapter(gridLayoutHelper,brandListBeans,getActivity());



        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        newGoodsListBeans = new ArrayList<>();
        fragGrid2Adapter = new FragGrid2Adapter(gridLayoutHelper2, getActivity(), newGoodsListBeans);



        /**
         设置线性布局
         */
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(3);// 设置布局里Item个数

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        hotGoodsListBeans = new ArrayList<>();
        fragmentLinerAdapter = new FragmentLinerAdapter(linearLayoutHelper, hotGoodsListBeans, getActivity());






    }


}