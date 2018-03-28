package com.zs.douban.view.activity.home;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zs.douban.R;
import com.zs.douban.view.fragment.movie.MovieFragment;
import com.zs.douban.view.fragment.music.MusicListFragment;
import com.zs.douban.view.fragment.read.ReadListFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends AutoLayoutActivity {
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.appbar)
    AppBarLayout mAppbar;
    @InjectView(R.id.main_content)
    CoordinatorLayout mMainContent;
    @InjectView(R.id.nav_view)
    NavigationView mNavView;
    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.bottomBar)
    BottomBar mBottomBar;
    private int selectedTheme;
    private ArrayList<Fragment> fgmList;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        initToolBar();
        initDrawer();
        initData();
        initBottomBar();
    }

    private void initData() {
        selectedTheme = 0;//sp中取出
        fgmList = new ArrayList<>();
        fgmList.add(new MovieFragment());
        fgmList.add(new ReadListFragment());
        fgmList.add(new MusicListFragment());
    }

    private void initBottomBar() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_movie:
                        changeFgm(0);
                        break;
                    case R.id.tab_read:
                        changeFgm(1);
                        break;
                    case R.id.tab_music:
                        changeFgm(2);
                        break;
                    default:
                        break;
                }

            }
        });
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * @return
     * @params item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置DrawerLayout侧滑菜单选择事件
     */
    private void initDrawer() {
        mNavView.getMenu().getItem(0).setChecked(true);
        //设置
        if (mNavView != null) {
            mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setChecked(true);
                    switch(item.getItemId()){
                        case R.id.nav_home:

                            break;
                        case R.id.nav_like:

                            break;
                        case R.id.nav_friends:

                            break;
                        case R.id.nav_setting:

                            break;
                        default:
                            break;
                    }
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }

    /**
     * 初始化主题菜单
     *
     * @return
     * @params menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme_menu, menu);
        switch (selectedTheme) {
            case 0:
                menu.getItem(0).setChecked(true);
                break;
            case 1:
                menu.getItem(1).setChecked(true);
                break;
            case 2:
                menu.getItem(2).setChecked(true);
                break;
            default:
                menu.getItem(0).setChecked(true);
                break;
        }
        return true;
    }

    /**
     * 点击bottombar切换fragment
     *
     * @params index
     */
    private void changeFgm(int index) {
        Fragment fragment = fgmList.get(index);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentFragment == null) {
            transaction.add(R.id.container, fragment).commit();
        } else if (mCurrentFragment != fragment) {
            if (!fragment.isAdded()) { // 先判断是否被add过
                transaction.hide(mCurrentFragment).add(R.id.container, fragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mCurrentFragment).show(fragment).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
        mCurrentFragment = fragment;
    }
}
