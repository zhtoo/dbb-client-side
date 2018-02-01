package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseActivity;
import com.hs.dbbclientside.databinding.ActivityEnchashmentBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/3 18:03
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class EnchashmentActivity extends BaseActivity {


    private ActivityEnchashmentBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_enchashment);

        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        SpannableString s = new SpannableString("请输入金额");
        AbsoluteSizeSpan textSize = new AbsoluteSizeSpan(15,true);
        s.setSpan(textSize,0,s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.enchashmentMoney.setHint(s);

    }


}
