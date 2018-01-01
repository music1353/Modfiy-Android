package com.example.s960405s.modify;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.File;

import static java.lang.System.currentTimeMillis;

public class MainActivity extends AppCompatActivity {

    private static final int OPEN_CAMERA_CODE = 0000;
    private static final int OPEN_PHOTO_CODE = 1111;
    final String CACHE_IMG = Environment.getExternalStorageDirectory()+"/images/";
    private ImageButton ib_camera, ib_edit;
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewInit();

        ib_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        ib_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }
        });

    }

    // 綁定View
    private void findViewInit() {
        ib_camera = (ImageButton) findViewById(R.id.ib_camera);
        ib_edit = (ImageButton) findViewById(R.id.ib_edit);
    }

    // 開啟相機
    public void openCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, OPEN_CAMERA_CODE);
    }

    // 開啟相簿
    public void openAlbum() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        String fileName = currentTimeMillis()+".jpg";
        File file = new File(CACHE_IMG, fileName);

        Uri imageUri = FileProvider.getUriForFile(getApplicationContext(), "com.example.s960405s.modify.provider", file);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //加入flag

        startActivityForResult(intent, OPEN_PHOTO_CODE);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_BACK) {
            // 與上次點擊返回鍵時刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                // 大於2000ms則認為是誤操作，使用Toast進行提示
                Toast.makeText(this, "再按一次離開Modify", Toast.LENGTH_SHORT).show();
                // 並紀錄下本次點擊“返回键”的時刻，以便下次進行判斷
                mExitTime = System.currentTimeMillis();
            } else {
                // 小於2000ms則認為是用戶確實希望退出程序-調用System.exit()方法進行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == OPEN_CAMERA_CODE ) {
            if(resultCode==RESULT_OK){
                Uri uri = data.getData(); // 取得照片路徑uri

                Intent intent = new Intent(MainActivity.this, ModifyActivity.class);
                intent.setData(uri);

                startActivity(intent);
            }
        }
        else if( requestCode == OPEN_PHOTO_CODE ) {
            if(resultCode==RESULT_OK){
                Uri uri = data.getData(); // 取得照片路徑uri

                Intent intent = new Intent(MainActivity.this, ModifyActivity.class);
                intent.setData(uri);

                startActivity(intent);
            }
        }
    }




}
