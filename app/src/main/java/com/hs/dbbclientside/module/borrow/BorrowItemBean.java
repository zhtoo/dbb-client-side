package com.hs.dbbclientside.module.borrow;

/**
 * 作者：zhanghaitao on 2017/12/25 16:43
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BorrowItemBean {

    private int icon;

    private String loanType;

    private String loanRange;

    private String loanInstruction;




    public BorrowItemBean( ) {

    }

    public BorrowItemBean(int icon, String loanType, String loanRange, String loanInstruction) {
        this.icon = icon;
        this.loanType = loanType;
        this.loanRange = loanRange;
        this.loanInstruction = loanInstruction;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanInstruction() {
        return loanInstruction;
    }

    public void setLoanInstruction(String loanInstruction) {
        this.loanInstruction = loanInstruction;
    }

    public String getLoanRange() {
        return loanRange;
    }

    public void setLoanRange(String loanRange) {
        this.loanRange = loanRange;
    }
}
