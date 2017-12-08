package com.zs.douban.view.activity.detail;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.zs.douban.R;
import com.zs.douban.customview.media.AndroidMediaController;
import com.zs.douban.customview.media.IjkVideoView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MoviePlayActivity extends AppCompatActivity {
    @InjectView(R.id.video_view)
    IjkVideoView mVideoView;
    @InjectView(R.id.toast_text_view)
    TextView mToastTextView;
    @InjectView(R.id.hud_view)
    TableLayout mHudView;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.right_drawer)
    FrameLayout mRightDrawer;
    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private boolean mBackPressed;
    private static final int SIZE_DEFAULT = 0;
    private static final int SIZE_4_3 = 1;
    private static final int SIZE_16_9 = 2;
    private int currentSize = SIZE_16_9;
    private int screenHeight;
    private int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_play);
        ButterKnife.inject(this);
        initToolBar();
        initPlayer();
        play();
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getIntent().getStringExtra("title"));
        }
    }

    //
    private void initPlayer() {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mVideoView.setHudView(mHudView);
        AndroidMediaController controller = new AndroidMediaController(this, false);
        mVideoView.setMediaController(controller);
    }

    private void play() {
        String url = getIntent().getStringExtra("url");
        mVideoView.setVideoURI(Uri.parse(url));
        mVideoView.start();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;

        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mBackPressed || !mVideoView.isBackgroundPlayEnabled()) {
            mVideoView.stopPlayback();
            mVideoView.release(true);
            mVideoView.stopBackgroundPlay();
        } else {
            mVideoView.enterBackground();
        }
        IjkMediaPlayer.native_profileEnd();
    }

    //横竖屏检测切换
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //重新获取屏幕宽高
        initScreenInfo();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {//切换为横屏
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mVideoView.getLayoutParams();
            lp.height = screenHeight;
            lp.width = screenWidth;
            mVideoView.setLayoutParams(lp);
        } else {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mVideoView.getLayoutParams();
            lp.height = screenWidth * 9 / 16;
            lp.width = screenWidth;
            mVideoView.setLayoutParams(lp);
        }
        setScreenRate(currentSize);
    }

    //初始化屏幕配置信息
    private void initScreenInfo() {
        WindowManager wm = this.getWindowManager();
        screenWidth = wm.getDefaultDisplay().getWidth();
        screenHeight = wm.getDefaultDisplay().getHeight();
    }

    //设置视频播放比例
    public void setScreenRate(int rate) {
        int width = 0;
        int height = 0;
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {// 横屏
            if (rate == SIZE_DEFAULT) {
                width = mVideoView.getmVideoWidth();
                height = mVideoView.getmVideoHeight();
            } else if (rate == SIZE_4_3) {
                width = screenHeight / 3 * 4;
                height = screenHeight;
            } else if (rate == SIZE_16_9) {
                width = screenHeight / 9 * 16;
                height = screenHeight;
            }
        } else { //竖屏
            if (rate == SIZE_DEFAULT) {
                width = mVideoView.getmVideoWidth();
                height = mVideoView.getmVideoHeight();
            } else if (rate == SIZE_4_3) {
                width = screenWidth;
                height = screenWidth * 3 / 4;
            } else if (rate == SIZE_16_9) {
                width = screenWidth;
                height = screenWidth * 9 / 16;
            }
        }
        if (width > 0 && height > 0) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mVideoView.getmRenderView().getView().getLayoutParams();
            lp.width = width;
            lp.height = height;
            mVideoView.getmRenderView().getView().setLayoutParams(lp);
        }
    }

    //手动切换
    private void fullChangeScreen() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {// 切换为竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
