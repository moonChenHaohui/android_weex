package com.github.chenhaohui.weexandroid;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;


/**
 * Created by chenhaohui on 16/8/6.
 */
public class WXApplication extends Application {
    private static WXApplication application;

    public static synchronized WXApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        InitConfig config = new InitConfig.Builder().build();
        WXSDKEngine.initialize(this,config);
    }

}

