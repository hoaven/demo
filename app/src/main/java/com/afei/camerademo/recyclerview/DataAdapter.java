package com.afei.camerademo.recyclerview;

import android.content.Context;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afei.camerademo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : wangyya
 * date   : 2019/7/2
 */
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final static int TYPE_CONTENT=0;//正常内容
    private final static int TYPE_FOOTER=1;//加载View
    private List<Integer> listData = new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager layoutManager;

    public DataAdapter(Context mContext,List<Integer> listData, LinearLayoutManager layoutManager) {
        this.listData = listData;
        this.mContext = mContext;
        this.layoutManager = layoutManager;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == listData.size()){
            return TYPE_FOOTER;
        }
        return TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_FOOTER){
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main_foot, parent, false);
            return new FootViewHolder(view);
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main_item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_FOOTER){
        }
        else{
            MyViewHolder viewHolder= (MyViewHolder) holder;
            viewHolder.textView.setText("第" + position + "行");
        }
        layoutManager.getChildCount();
        layoutManager.getItemCount();
        layoutManager.findLastVisibleItemPosition();
    }

    @Override
    public int getItemCount() {
        return listData.size()+1;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textItem);
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder{
        ContentLoadingProgressBar contentLoadingProgressBar;
        public FootViewHolder(View itemView) {
            super(itemView);
            contentLoadingProgressBar=itemView.findViewById(R.id.pb_progress);
        }
    }
}
