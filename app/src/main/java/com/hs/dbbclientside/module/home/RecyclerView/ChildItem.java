package com.hs.dbbclientside.module.home.RecyclerView;

/**
 * 作者：zhanghaitao on 2017/11/20 17:21
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ChildItem {

    private String  answer;

    public ChildItem() {}

    public ChildItem(String  answer) {
        this. answer = "答："+answer;

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer =  "答："+answer;
    }
}
