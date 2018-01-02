package com.hs.dbbclientside.module.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hs.dbbclientside.MainActivity;
import com.hs.dbbclientside.base.BaseParams;
import com.hs.dbbclientside.util.SPUtil;

/**
 * 作者：zhanghaitao on 2018/1/2 15:41
 * 邮箱：820159571@qq.com
 *
 * @describe:
 */

public class SplashActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                go2Activity();
//            }
//        },300);//为了使效果更加明显

        go2Activity();

    }

    private void go2Activity() {

        boolean isFirst = SPUtil.getBoolean(BaseParams.IS_FIRST_IN, true);
        if(isFirst){//
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
            SPUtil.setValue(BaseParams.IS_FIRST_IN,false);
        }else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SPUtil.setValue(BaseParams.IS_FIRST_IN,true);
        }
        finish();
    }
}
