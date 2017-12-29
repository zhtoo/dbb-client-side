package com.hs.dbbclientside.base;

import android.databinding.BindingAdapter;
import android.widget.EditText;

import com.hs.dbbclientside.util.EditTextFormat;

import java.util.LinkedList;

/**
 * Description: XML binding数据
 * <p/>
 * xmlns:app="http://schemas.android.com/apk/res-auto"
 */
public class XMLBinding {
    /**
     * list 中 EditText 变化通知
     */
    @BindingAdapter(value = {"watcher", "list"}, requireAll = false)
    public static void setEditChangelistener(EditText ed, EditTextFormat.EditTextFormatWatcher watcher, LinkedList<EditText> edlist) {
        if (null != watcher) {
            EditTextFormat.editChange(ed, watcher);
        }
        if (null != edlist) {
            edlist.add(ed);
        }
    }
}
