package com.example.asus_cp.mingli.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by asus-cp on 2016-04-29.
 */
public class MyApplication extends Application {
    private static Context context;

    /**
     * 一定要在oncreate（）方法里面获取
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
