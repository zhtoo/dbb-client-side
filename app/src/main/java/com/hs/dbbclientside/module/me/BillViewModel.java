package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityBillBinding;
import com.hs.dbbclientside.databinding.ItemBillBinding;

/**
 * 作者：zhanghaitao on 2017/12/27 09:44
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BillViewModel {


    private Context context ;
    private ActivityBillBinding binding;


    public BillViewModel(Context context, ActivityBillBinding binding) {
        this.context = context;
        this.binding = binding;
        setScrollViewContent();
    }



    /**
     * 在ScrollView中添加内容
     */
    private void setScrollViewContent() {
        //NestedScrollView下的LinearLayout
        LinearLayout layout = binding.billContent;
        layout.removeAllViews();
        for (int i = 0; i < 20; i++) {
            ItemBillBinding binding =
                    DataBindingUtil.inflate(LayoutInflater.from(context),
                            R.layout.item_bill, null, false);
            binding.billType.setText(i%2==0?"汇商贷":"汇民贷");
            binding.billPeriods.setText(i+"期/20期");
            binding.billMoney.setText("￥"+"\t"+String.valueOf(i*100));
            //动态添加 子View
            layout.addView(binding.getRoot(), i);
        }
    }


}
