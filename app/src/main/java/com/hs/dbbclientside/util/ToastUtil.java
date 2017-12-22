package com.hs.dbbclientside.util;

import android.widget.Toast;

import com.hs.dbbclientside.MyApplication;

/**
 * 连续弹的吐司
 */
public class ToastUtil {
    private static Toast toast;

    public static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);//如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }
}
