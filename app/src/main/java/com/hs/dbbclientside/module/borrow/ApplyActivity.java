package com.hs.dbbclientside.module.borrow;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.R;

/**
 * 作者：zhanghaitao on 2017/12/26 14:26
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.activity_apply);
    }
}
