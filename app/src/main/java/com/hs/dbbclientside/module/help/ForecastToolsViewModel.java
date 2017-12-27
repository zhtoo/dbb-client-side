package com.hs.dbbclientside.module.help;

import android.content.Context;

import com.hs.dbbclientside.databinding.ActivityForecastToolsBinding;

/**
 * 作者：zhanghaitao on 2017/12/27 17:12
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ForecastToolsViewModel {


    private Context context;
    private ActivityForecastToolsBinding binding;


    public ForecastToolsViewModel(Context context, ActivityForecastToolsBinding binding) {
        this.context = context;
        this.binding = binding;
    }
}
