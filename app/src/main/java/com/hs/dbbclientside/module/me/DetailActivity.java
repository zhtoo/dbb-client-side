package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseActivity;
import com.hs.dbbclientside.databinding.ActivityDetailBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/3 17:29
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class DetailActivity extends BaseActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);

        binding.setViewModel(new DetailViewModel(this,binding));
    }



}
