package com.hs.dbbclientside.module.home.RecyclerView;


import com.zht.expandablerecyclerview.model.Parent;

import java.util.List;

/**
 * 作者：zhanghaitao on 2017/11/20 17:22
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ParentItem implements Parent<ChildItem> {

    private String question;



    private List<ChildItem> mChildItems;

    public ParentItem(String question, List<ChildItem> mChildItems) {
        this.question = question;
        this.mChildItems = mChildItems;
    }

    @Override
    public List<ChildItem> getChildList() {
        return mChildItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ChildItem> getmChildItems() {
        return mChildItems;
    }

    public void setmChildItems(List<ChildItem> mChildItems) {
        this.mChildItems = mChildItems;
    }
}
