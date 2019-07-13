package com.afei.camerademo.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.afei.camerademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HandleTestActivity extends AppCompatActivity {
    @BindView(R.id.show)
     TextView tvShow;
    public Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_test);
        ButterKnife.bind(this);

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        tvShow.setText("执行了线程1的UI操作"+msg.obj);
                        break;
                    case 2:
                        tvShow.setText("执行了线程2的UI操作"+msg.obj);
                        break;
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 步骤3：创建所需的消息对象
                Message msg = Message.obtain();
                msg.what = 1; // 消息标识
                msg.obj = "A"; // 消息内存存放

                // 步骤4：在工作线程中 通过Handler发送消息到消息队列中
                mHandler.sendMessage(msg);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 步骤3：创建所需的消息对象
                Message msg = Message.obtain();
                msg.what = 2; // 消息标识
                msg.obj = "B"; // 消息内存存放

                // 步骤4：在工作线程中 通过Handler发送消息到消息队列中
                mHandler.sendMessage(msg);
            }
        }).start();
    }
}
