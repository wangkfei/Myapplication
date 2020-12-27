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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends DelegateAdapter.Adapter {
   private  ColumnLayoutHelper columnLayoutHelper;
   private Context context;
   private List<HomeBean.DataBean.ChannelBean> list;

    public MyAdapter(ColumnLayoutHelper columnLayoutHelper, Context context,ArrayList<HomeBean.DataBean.ChannelBean> list) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_2, parent, false);
        return new MyAdapter.ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            ViewHolder1 holder2 = (ViewHolder1) holder;
            Glide.with(context).load(list.get(position).getIcon_url()).into(holder2.image1);
            holder2.text.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;

        private ImageView image1;


        private TextView text;




        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;

            this.image1 = rootView.findViewById(R.id.image1);

            this.text = rootView.findViewById(R.id.text);


        }

    }
}
