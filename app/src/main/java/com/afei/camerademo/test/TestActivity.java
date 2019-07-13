package com.afei.camerademo.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afei.camerademo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestActivity extends AppCompatActivity {
    private String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        int [] data = new int[]{2,4,7,8,9,10};
//        search(data,7);
//        search(data,12);

//        String s1 = "ab";
//        String s2 = "ab";
//        Log.e(TAG,"String "+(s1==s2));
//
//        Integer i1 = 10;
//        Integer i2 = 10;
//        Log.e(TAG,"Integer "+(i1==i2));
//
//        boolean b1 = false;
//        boolean b2 = false;
//        Log.e(TAG,"boolean "+(b1==b2));
//
//        Double d1 = 1.20;
//        Double d2 = 1.20;
//        Log.e(TAG,"Double "+(d1==d2));


    }


    /**
     * 二分查找
     * @param data 有序数列
     * @param key 待查找的数
     * @return 找到就返回index ，找不到返回-1
     */
    private int search(int [] data,int key){
        int left = 0, right = data.length-1, middle = (left+right)/2;

        while (left<=right){
            if(data[middle] == key){
                Log.e(TAG,key+"在第"+middle+"位");
                return middle;
            }else if(data[middle] > key){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }

        return -1;
    }

//    private void maxSum(int []data){
//        int max = data[0];
//        for(int i=0;i<data.length;i++){
//
//        }
//    }

}
