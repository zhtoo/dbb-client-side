package com.hs.dbbclientside.base.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * 作者：zhanghaitao on 2018/1/5 13:11
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BaseAdapter extends RecyclerView.Adapter {

    private RecyclerPresenter  presenter ;

    public BaseAdapter(RecyclerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return presenter.getViewHolder();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        presenter.getViewHolder().setData(position);
    }

    @Override
    public int getItemCount() {
        return presenter.getDataSize();
    }
}
