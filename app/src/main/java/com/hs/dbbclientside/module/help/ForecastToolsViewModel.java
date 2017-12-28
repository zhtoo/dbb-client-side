package com.hs.dbbclientside.module.help;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityForecastToolsBinding;
import com.hs.dbbclientside.databinding.ItemForecastToolBinding;

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
        setScrollViewContent();
    }


    /**
     * 刷新ScrollView的内容
     */
    private void setScrollViewContent() {
        //NestedScrollView下的LinearLayout
        LinearLayout layout = binding.forecastToolContent;
        layout.removeAllViews();
        for (int i = 0; i < 20; i++) {
            ItemForecastToolBinding binding =
                    DataBindingUtil.inflate(LayoutInflater.from(context),
                            R.layout.item_forecast_tool, null, false);
            binding.itemForecastToolPeriods.setText("第"+i+"期");
            binding.itemForecastToolMoney.setText(String.valueOf(i*100));
            //动态添加 子View
            layout.addView(binding.getRoot(), i);
        }
    }
}
