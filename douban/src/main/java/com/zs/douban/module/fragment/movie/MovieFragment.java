package com.zs.douban.module.fragment.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zs.douban.R;
import com.zs.douban.module.adapter.HomeTabsAdapter;
import com.zs.douban.module.fragment.movie.coming.ComingFragment;
import com.zs.douban.module.fragment.movie.hot.HotFragment;
import com.zs.douban.module.fragment.movie.top.TopFragment;

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
        ButterKnife.reset(this);
    }
    private void setupViewPager(ViewPager viewPager) {
        if (getActivity() != null) {
            //创建了一个viewpager的数据适配器
            HomeTabsAdapter adapter = new HomeTabsAdapter(getActivity().getSupportFragmentManager());
            //Fragment作为viewpager 要展示的内容
            adapter.addFragment(new HotFragment(), "正在热映");
            adapter.addFragment(new ComingFragment(), "即将上演");
            adapter.addFragment(new TopFragment(), "Top250");
            //给viewpager设置数据适配器  viewpager的内容就显示出来 了
            viewPager.setAdapter(adapter);
            mTabLayout.setupWithViewPager(viewPager);
        }
    }
}
