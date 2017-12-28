package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityPersonalInformationBinding;
import com.hs.dbbclientside.util.StatusBarUtils;
import com.hs.dbbclientside.view.ExpandableView;

/**
 * 作者：zhanghaitao on 2017/12/28 10:27
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class PersonalInformationActivity extends AppCompatActivity {

    private ActivityPersonalInformationBinding binding;
    private ExpandableView mExpandableView1;
    private ExpandableView mExpandableView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_personal_information);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);
        binding.setViewModel(new PersonalInformationViewModel(this, binding));
    }






}
