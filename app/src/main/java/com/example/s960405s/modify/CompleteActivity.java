package com.example.s960405s.modify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;

public class CompleteActivity extends AppCompatActivity {

    Bitmap bitmap;
    private ImageView iv_completeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        initFindView();

        Uri uri = getIntent().getData(); // get image uri
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        iv_completeImage.setImageBitmap(bitmap);
    }

    protected void initFindView() {
        iv_completeImage = (ImageView) findViewById(R.id.iv_completeImage);
    }

}
