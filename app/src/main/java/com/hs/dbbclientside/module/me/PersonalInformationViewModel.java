package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityPersonalInformationBinding;
import com.hs.dbbclientside.view.ExpandableView;

/**
 * 作者：zhanghaitao on 2017/12/28 10:28
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class PersonalInformationViewModel {

    private Context context;
    private ActivityPersonalInformationBinding binding;


    public PersonalInformationViewModel(Context context, ActivityPersonalInformationBinding binding) {
        this.context = context;
        this.binding = binding;
        init();
    }

    private void init() {
        createExpandableView(binding.userInfoContact1,"直系亲属联系方式");
        createExpandableView(binding.userInfoContact2,"一般联系方人");
    }

    private void createExpandableView(ExpandableView mExpandableView, String title) {
        mExpandableView.fillData(0, title, true);
        for (int i = 0; i < 2; i++) {
            View itemView = View.inflate(context, R.layout.item_user_info_contact, null);
            mExpandableView.addContentView(itemView);
        }
    }




}
