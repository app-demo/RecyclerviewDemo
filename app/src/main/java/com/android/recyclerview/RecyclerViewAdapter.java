package com.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Author: river
 * Date: 2016/4/1 17:05
 * Description:
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, List<String> datas) {
        this.context = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建ViewHolder

        View itemView = mInflater.inflate(R.layout.recycler_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 绑定ViewHolder
        holder.mTvContent.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        // 数量
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mTvContent;

    public MyViewHolder(View itemView) {
        super(itemView);

        mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
    }
}
