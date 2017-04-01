package com.zs.dagger2demo;

import javax.inject.Inject;

/**
 * Created by zhengshuai on 2017/4/1.
 */

public class LoginPresenter {
    private int code;
    //表示由dagger2创建实例
    @Inject
    public LoginPresenter(int code) {
        this.code=code;
    }

    public String login(String userName, String PassWord) {
        if ("111".equals(userName) && "111".equals(PassWord)&&code==100) {
            return "success\n"+"code:"+code+"\nuserName:"+userName+"\npsd:"+PassWord;
        } else {
            return "failed \n"+"code:"+code+"\nuserName:"+userName+"\npsd:"+PassWord;
        }
    }
}
