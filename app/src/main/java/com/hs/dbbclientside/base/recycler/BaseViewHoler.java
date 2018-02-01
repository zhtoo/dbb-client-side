package com.hs.dbbclientside.base.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * 作者：zhanghaitao on 2018/1/5 13:12
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BaseViewHoler extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public BaseViewHoler(ViewDataBinding binding) {
        super(binding.getRoot());

        this.binding = binding;

    }


    public void setData(int position) {


    }


    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
