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

public class MeViewModle {

    private FragmentMeBinding binding;
    private Context context;

    public MeViewModle(FragmentMeBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
    }

    public void go2Bill(View view){
        context.startActivity(new Intent(context,BillActivity.class));
    }


    public void go2ApplyRecord(View view){
        context.startActivity(new Intent(context,ApplyRecordActivity.class));
    }

}
