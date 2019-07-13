package com.afei.camerademo.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afei.camerademo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Rxjava创建操作符
 * Rxjava，由于其基于事件流的链式调用、逻辑简洁 & 使用简单的特点，深受各大 Android开发者的欢迎
 */
public class RxjavaTestActivity extends AppCompatActivity {
    private static final String TAG = "Rxjava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_test);

//        rangeLong();
    }

    /**
     * 操作符:create（）完整创建1个被观察者对象（Observable）,RxJava 中创建被观察者对象最基本的操作符
     */
    private void create() {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "开始采用subscribe连接");

                //可采用 Disposable.dispose() 切断观察者 与 被观察者 之间的连接,即观察者 无法继续 接收 被观察者的事件，但被观察者还是可以继续发送事件
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "对Next事件" + value + "作出响应");
                if (value == 2) {
                    mDisposable.dispose();
                }
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

    /**
     * 操作符:just（） 快速创建1个被观察者对象（Observable）,送事件的特点：直接发送 传入的事件s
     */
    private void just() {
        Observable.just(1, 2, 3, 4).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 操作符:fromArray() 快速创建1个被观察者对象（Observable）,直接发送 传入的数组数据
     */
    private void fromArray() {
        Integer[] items = {0, 1, 2, 3, 4};
        Observable.fromArray(items).safeSubscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 操作符:fromIterable() 快速创建1个被观察者对象（Observable）,直接发送 传入的集合List数据
     */
    private void fromIterable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Observable.fromIterable(list).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 下列方法一般用于测试使用
     * <-- empty()  -->
     * 该方法创建的被观察者对象发送事件的特点：仅发送Complete事件，直接通知完成
     * Observable observable1=Observable.empty();
     * 即观察者接收后会直接调用onCompleted（）
     *
     * <-- error()  -->
     * 该方法创建的被观察者对象发送事件的特点：仅发送Error事件，直接通知异常, 可自定义异常
     * Observable observable2=Observable.error(new RuntimeException())
     * 即观察者接收后会直接调用onError（）
     *
     * <-- never()  -->
     * 该方法创建的被观察者对象发送事件的特点：不发送任何事件
     * Observable observable3=Observable.never();
     * 即观察者接收后什么都不调用
     */


    /**
     * 延迟创建操作符:defer()，直到有观察者（Observer ）订阅时，才动态创建被观察者对象（Observable） & 发送事件，
     * 每次订阅后，都会得到一个刚创建的最新的Observable对象，这可以确保Observable对象里的数据是最新的
     */
    Integer i = 10;

    private void defer() {
        final Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });

        i = 20;
        //观察者开始订阅,此时，才会调用defer（）创建被观察者对象（Observable）
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                //接收到了事件20;
                Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 延迟创建操作符:timer(),延迟指定时间后，调用一次 onNext(0),延迟指定事件，发送一个0，一般用于检测
     * timer操作符默认运行在一个新线程上,也可自定义线程调度器（第3个参数）：timer(long,TimeUnit,Scheduler)
     */
    private void timer() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Long value) {
                        Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 延迟创建操作符:interval(),每隔指定时间就发送事件,发送的事件序列 = 从0开始、无限递增1的的整数序列
     * interval默认在computation调度器上执行,也可自定义指定线程调度器（第3个参数）：interval(long,TimeUnit,Scheduler)
     */
    private void interval() {
        // 参数1 = 第1次延迟时间;参数2 = 间隔时间数字;参数3 = 时间单位；
        Observable.interval(3, 1, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Long value) {
                Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 延迟创建操作符:intervalRange()，每隔指定时间就发送事件，可指定发送的数据的数量
     * 发送的事件序列 = 从0开始、无限递增1的的整数序列
     * 作用类似于interval()，但可指定发送的数据的数量
     */
    private void intervalRange() {
        // 参数1 = 事件序列起始点;参数2 = 事件数量;参数3 = 第1次事件延迟发送时间;参数4 = 间隔时间数字;参数5 = 时间单位
        Observable.intervalRange(3, 10, 2, 1, TimeUnit.SECONDS)
                // 该例子发送的事件序列特点：
                // 1. 从3开始，一共发送10个事件；
                // 2. 第1次延迟2s发送，之后每隔2秒产生1个数字（从0开始递增1，无限个）
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }
                    // 默认最先调用复写的 onSubscribe（）

                    @Override
                    public void onNext(Long value) {
                        Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 延迟创建操作符:range(),连续发送 1个事件序列，可指定范围
     * 作用类似于intervalRange（），但区别在于：无延迟发送事件
     */
    private void range() {
        Observable.range(3, 10).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "接收到了事件" + value);
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

    /**
     * 类似于range()，区别在于该方法支持数据类型 = Long
     */
    private void rangeLong() {
        Observable.rangeLong(1234567898, 10).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Long value) {
                Log.d(TAG, "接收到了事件" + value);
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

