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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.HomeBean;

import java.util.List;

public class FragGrid2Adapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private Context context;
    private List<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans;

    public FragGrid2Adapter(GridLayoutHelper gridLayoutHelper, Context context, List<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
        this.newGoodsListBeans = newGoodsListBeans;
    }



    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.grid_layout2, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(newGoodsListBeans.get(position).getList_pic_url()).into(holder1.imag1);
        holder1.text1.setText(newGoodsListBeans.get(position).getName());
        holder1.text2.setText(newGoodsListBeans.get(position).getRetail_price()+"");

    }

    @Override
    public int getItemCount() {
        return newGoodsListBeans.size();
    }



    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;

        private ImageView imag1;


        private TextView text1;

        private TextView text2;


        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;

            this.imag1 = rootView.findViewById(R.id.imag1);

            this.text1 = rootView.findViewById(R.id.text1);
            this.text2 = rootView.findViewById(R.id.text2);

        }

    }
}
