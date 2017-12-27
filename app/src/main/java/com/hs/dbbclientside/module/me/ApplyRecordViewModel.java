package com.hs.dbbclientside.module.me;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityApplyRecordBinding;
import com.hs.dbbclientside.databinding.ItemApplyRecordBinding;
import com.hs.dbbclientside.util.DensityUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2017/12/27 11:00
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class ApplyRecordViewModel {

    private Context context;
    private ActivityApplyRecordBinding binding;

    private List<ApplyRecordItemBean> datas = new ArrayList<>();


    public ApplyRecordViewModel(Context context, ActivityApplyRecordBinding binding) {
        this.context = context;
        this.binding = binding;
        initView();
    }

    private void initView() {

        binding.applyRecordRecyclerView.setLayoutManager(
                new LinearLayoutManager(context)
        );
        binding.applyRecordRecyclerView.setAdapter(new MyAdapter(context, datas));

        TabLayout tabLayout = binding.applyRecordTablayout;
        tabLayout.addTab(tabLayout.newTab().setText("申请中"));
        tabLayout.addTab(tabLayout.newTab().setText("已通过"));
        tabLayout.addTab(tabLayout.newTab().setText("未通过"));
        setIndicatorWidth(tabLayout);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑
                String tabText = tab.getText().toString().trim();
                for (int i = 0; i < datas.size(); i++) {
                    datas.get(i).setStatus(tabText);
                }
                binding.applyRecordRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中tab的逻辑
            }
        });

        for (int i = 0; i < 20; i++) {
            ApplyRecordItemBean item = new ApplyRecordItemBean();
            item.setType("汇商贷");
            item.setTime("2017/12/27");
            item.setMoney("￥12345.62");
            item.setStatus("审核中");
            datas.add(item);
        }
        binding.applyRecordRecyclerView.getAdapter().notifyDataSetChanged();
    }


    public void setIndicatorWidth(final TabLayout tabLayout) {
        //IndicatorWidth是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);

                    int margin = DensityUtils.dp2px(tabLayout.getContext(), 35);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距 注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width;
                        params.leftMargin = margin;
                        params.rightMargin = margin;

                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public class MyAdapter extends RecyclerView.Adapter {

        private Context mContext;


        private List<ApplyRecordItemBean> datas = new ArrayList<>();

        public MyAdapter(Context context) {
            mContext = context;
        }

        public MyAdapter(Context context, List<ApplyRecordItemBean> datas) {
            mContext = context;
            this.datas = datas;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemApplyRecordBinding binding = DataBindingUtil
                    .inflate(LayoutInflater.from(mContext),
                            R.layout.item_apply_record,
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
            private ItemApplyRecordBinding binding;


            public MyViewHolder(ItemApplyRecordBinding binding) {
                super(binding.getRoot());
                this.binding = (ItemApplyRecordBinding) binding;
            }

            public ItemApplyRecordBinding getBinding() {
                return binding;
            }

            public void setBinding(ItemApplyRecordBinding binding) {
                this.binding = binding;
            }

            public void setData(int position) {
                ApplyRecordItemBean item = datas.get(position);
                binding.applyRecordType.setText(item.getType());
                binding.applyRecordTime.setText(item.getTime());
                binding.applyRecordMoney.setText(item.getMoney());
                binding.applyRecordStatus.setText(item.getStatus());
                if (!TextUtils.isEmpty(item.getStatus())) {
                    binding.applyRecordStatus.setTextColor(item.getStatus().equals("审核中") ?
                            Color.parseColor("#FECF70") : Color.parseColor("#999999"));
                }
            }

        }

    }


    private class ApplyRecordItemBean {
        private String type;
        private String time;
        private String money;
        private String status;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


}
