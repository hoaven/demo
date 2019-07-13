package com.afei.camerademo.tbstest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.afei.camerademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author : wangyya
 * date   : 2019/5/7
 */
public class TBSActivity extends Activity{
    @BindView(R.id.leftBtn)
    RelativeLayout leftBtn;
    @BindView(R.id.tbsView)
    FrameLayout tbsView;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbs);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
    }

    @OnClick({R.id.leftBtn})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.leftBtn:
                finish();
                break;
        }
    }
}
