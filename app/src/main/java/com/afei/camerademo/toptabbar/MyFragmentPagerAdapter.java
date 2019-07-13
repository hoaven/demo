package com.afei.camerademo.toptabbar;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author : wangyya
 * date   : 2019/4/2
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"关注", "推荐", "热点","娱乐","游戏", "NBA", "图片社","体育"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Fragment2();
        } else if (position == 2) {
            return new Fragment3();
        }else if (position==3){
            return new Fragment4();
        }else if (position==4){
            return new Fragment5();
        }else if (position==5){
            return new Fragment6();
        }else if (position==6){
            return new Fragment7();
        }else if (position==7){
            return new Fragment8();
        }

        return new Fragment1();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
