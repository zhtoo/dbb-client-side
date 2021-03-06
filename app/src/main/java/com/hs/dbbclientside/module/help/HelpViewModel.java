package com.hs.dbbclientside.module.help;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.hs.dbbclientside.databinding.FragmentHelpBinding;

/**
 * 作者：zhanghaitao on 2017/12/22 13:49
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class HelpViewModel {

    private FragmentHelpBinding binding;
    private Context context;

    public HelpViewModel(FragmentHelpBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
    }


    public void go2CreditQueries(View view) {
        context.startActivity(new Intent(context, CreditQueriesActivity.class));
    }

    public void go2ApplyProcess(View view) {
        context.startActivity(new Intent(context, ApplyProcessActivtiy.class));
    }

    public void go2ForecastTools(View view) {
        context.startActivity(new Intent(context, ForecastToolsActivity.class));
    }


}
