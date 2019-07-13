package com.afei.camerademo;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static MyApp app;

    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApp getInstance() {
        return app;
    }
}
