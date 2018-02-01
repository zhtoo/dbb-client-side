package com.hs.dbbclientside.module.home;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityUseHelpBinding;
import com.hs.dbbclientside.module.home.RecyclerView.ChildItem;
import com.hs.dbbclientside.module.home.RecyclerView.ParentItem;
import com.hs.dbbclientside.module.home.RecyclerView.UseHelpAdapter;
import com.hs.dbbclientside.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：zhanghaitao on 2018/1/3 11:38
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class UseHelpAcyivity extends AppCompatActivity {

    private ActivityUseHelpBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_use_help);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        StatusBarUtils.measureTitleBarHeight(binding.getRoot(), this);

        initData();
    }

    public void back(View view) {
        finish();
    }





    /**
     * 初始化数据（temp）
     */
    private void initData() {
        final List<ParentItem> parentItems = new ArrayList<>();

        for (int i = 1; i < 21; i++) {
            ChildItem child = new ChildItem();
            child.setAnswer("买下皇城" + i);
            parentItems.add(new ParentItem("张亚鹏" + i, Arrays.asList(child)));
        }
        UseHelpAdapter adapter = new UseHelpAdapter(this, parentItems);
        binding.useHelpRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.useHelpRecycler.setAdapter(adapter);
        /**父类条目展开的监听*/
//        adapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
//            @Override
//            public void onParentExpanded(int parentPosition) {
//            }
//
//            @Override
//            public void onParentCollapsed(int parentPosition) {
//            }
//        });

    }








}
