package com.example.s960405s.modify;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import取得權限相關模組
import android.support.v4.app.ActivityCompat;
import static android.Manifest.permission.*;

public class LogoActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_READ_EXTERNAL_STORAGE = 2;
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 3;
    String[] PERMISSIONS = {CAMERA, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        // 取得使用者的權限
        int cameraPermission = ActivityCompat.checkSelfPermission(this, CAMERA);
        int readPermission = ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);
        int writePermission = ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);

        // (CAREMA)檢查有無權限，若無則向使用者要求權限
        if( cameraPermission != PackageManager.PERMISSION_GRANTED ){
            // 向使用者要求權限(context, 欲要求權限, 本次請求的辨識編號)
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS,
                    REQUEST_CAMERA);
        }

        // (READ_EXTERNAL_STORAGE)檢查有無權限，若無則向使用者要求權限
        if( readPermission != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS,
                    REQUEST_READ_EXTERNAL_STORAGE);
        }

        // (WRITE_EXTERNAL_STORAGE)檢查有無權限，若無則向使用者要求權限
        if( writePermission != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS,
                    REQUEST_WRITE_EXTERNAL_STORAGE);
        }
        else {
            new CountDownTimer(1500,1000){
                @Override
                public void onTick(long millisUntilFinished){}

                @Override
                public void onFinish(){
                    // 結束後跳轉到activity_main
                    // LogoActivity.this.setContentView(R.layout.activity_main);
                    Intent intent = new Intent();
                    intent.setClass(LogoActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }.start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case REQUEST_CAMERA:
                if( grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED ){
                    //展示Logo
                    new CountDownTimer(1500,1000){
                        @Override
                        public void onTick(long millisUntilFinished){}

                        @Override
                        public void onFinish(){
                            // 結束後跳轉到activity_main
                            // LogoActivity.this.setContentView(R.layout.activity_main);
                            Intent intent = new Intent();
                            intent.setClass(LogoActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }.start();
                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
