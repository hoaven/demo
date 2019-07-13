package com.afei.camerademo.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afei.camerademo.R;

public class DatabindingTest extends AppCompatActivity {
    private com.afei.camerademo.databinding.ActivityDatabindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
         UserInfo userInfo = new UserInfo("彭于晏","男");
         binding.setUserInfo(userInfo);

    }
}
