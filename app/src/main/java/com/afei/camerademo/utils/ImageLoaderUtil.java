package com.afei.camerademo.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

public class ImageLoaderUtil {
    private LruCache<String, Bitmap> lruCache;

    public ImageLoaderUtil() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.e("ImageLoaderUtil",maxMemory+","+maxMemory/1024);
        int cacheSize = maxMemory / 8;
        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                /*getRowBytes：Since API Level 1，用于计算位图每一行所占用的内存字节数。
                getByteCount：Since API Level 12，用于计算位图所占用的内存字节数。
                经实测发现：getByteCount() = getRowBytes() * getHeight()，也就是说位图所占用的内存空间数等于位图的每一行所占用的空间数乘以位图的行数。
                因为getByteCount要求的API版本较高，因此对于使用较低版本的开发者，在计算位图所占空间时上面的方法或许有帮助。*/
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void addBitmap(String key, Bitmap bitmap) {
        if (getBitmap(key) == null) {
        /*put() 方法其实重点就在于 trimToSize() 方法里面，这个方法的作用就是判断加入元素后是否超过最大缓存数，
        如果超过就清除掉最少使用的元素。*/
            lruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmap(String key) {
        return lruCache.get(key);
    }
}
