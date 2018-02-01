package com.hs.dbbclientside.base.recycler;

import android.databinding.ViewDataBinding;

import java.util.List;

/**
 * 作者：zhanghaitao on 2018/1/5 13:15
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class RecyclerPresenter {

    private BaseAdapter adapter;
    private BaseViewHoler viewHoler;
    private ViewDataBinding binding;
    public List datas;

    public <T> RecyclerPresenter(ViewDataBinding binding, List<T> datas) {
        viewHoler = new BaseViewHoler(binding);
        adapter = new BaseAdapter(this);
        this.datas = datas;
    }


    public BaseViewHoler getViewHolder() {
        return viewHoler;
    }


    public int getDataSize() {
        return 0;
    }
}
