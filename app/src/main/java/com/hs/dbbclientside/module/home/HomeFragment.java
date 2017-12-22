package com.hs.dbbclientside.module.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseFragment;
import com.hs.dbbclientside.databinding.FragmentHomeBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2017/12/22 13:49
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */
public class HomeFragment extends BaseFragment {


    private FragmentHomeBinding binding;
    private HomeViewModle viewModle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        measureTitleBarHeight(binding.getRoot());
     //   binding.executePendingBindings();//此方法必须执行在UI线程，当绑定的数据修改时更新视图

        viewModle = new HomeViewModle(binding);
        binding.setViewModel(viewModle);
        return binding.getRoot();
    }


    private void measureTitleBarHeight(View view) {
        if (view != null) {
            view.setPadding(view.getLeft(),
                    StatusBarUtils.getStatusBarHeight(getContext()),
                    view.getRight(), view.getBottom());
        }
    }


}
