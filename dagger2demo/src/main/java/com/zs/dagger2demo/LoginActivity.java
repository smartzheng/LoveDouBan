package com.zs.dagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    //请求dagger2来提供依赖,这里模拟两个变量
    @LoginModule.QualifierA
    @Inject
    LoginPresenter mPresenter1;
    @LoginModule.QualifierB
    @Inject
    LoginPresenter mPresenter2;
    @InjectView(R.id.button1)
    Button mButton1;
    @InjectView(R.id.button2)
    Button mButton2;
    @InjectView(R.id.button3)
    Button mButton3;

    //表示由dagger2创建实例,@Inject可以只写一次（上面写了一次）
    @Inject
    public LoginActivity() {
        //利用dagger2生成的类来完成注入
        LoginComponent component = DaggerLoginComponent//
                .builder()//
                .loginModule(new LoginModule())//
                .build();
        component.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                showResult(mPresenter1.login("111", "111"));
                break;
            case R.id.button2:
                showResult(mPresenter2.login("222", "222"));
                break;
            case R.id.button3:
                showResult(mPresenter2.login("111", "111"));
                break;
        }
    }

    private void showResult(String result) {
        Toast toast = Toast.makeText(this, result, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 650);
        toast.show();
    }
}
