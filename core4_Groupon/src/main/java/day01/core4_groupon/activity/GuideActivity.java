package day01.core4_groupon.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import day01.core4_groupon.R;
import day01.core4_groupon.adapter.GuideFragmentAdapter;
import day01.core4_groupon.fragment.Guide1Fragment;
import day01.core4_groupon.fragment.Guide2Fragment;
import day01.core4_groupon.fragment.Guide3Fragment;
import day01.core4_groupon.fragment.Guide4Fragment;

public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.guideActivity_ViewPager)
    ViewPager viewPager;

    @BindView(R.id.guide_indicator)
    CirclePageIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initialUI();
    }

    private void initialUI() {
        GuideFragmentAdapter adapter = new GuideFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        //当前运行程序所使用的设备的屏幕密度
        //低密度 ldpi  120px/1inch(2.54cm)
        //中密度 mdpi  160px/1inch
        //高密度 hdpi  240px/1inch
        //很高密度 xhdpi 320px/1inch
        //非常高密度 xxhdpi 480px/1inch

        //dp绝对单位 160dp= 1inch
        //1dp 在低密度屏幕上 0.75px
        //1dp 在中密度屏幕上 1px
        //1dp 在高密度屏幕上 1.5px
        //1dp 在很高密度屏幕上 2px
        //1dp 在非常高密度屏幕上 3px

        //另外一种获得10dp在当前设备屏幕密度上的像素值的方式
        //float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics());

        //当前运行程序所使用的设备的屏幕密度
        final float density = getResources().getDisplayMetrics().density;
        //10dp在当前设备上所对应的像素值(px)
        //indicator.setBackgroundColor(0xFFffff);//背景
        indicator.setRadius(6 * density);
        indicator.setPageColor(0xffffff);
        indicator.setFillColor(0xFFff6633);
        indicator.setStrokeColor(0xFFff6633);
        indicator.setStrokeWidth(1 * density);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //NO_OP
            }

            @Override
            public void onPageSelected(int position) {
                if(position==3){
                    indicator.setVisibility(View.INVISIBLE);
                }else {
                    indicator.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //NO_OP
            }
        });

    }




}
