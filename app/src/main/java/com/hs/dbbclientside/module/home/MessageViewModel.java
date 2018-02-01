package com.hs.dbbclientside.module.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityMessageBinding;
import com.hs.dbbclientside.databinding.ItemMessageBinding;
import com.hs.dbbclientside.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2018/1/3 11:06
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class MessageViewModel {


    private Context context;
    private ActivityMessageBinding binding;
    private List<MessageBean> datas = new ArrayList<>();

    public MessageViewModel(Context context, ActivityMessageBinding binding) {
        this.context = context;
        this.binding = binding;
        initData();
    }

    private void initData() {
        binding.messageRecycler.setLayoutManager(
                new LinearLayoutManager(context)
        );
        binding.messageRecycler.setAdapter(new MyAdapter(context, datas));

        for (int i = 0; i < 20; i++) {
            MessageBean item = new MessageBean();
            item.setTitle("我是标题" +i);
            item.setTime("2010-01-02");

            item.setUrl("https://www.baidu.com"+i);
            datas.add(item);
        }
        binding.messageRecycler.getAdapter().notifyDataSetChanged();

    }

    public class MyAdapter extends RecyclerView.Adapter {

        private Context mContext;

        private List<MessageBean> datas = new ArrayList<>();

        public MyAdapter(Context context) {
            mContext = context;
        }

        public MyAdapter(Context context, List<MessageBean> datas) {
            mContext = context;
            this.datas = datas;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemMessageBinding binding = DataBindingUtil
                    .inflate(LayoutInflater.from(mContext),
                            R.layout.item_message,
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
            private ItemMessageBinding binding;


            public MyViewHolder(ItemMessageBinding binding) {
                super(binding.getRoot());
                this.binding = (ItemMessageBinding) binding;
            }

            public ItemMessageBinding getBinding() {
                return binding;
            }

            public void setBinding(ItemMessageBinding binding) {
                this.binding = binding;
            }

            public void setData(int position) {
                final MessageBean item = datas.get(position);
                binding.messageTitle.setText(item.getTitle());
                binding.messageTime.setText(item.getTime());
                binding.messageContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ToastUtil.showToast("我要去访问：" + item.getUrl());
                        //  context.startActivity(new Intent());
                    }
                });
            }

        }

    }


    private class MessageBean {
        private String title;
        private String time;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
