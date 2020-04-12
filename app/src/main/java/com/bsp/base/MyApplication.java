package com.bsp.base;

import android.app.Application;

import com.bsp.base.util.AndroidUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidUtil.init(this);
    }
}
