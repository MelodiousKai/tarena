package day01.core4_groupon.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import day01.core4_groupon.fragment.Guide1Fragment;
import day01.core4_groupon.fragment.Guide2Fragment;
import day01.core4_groupon.fragment.Guide3Fragment;
import day01.core4_groupon.fragment.Guide4Fragment;

/**
 * Created by tarena on 2017/6/15.
 */

public class GuideFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new Guide1Fragment());
        fragments.add(new Guide2Fragment());
        fragments.add(new Guide3Fragment());
        fragments.add(new Guide4Fragment());
    }


    //获得一个fragment添加到集合中
    public void addFragment(Fragment fragment){
        if (fragments!=null){
            //给空间额添加数据
            fragments.add(fragment);
            //刷新界面
            notifyDataSetChanged();
        }
    }

    //从集合中获得一个适配项(取得需要添加的界面)
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //返回需要添加数据的个数(需要显示的界面个数
    @Override
    public int getCount() {
        return fragments!=null? fragments.size():0;
    }
}
