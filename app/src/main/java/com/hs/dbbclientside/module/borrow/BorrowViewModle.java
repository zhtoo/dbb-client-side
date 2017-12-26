package com.hs.dbbclientside.module.borrow;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.FragmentBorrowBinding;
import com.hs.dbbclientside.databinding.ItemBorrwContentBinding;
import com.hs.dbbclientside.databinding.ItemBorrwHeaderBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2017/12/22 13:49
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class BorrowViewModle {

    private FragmentBorrowBinding binding;
    private Context context;

    private List<BorrowItemBean> datas;


    // TODO: 2017/12/25 下面是假数据
    int[] icons = {
            R.drawable.ic_borrow_hmd_01,
            R.drawable.ic_borrow_hmd_02,
            R.drawable.ic_borrow_hmd_03,
            R.drawable.ic_borrow_hmd_04,
            R.drawable.ic_borrow_hmd_05,
            R.drawable.ic_borrow_hmd_06,
    };

    private String[] loanTypes = {"汇民贷", "汇商贷", "汇业贷", "汇车贷", "汇农贷", "汇房贷"};
    private String[] loanRanges = {
            "￥2,000-￥20,000",
            "￥20,000-￥2000,000",
            "￥5,000-￥10,000",
            "￥50,000-￥200,000",
            "￥2,000-￥10,000",
            "￥50,000-￥1000,000"};
    private String[] loanInstructions = {
            "2,000元起借 到款快",
            "按日计息 随借随还",
            "有身份证就能申请",
            "提前体验有车一族的快感",
            "享受丰收的利益",
            "感受家的感觉"};

    public BorrowViewModle(FragmentBorrowBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
        initRecycler();
        initData();
    }


    private void initRecycler() {
        // TODO: 2017/12/25 联网获取数据
        binding.borrowRecycler.setLayoutManager(new LinearLayoutManager(context));
        LinearLayoutManager manager = new LinearLayoutManager(context);
        binding.borrowRecycler.setLayoutManager(manager);
        binding.borrowRecycler.setHasFixedSize(true);
        datas = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(context, datas);
        binding.borrowRecycler.setAdapter(adapter);
    }


    private void initData() {
        for (int i = 0; i < icons.length; i++) {
            BorrowItemBean bean = new BorrowItemBean();
            bean.setIcon(icons[i]);
            bean.setLoanType(loanTypes[i]);
            bean.setLoanRange(loanRanges[i]);
            bean.setLoanInstruction(loanInstructions[i]);
            datas.add(bean);
        }

        binding.borrowRecycler.getAdapter().notifyDataSetChanged();
    }


    public class MyAdapter extends RecyclerView.Adapter {

        private Context mContext;

        private int HeaderCount = 1;

        private int HEADER_TYPE = 0;
        private int CONTENT_TYPE = 1;

        // private String[] datas = {"", "", "", "", "", ""};
        private List<BorrowItemBean> datas;

        public MyAdapter(Context context) {
            mContext = context;

        }

        public MyAdapter(Context context, List<BorrowItemBean> datas) {
            mContext = context;
            this.datas = datas;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return HEADER_TYPE;
            } else {
                return CONTENT_TYPE;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == HEADER_TYPE) {
                ItemBorrwHeaderBinding binding =
                        DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_borrw_header, parent, false);
                return new MyHeaderViewHolder(binding);
            } else {
                ItemBorrwContentBinding binding =
                        DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_borrw_content, parent, false);
                return new MyContentViewHolder(binding);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyHeaderViewHolder) {
                MyHeaderViewHolder viewHolder = (MyHeaderViewHolder) holder;
                viewHolder.setData(position);
                viewHolder.getBinding().executePendingBindings();
            } else {
                MyContentViewHolder viewHolder = (MyContentViewHolder) holder;
                viewHolder.setData(position-HeaderCount);
                viewHolder.getBinding().executePendingBindings();
            }
        }

        @Override
        public int getItemCount() {
            return datas.size() + HeaderCount;
        }

        public class MyHeaderViewHolder extends RecyclerView.ViewHolder {
            private ItemBorrwHeaderBinding binding;

            public MyHeaderViewHolder(ViewDataBinding binding) {
                super(binding.getRoot());
                this.binding = (ItemBorrwHeaderBinding) binding;
            }

            public ItemBorrwHeaderBinding getBinding() {
                return binding;
            }

            public void setBinding(ItemBorrwHeaderBinding binding) {
                this.binding = binding;
            }


            public void setData(int position) {

            }

        }

        public class MyContentViewHolder extends RecyclerView.ViewHolder {
            private ItemBorrwContentBinding binding;


            public MyContentViewHolder(ViewDataBinding binding) {
                super(binding.getRoot());
                this.binding = (ItemBorrwContentBinding) binding;
            }

            public ItemBorrwContentBinding getBinding() {
                return binding;
            }

            public void setBinding(ItemBorrwContentBinding binding) {
                this.binding = binding;
            }

            public void setData(int position) {
                binding.borrowContentIcon.setImageResource(datas.get(position).getIcon());
                binding.borrowContentLoanType.setText(datas.get(position).getLoanType());
                binding.borrowMoneyRange.setText(datas.get(position).getLoanRange());
                binding.borrowMoneyInstruction.setText(datas.get(position).getLoanInstruction());

                binding.borrowContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context,ApplyIntroduceActivity.class));
                    }
                });

            }

        }

    }


}
