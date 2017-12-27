package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityApplyRecordBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2017/12/27 10:59
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyRecordActivity extends AppCompatActivity {

    private ActivityApplyRecordBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_record);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);

        binding.setViewModel(new ApplyRecordViewModel(this,binding));
    }





}
