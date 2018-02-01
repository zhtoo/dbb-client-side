package com.hs.dbbclientside.module.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityRegisterBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/3 10:15
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class RegisterActivity extends AppCompatActivity {


    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);

    }

    public void back(View view) {
        finish();
    }
    public void next(View view) {
        startActivity(new Intent(this,CertificationActivity.class));
    }

}
