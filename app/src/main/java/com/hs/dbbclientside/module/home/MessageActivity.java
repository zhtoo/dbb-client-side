package com.hs.dbbclientside.module.home;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityMessageBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/3 11:06
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class MessageActivity extends AppCompatActivity {

    private ActivityMessageBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        binding.setViewModel(new MessageViewModel(this,binding));
    }

    public void back(View view) {
        finish();
    }


}
