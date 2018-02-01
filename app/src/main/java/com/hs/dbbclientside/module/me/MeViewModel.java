package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.hs.dbbclientside.databinding.FragmentMeBinding;

/**
 * 作者：zhanghaitao on 2017/12/25 14:01
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class MeViewModel {

    private FragmentMeBinding binding;
    private Context context;

    public MeViewModel(FragmentMeBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
    }

    public void go2Bill(View view){
        context.startActivity(new Intent(context,BillActivity.class));
    }


    public void go2ApplyRecord(View view){
        context.startActivity(new Intent(context,ApplyRecordActivity.class));
    }

    public void go2PersonalInfo(View view){
        context.startActivity(new Intent(context,PersonalInformationActivity.class));
    }

    public void go2Setting(View view){
        context.startActivity(new Intent(context,SettingActivity.class));
    }
    public void go2Wallet(View view){
        context.startActivity(new Intent(context,WalletActivity.class));
    }


    public void go2Bank(View view){
        context.startActivity(new Intent(context,BankActivity.class));
    }
}
