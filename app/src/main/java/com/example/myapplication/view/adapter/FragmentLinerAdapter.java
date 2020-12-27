package com.example.myapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.HomeBean;

import java.util.List;

public class FragmentLinerAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private List<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeanList;
    private Context context;

    public FragmentLinerAdapter(LinearLayoutHelper linearLayoutHelper, List<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeanList, Context context) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.hotGoodsListBeanList = hotGoodsListBeanList;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.liner_item_layout, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(hotGoodsListBeanList.get(position).getList_pic_url()).into(holder1.img1);
        holder1.text1.setText(hotGoodsListBeanList.get(position).getName());
        holder1.text2.setText(hotGoodsListBeanList.get(position).getGoods_brief());
        holder1.text3.setText(hotGoodsListBeanList.get(position).getRetail_price()+" ");
    }

    @Override
    public int getItemCount() {
        return hotGoodsListBeanList.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;

        private ImageView img1;


        private TextView text1;
        private TextView text2;
        private TextView text3;




        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;

            this.img1 = rootView.findViewById(R.id.img1);

            this.text1 = rootView.findViewById(R.id.text1);
            this.text2 = rootView.findViewById(R.id.text2);
            this.text3 = rootView.findViewById(R.id.text3);


        }

    }
}
