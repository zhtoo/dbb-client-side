package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityBankBinding;
import com.hs.dbbclientside.databinding.ItemBankBinding;
import com.hs.dbbclientside.util.ToastUtil;
import com.zht.bottomdialog.SelectBottomDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2018/1/5 11:09
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BankViewModel {


    private Context context;
    private ActivityBankBinding binding;
    private FragmentManager fragmentManager;

    public BankViewModel(Context context, ActivityBankBinding binding, FragmentManager fragmentManager) {
        this.context = context;
        this.binding = binding;
        this.fragmentManager = fragmentManager;
        initData();
    }

    private void initData() {


    }


    public void addBank(View view) {
        SelectBottomDialog dialog = new SelectBottomDialog();
        dialog.setDialogTextColor(R.color.add_bank_dialog_text_color);//#63A0F4
        dialog.setDialogTextSize(15);
        dialog.setCancelTextColor(R.color.add_bank_dialog_text_color);
        dialog.setCancelTextSize(15);

        dialog.setItemStrings(context, new String[]{"信用卡", "储蓄卡"});
        dialog.show(fragmentManager);
        dialog.setOnClickListener(new SelectBottomDialog.onItemClickListener() {
            @Override
            public void onClick(String text) {
                ToastUtil.showToast(text);
            }
        });
    }


    private class MyAdapter extends RecyclerView.Adapter {
        private Context mContext;

        private List<BankBean> datas = new ArrayList<>();

        public MyAdapter(Context mContext, List<BankBean> datas) {
            this.mContext = mContext;
            this.datas = datas;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            ItemBankBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                    R.layout.item_bank,
                    parent, false);
            return new MyViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.setData(position);
            viewHolder.getBinding().executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ItemBankBinding getBinding() {
                return binding;
            }

            public void setBinding(ItemBankBinding binding) {
                this.binding = binding;
            }

            private ItemBankBinding binding;

            public MyViewHolder(ItemBankBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            public void setData(int position) {
                BankBean item = datas.get(position);

            }
        }


    }

    private class BankBean {
        private String iconUrl;
        private String bankNumber;

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getBankNumber() {
            return bankNumber;
        }

        public void setBankNumber(String bankNumber) {
            this.bankNumber = bankNumber;
        }
    }

}