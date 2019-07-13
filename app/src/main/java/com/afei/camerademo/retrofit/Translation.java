package com.afei.camerademo.retrofit;

import android.util.Log;

/**
 * author : wangyya
 * date   : 2019/7/10
 */
public class Translation {
    private int status;

    private Content content;
    private static class Content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        Log.d("Rxjava", content.out );
    }
}
