package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityBillBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2017/12/27 09:43
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BillActivity extends AppCompatActivity {

    private ActivityBillBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bill);
        StatusBarUtils.setColor(this, Color.parseColor("#ECF3FD"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);

        binding.setViewModle(new BillViewModel(this,binding));
    }
}
