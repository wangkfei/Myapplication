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

public class FragGridAdapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private List<HomeBean.DataBean.BrandListBean> grid;
    private Context context;

    public FragGridAdapter(GridLayoutHelper gridLayoutHelper, List<HomeBean.DataBean.BrandListBean> grid, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.grid = grid;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(grid.get(position).getNew_pic_url()).into(holder1.img1);
        holder1.text1.setText(grid.get(position).getName());
        holder1.text2.setText(grid.get(position).getFloor_price()+"");
    }

    @Override
    public int getItemCount() {
        return grid.size();
    }



    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;

        private ImageView img1;


        private TextView text1;

        private TextView text2;


        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;

            this.img1 = rootView.findViewById(R.id.img1);

            this.text1 = rootView.findViewById(R.id.text1);
            this.text2 = rootView.findViewById(R.id.text2);

        }

    }
}
