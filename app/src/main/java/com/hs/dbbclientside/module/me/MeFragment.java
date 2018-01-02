package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseFragment;
import com.hs.dbbclientside.databinding.FragmentMeBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * @author： Tom on 2017/12/18 23:42
 * @email： 820159571@qq.com
 * @describe:个人中心的详情界面
 */
public class MeFragment extends BaseFragment {


    private FragmentMeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false);

        StatusBarUtils.measureTitleBarHeight(binding.getRoot(),getContext());
        binding.setViewModel(new MeViewModel(binding,getContext()));
        return binding.getRoot();
    }


}
