package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseActivity;
import com.hs.dbbclientside.databinding.ActivityBankBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/5 11:08
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BankActivity extends BaseActivity {


    private ActivityBankBinding binding;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bank);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        fragmentManager = getSupportFragmentManager();
        binding.setViewModel(new BankViewModel(this, binding, fragmentManager));

    }







}
