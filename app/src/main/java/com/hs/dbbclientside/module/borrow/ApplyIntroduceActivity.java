package com.hs.dbbclientside.module.borrow;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityApplyIntroduceBinding;

/**
 * 作者：zhanghaitao on 2017/12/26 13:35
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyIntroduceActivity extends AppCompatActivity {

    private ActivityApplyIntroduceBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_introduce);
        binding.setViewModle(new ApplyIntroduceViewModel(this,binding));
    }




}
