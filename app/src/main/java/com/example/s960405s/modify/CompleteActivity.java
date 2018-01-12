package com.example.s960405s.modify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.getbase.floatingactionbutton.FloatingActionButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CompleteActivity extends AppCompatActivity {

    Bitmap bitmap;
    private ImageView iv_completeImage;
    private Toolbar tb_nav;
    private FloatingActionButton fab_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        initFindView();

        initToolbar();

        Uri uri = getIntent().getData(); // get image uri
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            iv_completeImage.setImageBitmap(bitmap);
            cleanTempImage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        fab_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    saveImage(getApplicationContext(), bitmap);
                    showToast("儲存成功");
                } catch (Exception e){
                    saveImage(getApplicationContext(), bitmap);
                    showToast("儲存失敗");
                }

            }
        });

    }

    protected void initFindView() {
        tb_nav = (Toolbar) findViewById(R.id.tb_nav);
        iv_completeImage = (ImageView) findViewById(R.id.iv_completeImage);
        fab_download = (FloatingActionButton) findViewById(R.id.fab_download);
    }

    protected void initToolbar() {
        setSupportActionBar(tb_nav);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tb_nav.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // toast
    protected void showToast(String message) {
        Toast toast = Toast.makeText(CompleteActivity.this, message, Toast.LENGTH_LONG);
        TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
        if( tv != null) tv.setGravity(Gravity.CENTER);
        toast.show();
    }

    // 清空temp資料夾
    public static void cleanTempImage() {
        File folder = new File(Environment.getExternalStorageDirectory() + "/modify/temp/");

        if (folder.isDirectory()) {
            String[] children = folder.list();
            for (int i = 0; i < children.length; i++) {
                new File(folder, children[i]).delete();
            }
        }
    }

    // 儲存圖片
    public static void saveImage(Context context, Bitmap bitmap) {

        File folder = new File(Environment.getExternalStorageDirectory() + "/modify/images/");
        if(!folder.exists()){
            folder.mkdirs();
        }
        File imageFile = new File(folder, System.currentTimeMillis()+".jpg");

        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e(context.getClass().getSimpleName(), "Error writing file", e);
        }

    }


}
