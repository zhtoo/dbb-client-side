package com.hs.dbbclientside.module.help;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityCreditQueriesBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2017/12/25 14:23
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class CreditQueriesActivity extends AppCompatActivity {


    private ActivityCreditQueriesBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_credit_queries);
        StatusBarUtils.setColor(this, Color.parseColor("#628F9D"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        binding.setViewModle(new CreditQueriesViewModle(binding, this));
    }


    public void back(View view){
        finish();
    }
}
