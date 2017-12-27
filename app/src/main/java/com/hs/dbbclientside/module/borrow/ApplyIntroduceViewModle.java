package com.hs.dbbclientside.module.borrow;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.hs.dbbclientside.databinding.ActivityApplyIntroduceBinding;

/**
 * 作者：zhanghaitao on 2017/12/26 13:37
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyIntroduceViewModle {

    private Context context;
    private ActivityApplyIntroduceBinding binding;

    public ApplyIntroduceViewModle(ActivityApplyIntroduceBinding binding) {
        this.binding = binding;
    }

    public ApplyIntroduceViewModle(Context context, ActivityApplyIntroduceBinding binding) {
        this.context = context;
        this.binding = binding;
    }


    public void onApplyIntroduceClick(View view){
        context.startActivity(new Intent(context,ApplyActivity.class));
    }


}
