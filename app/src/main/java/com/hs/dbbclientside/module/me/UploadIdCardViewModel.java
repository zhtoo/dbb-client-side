package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityUploadIdcardBinding;
import com.hs.dbbclientside.util.ToastUtil;
import com.zht.bottomdialog.SelectBottomDialog;

/**
 * 作者：zhanghaitao on 2018/1/2 16:21
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class UploadIdCardViewModel {

    private Context context;
    private ActivityUploadIdcardBinding binding;
    private FragmentManager fragmentManager;


    public UploadIdCardViewModel(Context context, ActivityUploadIdcardBinding binding, FragmentManager fragmentManager) {
        this.context = context;
        this.binding = binding;
        this.fragmentManager = fragmentManager;
    }


    public  void  go2Picture(View view){
        getPicture();
    }

    public  void  getPicture(){
        SelectBottomDialog dialog = new SelectBottomDialog();
        dialog.setDialogTextColor(R.color.dialog_text_color);//#63A0F4
        dialog.setDialogTextSize(15);
        dialog.setCancelTextColor(R.color.dialog_text_color);
        dialog.setCancelTextSize(15);

        dialog.setItemStrings(context, new String[]{"拍照", "从相册中选择"});
        dialog.show(fragmentManager);
        dialog.setOnClickListener(new SelectBottomDialog.onItemClickListener() {
            @Override
            public void onClick(String text) {
                ToastUtil.showToast(text);
            }
        });
    }


}
