package com.zs.douban.module.activity.home;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.zs.douban.R;
import com.zs.douban.module.fragment.movie.MovieFragment;
import com.zs.douban.module.fragment.music.MusicFragment;
import com.zs.douban.module.fragment.book.ReadFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends AppCompatActivity {
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.appbar)
    AppBarLayout mAppbar;
    @InjectView(R.id.main_content)
    CoordinatorLayout mMainContent;
    @InjectView(R.id.container)
    FrameLayout mContainer;
    @InjectView(R.id.nav_view)
    NavigationView mNavView;
    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.bottomBar)
    BottomBar mBottomBar;
    private int selectedTheme;
    private ArrayList<Fragment> fgmList;

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
        fgmList.add(new ReadFragment());
        fgmList.add(new MusicFragment());
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
            actionBar.setDisplayHomeAsUpEnabled(true);//TODO 含义
        }
    }

    /**
     * @param item
     * @return
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
        //设置
        if (mNavView != null) {
            mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }

    /**
     * 初始化主题菜单
     *
     * @param menu
     * @return
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
     * @param index
     */
    private void changeFgm(int index) {
        Fragment fragment = fgmList.get(index);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
