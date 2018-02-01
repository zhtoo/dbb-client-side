package com.hs.dbbclientside.module.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityLoginBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/2 17:16
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        binding.setViewModel(new LoginViewModel(this, binding));
    }

    public void back(View view) {
        finish();
    }


    public void go2Register(View view) {
        startActivity(new Intent(this,RegisterActivity.class));

        // TODO: 2018/1/3 1、注册成功就直接进入主界面；2、注册后需登录。前者需要Finish，后者不需要
    }

    public void go2Forget(View view) {
        startActivity(new Intent(this,ForgetActivity.class));


    }


}
