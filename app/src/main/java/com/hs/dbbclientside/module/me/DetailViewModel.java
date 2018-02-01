package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityDetailBinding;
import com.hs.dbbclientside.databinding.ItemDetailBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2018/1/3 17:30
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class DetailViewModel {


    private Context context;
    private ActivityDetailBinding binding;
    private List<DetailBean> datas = new ArrayList<>();

    public DetailViewModel(Context context, ActivityDetailBinding binding) {
        this.context = context;
        this.binding = binding;
        initData();
    }

    private void initData() {
        binding.detailRecycler.setLayoutManager(
                new LinearLayoutManager(context)
        );
        binding.detailRecycler.setAdapter(new MyAdapter(context, datas));

        for (int i = 0; i < 20; i++) {
            DetailBean item = new DetailBean();
            item.setType(i%2==0?"在线支付":"转账");
            item.setBalance(i%2==0?"68.88":"48.88");
            item.setDate(i%2==0?"2018-01-02":"2017-01-02");
            item.setMoney(i%2==0?"-10.00":"+16.88");
            datas.add(item);
        }
        binding.detailRecycler.getAdapter().notifyDataSetChanged();

    }

    public class MyAdapter extends RecyclerView.Adapter {

        private Context mContext;
        private List<DetailBean> datas = new ArrayList<>();

        public MyAdapter(Context context, List<DetailBean> datas) {
            mContext = context;
            this.datas = datas;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemDetailBinding binding = DataBindingUtil
                    .inflate(LayoutInflater.from(mContext),
                            R.layout.item_detail,
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
            private ItemDetailBinding binding;


            public MyViewHolder(ItemDetailBinding binding) {
                super(binding.getRoot());
                this.binding = (ItemDetailBinding) binding;
            }

            public ItemDetailBinding getBinding() {
                return binding;
            }

            public void setBinding(ItemDetailBinding binding) {
                this.binding = binding;
            }

            public void setData(int position) {
                final DetailBean item = datas.get(position);
                binding.detailType.setText(item.getType());
                binding.detailBalance.setText(item.getBalance());
                binding.detailDate.setText(item.getDate());
                binding.detailMoney.setText(item.getMoney());
            }

        }

    }


    private class DetailBean {
        private String type;
        private String balance;
        private String date;
        private String money;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance ="余额："+ balance;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }



}
