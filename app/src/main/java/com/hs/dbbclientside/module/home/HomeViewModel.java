package com.hs.dbbclientside.module.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hs.dbbclientside.MainActivity;
import com.hs.dbbclientside.R;
import com.hs.dbbclientside.base.BaseParams;
import com.hs.dbbclientside.databinding.FragmentHomeBinding;
import com.hs.dbbclientside.databinding.ItemHomeBinding;
import com.hs.dbbclientside.module.login.LoginActivity;
import com.hs.dbbclientside.util.SPUtil;
import com.hs.dbbclientside.util.ToastUtil;
import com.zht.banner.banner.CBViewHolderCreator;
import com.zht.banner.banner.NetworkImageHolderView;
import com.zht.banner.banner.RBannerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2017/12/22 13:49
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class HomeViewModel {

    private Context context;
    private FragmentHomeBinding binding;
    private MainActivity activity;


    public HomeViewModel(Context context, FragmentHomeBinding binding) {
        this.context = context;
        this.binding = binding;
        initData();
    }

    public HomeViewModel(Context context, FragmentHomeBinding binding, MainActivity activity) {
        this.context = context;
        this.binding = binding;
        this.activity = activity;
        initData();
    }

    private void initData() {
        List<BannerModel> bannerList = new ArrayList<>();
        String[] bannerUrl = {
                "http://img5.imgtn.bdimg.com/it/u=1429218968,2722738071&fm=27&gp=0.jpg",
                "http://pic.90sjimg.com/back_pic/00/01/88/75/5682330d087b959a1ee853f11cb78f37.jpg",
                "http://img.zcool.cn/community/012d3658de20b6a801219c77083959.jpg",
                "http://img.zcool.cn/community/01f14657834af70000018c1b211b79.jpg",
                "http://pic.90sjimg.com/back_pic/00/00/69/40/9c3df37ed607f0c9ed811643d94e7f1e.jpg",
        };
        for (int i = 0; i < bannerUrl.length; i++) {
            BannerModel bannerModel = new BannerModel();
            bannerModel.setImageUrl(bannerUrl[i]);
            bannerModel.setTitle("Banner测试：" + i);
            bannerList.add(bannerModel);
        }
        bindBanner(bannerList);
        initItemList();
    }

    /**
     * 初始化列表条目
     */
    private void initItemList() {
        //NestedScrollView下的LinearLayout
        LinearLayout layout = binding.homeContent;
        layout.removeAllViews();
        for (int i = 0; i < 6; i++) {
            ItemHomeBinding binding =
                    DataBindingUtil.inflate(LayoutInflater.from(context),
                            R.layout.item_home, null, false);

            //动态添加 子View
            layout.addView(binding.getRoot(), i);
        }
    }


    /**
     * 绑定banner图
     */
    private void bindBanner(final List<BannerModel> bannerList) {
        List<RBannerBean> bannerImages = new ArrayList<>();
        for (BannerModel banner : bannerList) {
            RBannerBean bean = new RBannerBean();
            bean.setPicUrl(banner.getImageUrl());
            bean.setIntroduction(banner.getTitle());
            bannerImages.add(bean);
        }

        binding.homeBanner.startTurning(3000);
        binding.homeBanner.setPages(
                new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView() {
                            @Override
                            protected void itemOnClick(int position) {
                                if (!TextUtils.isEmpty(bannerList.get(position).getLink())) {
                                    //link 不为空时跳转

                                } else {
                                    ToastUtil.showToast("链接为空，请勿点击！！！" + position);
                                }
                            }
                        };
                    }
                }, bannerImages)
                // 设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused});
    }


    /////////////////////////////////////////////////////////////////////
    //////点击事件处理START
    /////////////////////////////////////////////////////////////////////
    public void go2Borrow(View view) {
        boolean hasLogin = SPUtil.getBoolean(BaseParams.hasLogin, false);
        if(hasLogin){
            activity.getViewModel().changeTab(2);
        }else {
           context.startActivity(new Intent(context, LoginActivity.class));
        }
    }



    public void go2Message(View view) {
            context.startActivity(new Intent(context, MessageActivity.class));
    }


    public void go2UseHelp(View view) {
        context.startActivity(new Intent(context, UseHelpAcyivity.class));
    }


}
