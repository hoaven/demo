package com.afei.camerademo.surfaceview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.afei.camerademo.ImageUtils;
import com.afei.camerademo.R;
import com.afei.camerademo.camera.CameraProxy;

public class SurfaceCameraActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SurfaceCameraActivity";

    private ImageView mCloseIv;
    private ImageView mSwitchCameraIv;
    private ImageView mTakePictureIv;
    private ImageView mPictureIv;
    private CameraSurfaceView mCameraView;
    private CameraProxy mCameraProxy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_camera);
        initView();
    }

    private void initView() {
        mCloseIv = findViewById(R.id.toolbar_close_iv);
        mCloseIv.setOnClickListener(this);
        mSwitchCameraIv = findViewById(R.id.toolbar_switch_iv);
        mSwitchCameraIv.setOnClickListener(this);
        mTakePictureIv = findViewById(R.id.take_picture_iv);
        mTakePictureIv.setOnClickListener(this);
        mPictureIv = findViewById(R.id.picture_iv);
        mPictureIv.setOnClickListener(this);
        mPictureIv.setImageBitmap(ImageUtils.getLatestThumbBitmap());
        mCameraView = findViewById(R.id.camera_view);
        mCameraProxy = mCameraView.getCameraProxy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_close_iv:
                finish();
                break;
            case R.id.toolbar_switch_iv:
                mCameraProxy.switchCamera();
                mCameraProxy.startPreview(mCameraView.getHolder());
                break;
            case R.id.take_picture_iv:
                mCameraProxy.takePicture(mPictureCallback);
                break;
            case R.id.picture_iv:
//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_VIEW, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
                break;
        }
    }

    private final Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            mCameraProxy.startPreview(mCameraView.getHolder()); // 拍照结束后继续预览
            new ImageSaveTask().execute(data); // 保存图片
        }
    };

    private class ImageSaveTask extends AsyncTask<byte[], Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(byte[]... bytes) {
            long time = System.currentTimeMillis();
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes[0], 0, bytes[0].length);
            Log.d(TAG, "BitmapFactory.decodeByteArray time: " + (System.currentTimeMillis() - time));
            int rotation = mCameraProxy.getLatestRotation();
            time = System.currentTimeMillis();
            Bitmap rotateBitmap = ImageUtils.rotateBitmap(bitmap, rotation, mCameraProxy.isFrontCamera(), true);
            Log.d(TAG, "rotateBitmap time: " + (System.currentTimeMillis() - time));
            time = System.currentTimeMillis();

            drawWarterMark(rotateBitmap);

            Log.d(TAG, "saveBitmap time: " + (System.currentTimeMillis() - time));
            return ImageUtils.getLatestThumbBitmap();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mPictureIv.setImageBitmap(bitmap);
        }
    }

    private void drawWarterMark(final Bitmap bitmap){
        new Thread(new Runnable() {
            @Override
            public void run() {

                Bitmap bitmap_1 = ImageUtils.drawTextToLeftTop(getApplicationContext(), bitmap,"09:58", 22, Color.WHITE, 30, 27);
                Bitmap bitmap_2 = ImageUtils.drawTextToLeftTop(getApplicationContext(), bitmap_1, "2019/03/13"+" "+"星期三", 14, Color.WHITE, 30, 50);
                Bitmap bitmap_3 = ImageUtils.drawTextToRightBottom(getApplicationContext(), bitmap_2, "张小三" + " " + "DPMS", 10, Color.WHITE, 3, 46);
                Bitmap bitmap_4 = ImageUtils.drawTextToRightBottom(getApplicationContext(), bitmap_3, "上海市长宁区虹桥路2451号", 10, Color.WHITE, 3, 28);
                Bitmap bitmap_5 = ImageUtils.drawTextToRightBottom(getApplicationContext(), bitmap_4, "格林东方上海虹桥机场龙柏店(原日航龙柏饭店)", 10, Color.WHITE, 3, 10);
                ImageUtils.saveBitmap(bitmap_5);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPictureIv.setImageBitmap(ImageUtils.getLatestThumbBitmap());
                    }
                });

                bitmap_1.recycle();
                bitmap_2.recycle();
                bitmap_3.recycle();
                bitmap_4.recycle();
                bitmap_5.recycle();
                bitmap.recycle();
            }
        }).start();

    }
}
