package com.afei.camerademo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.afei.camerademo.databinding.DatabindingTest;
import com.afei.camerademo.eventbus.FirstActivity;
import com.afei.camerademo.glsurfaceview.GLSurfaceCamera2Activity;
import com.afei.camerademo.glsurfaceview.GLSurfaceCameraActivity;
import com.afei.camerademo.handler.HandleTestActivity;
import com.afei.camerademo.recyclerview.RecyclerviewActivity;
import com.afei.camerademo.retrofit.RxJavaAndRetorfitActivity;
import com.afei.camerademo.rxjava.RxjavaTestActivity;
import com.afei.camerademo.rxjava.TransOperatorActivity;
import com.afei.camerademo.statusbarutil.StatusBarMainActivity;
import com.afei.camerademo.surfaceview.SurfaceCamera2Activity;
import com.afei.camerademo.surfaceview.SurfaceCameraActivity;
import com.afei.camerademo.tbstest.TBSActivity;
import com.afei.camerademo.test.TestActivity;
import com.afei.camerademo.textureview.TextureCamera2Activity;
import com.afei.camerademo.textureview.TextureCameraActivity;
import com.afei.camerademo.textview.TextViewDemo;
import com.afei.camerademo.toptabbar.IndexActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
    }

    public void startCameraActivity(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.camera_btn1:
                intent = new Intent(this, SurfaceCameraActivity.class);
                break;
            case R.id.camera_btn2:
                intent = new Intent(this, TextureCameraActivity.class);
                break;
            case R.id.camera_btn3:
                intent = new Intent(this, GLSurfaceCameraActivity.class);
                break;
            case R.id.camera_btn4:
                intent = new Intent(this, SurfaceCamera2Activity.class);
                break;
            case R.id.camera_btn5:
                intent = new Intent(this, TextureCamera2Activity.class);
                break;
            case R.id.camera_btn6:
                intent = new Intent(this, GLSurfaceCamera2Activity.class);
                break;
            case R.id.textview_btn:
                intent = new Intent(this, TextViewDemo.class);
                break;
            case R.id.eventbus_btn:
                intent = new Intent(this, FirstActivity.class);
                break;
            case R.id.handle_btn:
                intent = new Intent(this, HandleTestActivity.class);
                break;
            case R.id.tablayout_btn:
                intent = new Intent(this, IndexActivity.class);
                break;
            case R.id.statusbar_btn:
                intent = new Intent(this, StatusBarMainActivity.class);
                break;
            case R.id.tbs_btn:
                intent = new Intent(this, TBSActivity.class);
                break;
            case R.id.test_btn:
                intent = new Intent(this, TestActivity.class);
                break;
            case R.id.recyclerview:
                intent = new Intent(this, RecyclerviewActivity.class);
                break;
            case R.id.rxjava_btn:
                intent = new Intent(this, RxjavaTestActivity.class);
                break;
            case R.id.retorfit_btn:
                intent = new Intent(this, RxJavaAndRetorfitActivity.class);
                break;
            case R.id.trans_operator_btn:
                intent = new Intent(this, TransOperatorActivity.class);
                break;
            case R.id.databinding_btn:
                intent = new Intent(this, DatabindingTest.class);
                break;
        }
        startActivity(intent);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, permissions, 200);
                    return;
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && requestCode == 200) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "请在设置中打开摄像头和存储权限", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivityForResult(intent, 200);
                    return;
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 200) {
            checkPermission();
        }
    }

}