package com.example.s960405s.modify;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class ModifyActivity extends AppCompatActivity {

    String rotateArray[] = {"左旋90度", "右旋90度", "旋轉180度"};
    Bitmap preImage; // MainActivity傳進來的圖片
    Bitmap newBitmap; // 修圖後的新Bitmap
    public static LinearLayout linear; // 滑動的linear
    public static LinearLayout.LayoutParams params;
    int modfiyTuggle = 0; // 切換modify in scroll
    int rotateTuggle = 0; // 切換rotate in scroll
    private ImageView iv_preImage; // 預覽圖
    private Toolbar tb_nav;
    private Button btn_modify, btn_rotate, btn_complete;
    private LinearLayout ll_fontContainer, ll_scroll;
    final int PIC_CROP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        initFindView(); // init bind

        initToolbar(); // set toolbar

        initFontAwesome(); // set font awesome

        initLinearSlider(); // ll_scroll滑動

        final Uri uri = getIntent().getData(); // get image uri
        try {
            preImage = RGB565(uri);
            iv_preImage.setImageBitmap(preImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // set modify btn
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modfiyTuggle%2==0){
                    setModifyBtns();
                } else {
                    linear.removeAllViews();
                }
                modfiyTuggle++;
            }
        });

        // set rotate btn
        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rotateTuggle%2==0){
                    setRotateBtns();
                } else {
                    linear.removeAllViews();
                }
                rotateTuggle++;
            }
        });


        // set complete btn
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Bitmap bitmap = getCurrentBitmap();
                Intent intent = new Intent(ModifyActivity.this, CompleteActivity.class);

                File file = tempFileImage(getApplicationContext(), bitmap, "temp");
                recycleBitmap(bitmap);
                Uri imageUri = FileProvider.getUriForFile(getApplicationContext(), "com.example.s960405s.modify.provider", file);

                intent.setData(imageUri);
                startActivity(intent);
                toFinish();
            }
        });
    }


    protected void initFindView() {
        iv_preImage = (ImageView) findViewById(R.id.iv_preImage);
        tb_nav = (Toolbar) findViewById(R.id.tb_nav);
        btn_modify = (Button) findViewById(R.id.btn_modify);
        btn_rotate = (Button) findViewById(R.id.btn_rotate);
        btn_complete = (Button) findViewById(R.id.btn_complete);
        ll_fontContainer = (LinearLayout) findViewById(R.id.ll_fontContainer);
        ll_scroll = (LinearLayout) findViewById(R.id.ll_scroll);
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

    protected void initFontAwesome() {
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.ll_fontContainer), iconFont);
    }

    protected void initLinearSlider() {
        linear = (LinearLayout) super.findViewById(R.id.ll_scroll);
        params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
    }

    protected void setModifyBtns() {
        linear.removeAllViews(); // 先清空linear內的views

        // 建構選擇filter的btns
        for(int i=0 ; i<FilterUtils.filterArray.length ; i++) {
            Button btn = new Button(ModifyActivity.this);
            btn.setText(FilterUtils.filterArray[i]);
            btn.setId(i);
            linear.addView(btn, params);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case 0:
                            newBitmap = FilterUtils.black_whiteFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);

                            break;
                        case 1:
                            newBitmap = FilterUtils.nostalgiaFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 2:
                            newBitmap = FilterUtils.gothicFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 3:
                            newBitmap = FilterUtils.elegantFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 4:
                            newBitmap = FilterUtils.blueFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 5:
                            newBitmap = FilterUtils.lightFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 6:
                            newBitmap = FilterUtils.fantacyFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 7:
                            newBitmap = FilterUtils.redFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 8:
                            newBitmap = FilterUtils.flimFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 9:
                            newBitmap = FilterUtils.lakeFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 10:
                            newBitmap = FilterUtils.brownFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 11:
                            newBitmap = FilterUtils.retroFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 12:
                            newBitmap = FilterUtils.yellowFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 13:
                            newBitmap = FilterUtils.traditionFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 14:
                            newBitmap = FilterUtils.flim2Filter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 15:
                            newBitmap = FilterUtils.sharkFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 16:
                            newBitmap = FilterUtils.romanceFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                        case 17:
                            newBitmap = FilterUtils.darkFilter(preImage);
                            iv_preImage.setImageBitmap(newBitmap);
                            break;
                    }
                }
            });
        }
    }

    protected void setRotateBtns() {
        linear.removeAllViews();

        for(int i=0 ; i<3 ; i++){
            Button btn = new Button(ModifyActivity.this);
            btn.setText(rotateArray[i]);
            btn.setId(i);
            linear.addView(btn, params);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 拿到當下的bitmap
                    Bitmap bitmap = getCurrentBitmap();

                    switch (v.getId()) {
                        case 0:
                            Matrix m = new Matrix();
                            m.setRotate(-90);
                            Bitmap b = Bitmap.createBitmap(bitmap, 0, 0 ,bitmap.getWidth() ,bitmap.getHeight() ,m ,true);
                            iv_preImage.setImageBitmap(b);
                            break;
                        case 1:
                            m = new Matrix();
                            m.setRotate(90);
                            b = Bitmap.createBitmap(bitmap, 0 ,0 ,bitmap.getWidth() ,bitmap.getHeight() ,m ,true);
                            iv_preImage.setImageBitmap(b);
                            break;
                        case 2:
                            m = new Matrix();
                            m.setRotate(180);
                            b = Bitmap.createBitmap(bitmap, 0 ,0 ,bitmap.getWidth() ,bitmap.getHeight() ,m ,true);
                            iv_preImage.setImageBitmap(b);
                            break;
                    }

                }
            });
        }
    }


    // 拿到當下iv_preImage的bitmap
    protected Bitmap getCurrentBitmap() {
        Bitmap bitmap = ((BitmapDrawable)iv_preImage.getDrawable()).getBitmap();
        return bitmap;
    }

    // RGB_565壓縮法(減少RGB位及去掉透明度)
    protected Bitmap RGB565(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
        return bitmap;
    }

    // 暫時儲存圖片
    public static File tempFileImage(Context context, Bitmap bitmap, String name) {

        File folder = new File(Environment.getExternalStorageDirectory() + "/modify/temp/");
        if(!folder.exists()){
            folder.mkdirs();
        }
        File imageFile = new File(folder, name+".jpg");

        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e(context.getClass().getSimpleName(), "Error writing file", e);
        }

        // return imageFile.getAbsolutePath();
        return imageFile;
    }

    // 回收bitmap內存
    protected void recycleBitmap(Bitmap bitmap) {
        if(!bitmap.isRecycled()){
            bitmap.recycle(); //回收圖片所占的記憶體
            System.gc(); //提醒系統及時回收
        }
    }

    protected void toFinish() {
        recycleBitmap(preImage);
        linear.removeAllViews();
        params = null;
        finish();
        System.gc();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PIC_CROP) {
            if (data != null) {
                // get the returned data
                Bundle extras = data.getExtras();
                // get the cropped bitmap
                Bitmap selectedBitmap = extras.getParcelable("data");

                iv_preImage.setImageBitmap(selectedBitmap);
            }
        }
    }
}
