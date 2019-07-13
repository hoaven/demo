package com.afei.camerademo.screenadaptation;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * author : wangyya
 * date   : 2019/3/29
 * 屏幕适配工具类
 * 三步走： 1.确定放大缩小比例
 *         2.确定参考屏幕密度
 *         3.确定相对屏幕密度并重新赋值给系统的像素密度
 */
public class ScreenUtil {
    private static float ORIGINAL_DENSITY = -1;  //原始屏幕密度比率

    /**
     * 重置屏幕密度
     */
    public static void resetDensity(Context context) {
        //绘制页面时参照的设计图尺寸
        final float DESIGN_WIDTH = 800f;
        final float DESIGN_HEIGHT = 1280f;
        final float DESTGN_INCH = 5.0f; //参考手机尺寸
        //大屏调节因子，范围0~1，因屏幕同比例放大视图显示非常傻大憨，用于调节感官度
        final float BIG_SCREEN_FACTOR = 0.8f;

        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        //确定放大缩小比率
        float rate = Math.min(dm.widthPixels, dm.heightPixels) / Math.min(DESIGN_WIDTH, DESIGN_HEIGHT);
        //确定参照屏幕密度比率
        float referenceDensity = (float) Math.sqrt(DESIGN_WIDTH * DESIGN_WIDTH + DESIGN_HEIGHT * DESIGN_HEIGHT) / DESTGN_INCH / DisplayMetrics.DENSITY_DEFAULT;
        //确定最终屏幕密度比率
        float relativeDensity = referenceDensity * rate;

        if (ORIGINAL_DENSITY == -1) {
            ORIGINAL_DENSITY = dm.density;
        }
        if (relativeDensity > ORIGINAL_DENSITY) {
            relativeDensity = ORIGINAL_DENSITY + (relativeDensity - ORIGINAL_DENSITY) * BIG_SCREEN_FACTOR;
        }
        dm.density = relativeDensity;
        dm.densityDpi = (int) (relativeDensity * DisplayMetrics.DENSITY_DEFAULT);
        dm.scaledDensity = relativeDensity;
    }

}
