package com.hs.dbbclientside.module.guide;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hs.dbbclientside.MainActivity;
import com.hs.dbbclientside.MyApplication;
import com.hs.dbbclientside.R;
import com.hs.dbbclientside.databinding.ActivityGuideBinding;

/**
 * 作者：zhanghaitao on 2018/1/2 13:18
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class GuideViewModel {

    private Context context;
    private ActivityGuideBinding binding;

    private int[] guidePicture = {
            R.drawable.yd_bg_01,
            R.drawable.yd_bg_02,
            R.drawable.yd_bg_03,
    };


    public GuideViewModel(Context context, ActivityGuideBinding binding) {
        this.context = context;
        this.binding = binding;
        initViewPager();
    }

    private void initViewPager() {
        binding.guideViewpager.setAdapter(new MyAdapter());
        binding.guideViewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2) {
                    binding.guideBtn.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void go2Main(View view) {
        context.startActivity(new Intent(context, MainActivity.class));
        MyApplication.destoryActivity("GuideActivity");
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return guidePicture.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView view = new ImageView(context);
            view.setImageResource(guidePicture[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            view.setLayoutParams(lp);

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

}
