package com.zs.douban.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartzheng on 2017/4/3.
 */

public class HomeTabsAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public HomeTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        //添加Fragment
        mFragments.add(fragment);
        //添加标题
        mFragmentTitles.add(title);
    }

    //返回viewpager 中每个条目展示的内容
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    //返回viewpager中一共要展示的条目
    @Override
    public int getCount() {
        //集合的大小
        return mFragments.size();

    }

    //返回内容对应的标题  标题的内容来自于mFragmentTitles 集合
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}
