package day01.core4_groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import day01.core4_groupon.R;
import day01.core4_groupon.config.Constant;
import day01.core4_groupon.util.SharedPreFerencesUtil;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SharedPreFerencesUtil sharedPreFerencesUtil = new SharedPreFerencesUtil(this);
        //界面停留几秒钟
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (sharedPreFerencesUtil.isFirst()) {
                    //向新手指导页跳转
                    intent = new Intent(splashActivity.this,GuideActivity.class);
                    startActivity(intent);
                    sharedPreFerencesUtil.setFirst(false);
                    splashActivity.this.finish();
                } else {
                    //向主页面跳转
                    intent = new Intent(splashActivity.this,MainActivity.class);
                    startActivity(intent);
                    splashActivity.this.finish();
                }
            }
        }, 3000);
    }
}
