package com.afei.camerademo.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afei.camerademo.R;

public class BaseObservableTest extends AppCompatActivity {
    private Goods goods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_observable_test);
//         com.afei.camerademo.databinding binding=DataBindingUtil.setContentView(this,R.layout.activity_base_observable_test);

        goods = new Goods("code", "hi", 24);
//        binding.
    }
}
