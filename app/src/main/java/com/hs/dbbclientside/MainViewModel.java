package com.hs.dbbclientside;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

import com.hs.dbbclientside.databinding.ActivityMainBinding;
import com.hs.dbbclientside.databinding.TabMainBinding;
import com.hs.dbbclientside.module.borrow.BorrowFragment;
import com.hs.dbbclientside.module.help.HelpFragment;
import com.hs.dbbclientside.module.home.HomeFragment;
import com.hs.dbbclientside.module.me.MeFragment;

/**
 * 作者：zhanghaitao on 2017/12/22 10:14
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class MainViewModel {

    private Context context;
    private ActivityMainBinding binding;
    private FragmentManager mSupportFragmentManager;
    private FragmentTabHost tabhost;

    public MainViewModel(Context context, ActivityMainBinding binding, FragmentManager mSupportFragmentManager, FragmentTabHost tabhost) {
        this.context = context;
        this.binding = binding;
        this.mSupportFragmentManager = mSupportFragmentManager;
        this.tabhost = tabhost;
        intiTab(binding);
    }


    private void intiTab(ActivityMainBinding binding) {
        //1.绑定tabhost和切换Fragment的布局
        tabhost.setup(context, mSupportFragmentManager, R.id.main_container);
        //去掉线
        tabhost.getTabWidget().setDividerDrawable(null);

        //2.创建Tab按钮
        //创建首页界面的按钮
        TabHost.TabSpec homeTab = tabhost.newTabSpec("all");
        homeTab.setIndicator(getIndicateView(R.drawable.ic_main_tab_home_selector, "首页"));

        //创建借款界面的按钮
        TabHost.TabSpec borrowTab = tabhost.newTabSpec("tweet");
        borrowTab.setIndicator(getIndicateView(R.drawable.ic_main_tab_borrowing_selector, "借款"));

        //创建帮助界面的按钮
        TabHost.TabSpec helpTab = tabhost.newTabSpec("exploreTab");
        helpTab.setIndicator(getIndicateView(R.drawable.ic_main_tab_help_selector, "帮助"));

        //创建我的界面的按钮
        TabHost.TabSpec meTab = tabhost.newTabSpec("meTab");
        meTab.setIndicator(getIndicateView(R.drawable.ic_main_tab_me_selector, "我的"));

        //3.添加Tab按钮以及对应的Fragment
        tabhost.addTab(homeTab, HomeFragment.class, null);
        tabhost.addTab(borrowTab, BorrowFragment.class, null);
        tabhost.addTab(helpTab, HelpFragment.class, null);
        tabhost.addTab(meTab, MeFragment.class, null);
    }


    //为每个tab初始化布局
    private View getIndicateView(int iconResId, String title) {
        TabMainBinding tabBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.tab_main, null, false);
        tabBinding.tvTitle.setText(title);
        tabBinding.ivImage.setBackgroundResource(iconResId);
        return tabBinding.getRoot();
    }


}
