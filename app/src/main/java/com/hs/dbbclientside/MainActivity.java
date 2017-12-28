package com.hs.dbbclientside;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hs.dbbclientside.databinding.ActivityMainBinding;
import com.hs.dbbclientside.util.StatusBarUtils;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentTabHost tabhost;
    private FragmentManager mSupportFragmentManager;
    private MainViewModle viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题拦
        // setTheme(R.style.MainActivityTheme);//解决：You need to use a Theme.AppCompat theme (or descendant) with this activity.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        StatusBarUtils.setColor(this, Color.parseColor("#33000000"));
        //  binding.mainTestSkip.setText("去看一下我们例子！！！");
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mSupportFragmentManager = getSupportFragmentManager();
        viewModel = new MainViewModle(this,binding, mSupportFragmentManager, tabhost);
        binding.setViewModel(viewModel);
    }




    public void go2Example(View view) {




    }


}
