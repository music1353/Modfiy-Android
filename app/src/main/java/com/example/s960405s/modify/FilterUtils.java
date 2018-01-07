package com.example.s960405s.modify;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by User on 2018/1/6.
 * 所有濾鏡
 */

public class FilterUtils {

    public static String filterArray[] = {"黑白","懷舊","哥德","淡雅","藍調","光暈","夢幻","酒紅","膠片","湖光掠影","褐片","復古","泛黃","傳統","膠片2","銳色","浪漫","夜色"};

    // 黑白
    final static float black_white[] = {0.8f, 1.6f, 0.2f, 0,
            -163.9f, 0.8f, 1.6f, 0.2f, 0, -163.9f, 0.8f, 1.6f, 0.2f, 0,
            -163.9f, 0, 0, 0, 1.0f, 0};
    // 懷舊
    final static float nostalgia[] = {0.2f, 0.5f, 0.1f, 0,
            40.8f, 0.2f, 0.5f, 0.1f, 0, 40.8f, 0.2f, 0.5f, 0.1f, 0, 40.8f, 0,
            0, 0, 1, 0};
    // 哥德
    final static float gothic[] = {1.9f, -0.3f, -0.2f, 0,
            -87.0f, -0.2f, 1.7f, -0.1f, 0, -87.0f, -0.1f, -0.6f, 2.0f, 0,
            -87.0f, 0, 0, 0, 1.0f, 0};
    // 淡雅
    final static float elegant[] = {0.6f, 0.3f, 0.1f, 0,
            73.3f, 0.2f, 0.7f, 0.1f, 0, 73.3f, 0.2f, 0.3f, 0.4f, 0, 73.3f, 0,
            0, 0, 1.0f, 0};
    // 藍調
    final static float blue[] = {2.1f, -1.4f, 0.6f,
            0.0f, -71.0f, -0.3f, 2.0f, -0.3f, 0.0f, -71.0f, -1.1f, -0.2f, 2.6f,
            0.0f, -71.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    // 光暈
    final static float light[] = {0.9f, 0, 0, 0, 64.9f,
            0, 0.9f, 0, 0, 64.9f, 0, 0, 0.9f, 0, 64.9f, 0, 0, 0, 1.0f, 0};

    // 夢幻
    final static float fantacy[] = {0.8f, 0.3f, 0.1f,
            0.0f, 46.5f, 0.1f, 0.9f, 0.0f, 0.0f, 46.5f, 0.1f, 0.3f, 0.7f, 0.0f,
            46.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    // 酒紅
    final static float red[] = {1.2f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f,
            0, 0, 0, 1.0f, 0};
    // 膠片
    final static float flim[] = {-1.0f, 0.0f, 0.0f, 0.0f,
            255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f,
            255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    // 湖光掠影
    final static float lake[] = {0.8f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f,
            0, 0, 0, 1.0f, 0};
    // 褐片
    final static float brown[] = {1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f,
            0, 0, 0, 1.0f, 0};
    // 復古
    final static float retro[] = {0.9f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f,
            0, 0, 0, 1.0f, 0};
    // 泛黃
    final static float yellow[] = {1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f,
            0.0f, 0, 0, 0, 1.0f, 0};
    // 傳統
    final static float tradition[] = {1.0f, 0.0f, 0.0f, 0,
            -10f, 0.0f, 1.0f, 0.0f, 0, -10f, 0.0f, 0.0f, 1.0f, 0, -10f, 0, 0,
            0, 1, 0};
    // 膠片2
    final static float flim2[] = {0.71f, 0.2f, 0.0f,
            0.0f, 60.0f, 0.0f, 0.94f, 0.0f, 0.0f, 60.0f, 0.0f, 0.0f, 0.62f,
            0.0f, 60.0f, 0, 0, 0, 1.0f, 0};
    // 銳色
    final static float shark[] = {4.8f, -1.0f, -0.1f, 0,
            -388.4f, -0.5f, 4.4f, -0.1f, 0, -388.4f, -0.5f, -1.0f, 5.2f, 0,
            -388.4f, 0, 0, 0, 1.0f, 0};
    // 浪漫
    final static float romance[] = {0.9f, 0, 0, 0, 63.0f,
            0, 0.9f, 0, 0, 63.0f, 0, 0, 0.9f, 0, 63.0f, 0, 0, 0, 1.0f, 0};
    // 夜色
    final static float dark[] = {1.0f, 0.0f, 0.0f, 0.0f,
            -66.6f, 0.0f, 1.1f, 0.0f, 0.0f, -66.6f, 0.0f, 0.0f, 1.0f, 0.0f,
            -66.6f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};


    public static Bitmap black_whiteFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(black_white);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap nostalgiaFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(nostalgia);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap gothicFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(gothic);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap elegantFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(elegant);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap blueFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(blue);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap lightFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(light);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap fantacyFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(fantacy);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap redFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(red);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap flimFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(flim);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap lakeFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(lake);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap brownFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(brown);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap retroFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(retro);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap yellowFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(yellow);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap traditionFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(tradition);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap flim2Filter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(flim2);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap sharkFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(shark);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap romanceFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(romance);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }

    public static Bitmap darkFilter(Bitmap originBitmap){
        Bitmap newBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), originBitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();

        ColorMatrix colorMatrix = new ColorMatrix(dark);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(originBitmap ,new Matrix(),paint);

        return newBitmap;
    }
}
