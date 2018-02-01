package com.hs.dbbclientside.module.home.RecyclerView;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hs.dbbclientside.R;
import com.zht.expandablerecyclerview.ChildViewHolder;

/**
 * 作者：zhanghaitao on 2017/11/21 16:19
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ChildItemViewHolder extends ChildViewHolder {

    private final String TAG = getClass().getSimpleName();
    private final TextView textView;


    public ChildItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.use_help_answer);
    }

    /**
     * 绑定数据
     *
     * @param childItem
     */
    public void bind(ChildItem childItem, final int parentPosition, final int childPosition) {
        textView.setText(childItem.getAnswer());
    }


    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    private ClickListener listener;

    interface ClickListener {
        void onItemClick(int parentPosition, int childPosition);
    }

}