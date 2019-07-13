package com.afei.camerademo.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afei.camerademo.R;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableLift;


/**
 * RxJava中常见的变换操作符
 */
public class TransOperatorActivity extends AppCompatActivity {
    private static final String TAG = "Rxjava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        map();
    }

    /**
     * 变换操作符:Map() 对被观察者发送的每1个事件都通过指定的函数处理，从而变换成另外一种事件
     * 应用场景:数据类型转换
     * 例子:使用Map()将事件的参数从 整型 变换成 字符串类型
     */
    private void map(){
        ObservableLift.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {

            @Override
            public String apply(Integer integer) throws Exception {
                String res = "";
                if(integer==1){
                    res = "one";
                }else if(integer==2){
                    res = "two";
                }else if(integer==3){
                    res = "three";
                }

                return "使用 Map变换操作符 将事件" + integer +"的参数从 整型"+integer + " 变换成 字符串类型" + res ;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, s);
            }
        });
    }

    /**
     * 变换操作符:flatMap() 将被观察者发送的事件序列进行 拆分 & 单独转换，再合并成一个新的事件序列，最后再进行发送
     *
     */
    private void flatMap(){

    }
}
