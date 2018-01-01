package com.example.s960405s.modify;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;


public class ModifyActivity extends AppCompatActivity {

    private ImageView iv_preImage;
    private Toolbar tb_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        findViewInit(); // init bind

        initToolbar(); // set toolbar

        Uri uri = getIntent().getData(); // get image uri
        // 呈現圖片至畫面
        Bitmap preImage;
        try {
            preImage = BitmapFactory.decodeStream(getContentResolver(). openInputStream(uri));
            iv_preImage.setImageBitmap(preImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void findViewInit() {
        iv_preImage = (ImageView) findViewById(R.id.iv_preImage);
        tb_nav = (Toolbar) findViewById(R.id.tb_nav);
    }

    protected  void initToolbar() {
        setSupportActionBar(tb_nav);
        getSupportActionBar().setTitle("修改圖片");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tb_nav.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
