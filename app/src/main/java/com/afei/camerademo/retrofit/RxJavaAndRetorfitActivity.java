package com.afei.camerademo.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afei.camerademo.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxJavaAndRetorfitActivity extends AppCompatActivity {
    private static final String TAG = "Rxjava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_and_retorfit);

        //1.步骤1：采用interval（）延迟发送
        // 注：此处主要展示无限次轮询，若要实现有限次轮询，仅需将interval()改成intervalRange()即可
        //该例子发送的事件特点：延迟2s后发送事件，每隔1秒产生1个数字（从0开始递增1，无限个）
        Observable.interval(2,1, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() { //步骤2：每次发送数字前发送1次网络请求（doOnNext()在执行Next事件前调用）即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "第 " + aLong + " 次轮询" );

                        //步骤3：通过Retrofit发送网络请求
                        //步骤3-1：创建Retrofit对象
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://fy.iciba.com/") //设置网络请求 Url
                                .addConverterFactory(GsonConverterFactory.create())  //设置使用Gson解析
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //支持RxJava
                                .build();

                        //步骤3-2：创建 网络请求接口的实例
                        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

                        //步骤3-3：采用Observable<...>形式 对 网络请求 进行封装
                        Observable<Translation> observable = request.getCall();

                        //步骤3-4：通过线程切换发送网络请求
                        observable.subscribeOn(Schedulers.io())  //切换到IO线程进行网络请求
                                .observeOn(AndroidSchedulers.mainThread()) //切换回到主线程 处理请求结果
                                .subscribe(new Observer<Translation>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Translation value) {
                                        //步骤3-5：接收服务器返回的数据
                                        value.show() ;
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.d(TAG, "请求失败");
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });

                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long value) {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }
}
