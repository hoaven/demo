package com.afei.camerademo.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.afei.camerademo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.btn_first_event)
    Button btn_first_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_first_event})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_first_event:
                EventBus.getDefault().post(new MessageEvent("点击了SecondActivity的按钮"));
                finish();
                break;
        }
    }

}
