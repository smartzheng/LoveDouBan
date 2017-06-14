package com.zs.douban.view.fragment.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.adapter.HomeTabsAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by smartzheng on 2017/4/3.
 *
 */

public class MovieFragment extends Fragment {
    @InjectView(R.id.tabLayout)
    TabLayout mTabLayout;
    @InjectView(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie,null);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager(mViewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    private void setupViewPager(ViewPager viewPager) {
        if (getActivity() != null) {
            //创建了一个viewpager的数据适配器
            HomeTabsAdapter adapter = new HomeTabsAdapter(getChildFragmentManager());
            //Fragment作为viewpager 要展示的内容
            MovieListListFragment hotFragment =  MovieListListFragment.getInstance(0);
            MovieListListFragment comingFragment = MovieListListFragment.getInstance(1);
            MovieListListFragment topFragment = MovieListListFragment.getInstance(2);
            adapter.addFragment(hotFragment, "正在热映");
            adapter.addFragment(comingFragment, "即将上映");
            adapter.addFragment(topFragment, "Top250");
            //给viewpager设置数据适配器  viewpager的内容就显示出来 了
            viewPager.setOffscreenPageLimit(3);
            viewPager.setAdapter(adapter);
            mTabLayout.setupWithViewPager(viewPager);
        }
    }
}
