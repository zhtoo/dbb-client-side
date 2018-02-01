package com.hs.dbbclientside.module.me;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseActivity;
import com.hs.dbbclientside.databinding.ActivityWalletBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

/**
 * 作者：zhanghaitao on 2018/1/3 17:03
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class WalletActivity extends BaseActivity {


    private ActivityWalletBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_wallet);

        StatusBarUtils.setColor(this, Color.parseColor("#00000000"));
        StatusBarUtils.measureTitleBarHeight(binding.walletBg, this);
    }

    public void go2Detail(View view){
        startActivity(new Intent(this,DetailActivity.class));
    }

    public void go2Enchashment(View view){
        startActivity(new Intent(this,EnchashmentActivity.class));
    }


}
