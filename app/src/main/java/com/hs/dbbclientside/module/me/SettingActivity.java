package com.hs.dbbclientside.module.me;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseActivity;

/**
 * 作者：zhanghaitao on 2018/1/3 16:30
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.activity_setting);

    }
}
