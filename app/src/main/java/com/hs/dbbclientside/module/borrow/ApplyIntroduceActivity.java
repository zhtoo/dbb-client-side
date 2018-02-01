package com.hs.dbbclientside.module.borrow;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseActivity;
import com.hs.dbbclientside.databinding.ActivityApplyIntroduceBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2017/12/26 13:35
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyIntroduceActivity extends BaseActivity {

    private ActivityApplyIntroduceBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_introduce);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        binding.setViewModel(new ApplyIntroduceViewModel(this,binding));
    }




}
