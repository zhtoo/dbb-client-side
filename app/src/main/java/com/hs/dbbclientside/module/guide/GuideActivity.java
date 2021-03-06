package com.hs.dbbclientside.module.guide;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.MyApplication;
import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityGuideBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/2 13:18
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class GuideActivity extends AppCompatActivity {

    private ActivityGuideBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guide);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        MyApplication.addDestoryActivity(this,"GuideActivity");
        binding.setViewModel(new GuideViewModel(this,binding));

    }
}
