package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.EditText;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityPersonalInformationBinding;
import com.hs.dbbclientside.util.EditTextFormat;
import com.hs.dbbclientside.util.InputCheck;
import com.hs.dbbclientside.util.ToastUtil;
import com.hs.dbbclientside.view.ExpandableView;

import java.util.LinkedList;

/**
 * 作者：zhanghaitao on 2017/12/28 10:28
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class PersonalInformationViewModel extends BaseObservable {

    private Context context;
    private ActivityPersonalInformationBinding binding;

    public String name;

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyChange();
    }

    public String phone;

    public PersonalInformationViewModel(Context context, final ActivityPersonalInformationBinding binding) {
        this.context = context;
        this.binding = binding;
        init();

        binding.personalInfoSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setPhone("13517194559");
                ToastUtil.showToast(phone);


            }
        });
    }

    private void init() {
        createExpandableView(binding.userInfoContact1, "直系亲属联系方式");
        createExpandableView(binding.userInfoContact2, "一般联系方人");
    }

    private void createExpandableView(ExpandableView mExpandableView, String title) {
        mExpandableView.fillData(0, title, true);
        for (int i = 0; i < 2; i++) {
            View itemView = View.inflate(context, R.layout.item_user_info_contact, null);
            mExpandableView.addContentView(itemView);
        }
    }


    /**
     * 需监听的editText list
     */
    public LinkedList<EditText> edList = new LinkedList<>();
    public ObservableField<Boolean> enable = new ObservableField<>(false);

    /**
     * 监听EditText 变化
     */
    public EditTextFormat.EditTextFormatWatcher watcher = new EditTextFormat.EditTextFormatWatcher() {
        @Override
        public void OnTextWatcher(String str) {
            enable.set(InputCheck.edListCheck(edList));
            enable.notifyChange();
        }
    };

    /**
     * 焦点改变事件
     *
     * @param view
     * @param hasFocus 是否获得焦点
     */
    public void focusChange(View view, boolean hasFocus) {
        if (hasFocus) {//获取到焦点

        }
    }
}



