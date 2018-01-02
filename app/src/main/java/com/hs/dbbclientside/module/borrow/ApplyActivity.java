package com.hs.dbbclientside.module.borrow;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityApplyBinding;

/**
 * 作者：zhanghaitao on 2017/12/26 14:26
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyActivity extends AppCompatActivity {


    private ActivityApplyBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply);
        binding.setViewModle(new ApplyViewModel(this, binding));
    }

    public void back(View view) {
        finish();
    }


}
