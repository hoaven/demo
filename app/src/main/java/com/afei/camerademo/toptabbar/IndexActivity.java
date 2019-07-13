package com.afei.camerademo.toptabbar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afei.camerademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout)
   TabLayout mTabLayout;
    @BindView(R.id.viewPager)
   ViewPager mViewPager;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private TabLayout.Tab five;
    private TabLayout.Tab six;
    private TabLayout.Tab seven;
    private TabLayout.Tab eight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);

        //初始化视图
        initViews();
    }
    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);
        five = mTabLayout.getTabAt(4);
        six = mTabLayout.getTabAt(5);
        seven = mTabLayout.getTabAt(6);
        eight = mTabLayout.getTabAt(7);

        IndicatorUtil.reflex(mTabLayout);

    }
}
