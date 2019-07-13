package com.afei.camerademo.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afei.camerademo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.btn_try)
    Button btnTry;
    @BindView(R.id.tv_txt)
    TextView tv_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        //注册EventBus
        EventBus.getDefault().register(this);

    }

    @OnClick({R.id.btn_try})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_try:
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * POSTING (默认)  表示事件处理函数的线程跟发布事件的线程在同一个线程。
     MAIN 表示事件处理函数的线程在主线程(UI)线程，因此在这里不能进行耗时操作。
     BACKGROUND 表示事件处理函数的线程在后台线程，因此不能进行UI操作。如果发布事件的线程是主线程(UI线程)，那么事件处理函数将会开启一个后台线程，如果果发布事件的线程是在后台线程，那么事件处理函数就使用该线程。
     ASYNC 表示无论事件发布的线程是哪一个，事件处理函数始终会新建一个子线程运行，同样不能进行UI操作。

     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThead(MessageEvent event){
        String msg = "FirstActivity收到了消息：" + event.getMessage();
        tv_txt.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

//    @Subscribe(threadMode = ThreadMode.POSTING)
//    public void onMessageEventPostThread(MessageEvent messageEvent) {
//        Log.e("POSTING", Thread.currentThread().getName());
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEventMainThread(MessageEvent messageEvent) {
//        Log.e("MAIN", Thread.currentThread().getName());
//    }
//
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onMessageEventBackgroundThread(MessageEvent messageEvent) {
//        Log.e("BACKGROUND", Thread.currentThread().getName());
//    }
//
//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    public void onMessageEventAsync(MessageEvent messageEvent) {
//        Log.e("ASYNC", Thread.currentThread().getName());
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
