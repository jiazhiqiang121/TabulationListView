package com.jia.tabulationrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jiazhiqiang121 on 2018/1/2.
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_CONTENT = 1;
    private List<ItemBean> mBeanList;

    public ItemAdapter(List<ItemBean> beanList) {
        this.mBeanList = beanList;
    }

    @Override
    public int getItemViewType(int position) {
        if (null != mBeanList) {
            if (mBeanList.get(position).mItemType == 0) {
                return VIEW_TYPE_HEADER;
            }
        }
        return VIEW_TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            return new ItemTitleViewHolder(LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.view_title_item, parent, false));
        } else {
            return new ItemContentViewHolder(LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.view_content_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemTitleViewHolder) {
            ((ItemTitleViewHolder) holder).mTitleTv.setText(mBeanList.get(position).mTitle);
        } else if (holder instanceof ItemContentViewHolder) {
            ((ItemContentViewHolder) holder).mContentTv.setText(mBeanList.get(position).mContent);
        }
    }

    @Override
    public int getItemCount() {
        return mBeanList.size();
    }

    private class ItemTitleViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleTv;

        public ItemTitleViewHolder(View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.item_title_tv);
        }
    }

    private class ItemContentViewHolder extends RecyclerView.ViewHolder {

        TextView mContentTv;

        public ItemContentViewHolder(View itemView) {
            super(itemView);
            mContentTv = itemView.findViewById(R.id.item_content_tv);
        }
    }
}
