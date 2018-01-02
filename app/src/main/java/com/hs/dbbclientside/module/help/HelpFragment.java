package com.hs.dbbclientside.module.help;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseFragment;
import com.hs.dbbclientside.databinding.FragmentHelpBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * @author： Tom on 2017/12/18 23:42
 * @email： 820159571@qq.com
 *  
 */
public class HelpFragment extends BaseFragment {

    private FragmentHelpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_help, container, false);

        StatusBarUtils.measureTitleBarHeight(binding.getRoot(),getContext());
        binding.setViewModel(new HelpViewModel(binding,getContext()));
        return binding.getRoot();
    }





}
