package ru.samsung.itschool.mdev.myapplication;

import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

    private Paint paint;
    // держатель на SurfaceView
    private SurfaceHolder surfaceHolder;
    private boolean flag;

    MyThread(SurfaceHolder holder) {
        this.flag = false;
        this.surfaceHolder = holder;
        paint = new Paint();
        paint.setAntiAlias(true); // сглаживание
        paint.setStyle(Paint.Style.FILL);
    }
    
    public void run() {

    }
}
