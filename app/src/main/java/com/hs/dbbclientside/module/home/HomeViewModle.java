package com.hs.dbbclientside.module.home;

import android.text.TextUtils;

import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.FragmentHomeBinding;
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

public class HomeViewModle {

    private FragmentHomeBinding binding;

    public HomeViewModle(FragmentHomeBinding binding) {
        this.binding = binding;
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
        binding.homeBanner.setPages(
                new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView() {
                            @Override
                            protected void itemOnClick(int position) {
                                if (!TextUtils.isEmpty(bannerList.get(position).getLink())) {
                                    //link 不为空时跳转

                                }else {
                                    ToastUtil.showToast("链接为空，请勿点击！！！"+position);
                                }
                            }
                        };
                    }
                }, bannerImages)
                // 设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused});
    }






}
