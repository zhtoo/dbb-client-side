package com.hs.dbbclientside.module.help;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityForecastToolsBinding;

/**
 * 作者：zhanghaitao on 2017/12/27 17:11
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ForecastToolsActivity extends AppCompatActivity {

    private ActivityForecastToolsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forecast_tools);


        binding.setViewModel(new ForecastToolsViewModel(this,binding));

    }
}



