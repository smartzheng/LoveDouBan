package com.zs.douban.view.activity.home;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zs.douban.R;

public class LaunchActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Glide.with(this).load(R.drawable.ic_movie).into((ImageView) findViewById(R.id.iv_menu));
    }
}
