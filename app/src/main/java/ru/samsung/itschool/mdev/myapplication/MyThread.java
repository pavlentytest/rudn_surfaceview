package ru.samsung.itschool.mdev.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

    private Paint paint;
    // держатель на SurfaceView
    private SurfaceHolder surfaceHolder;
    public boolean flag;

    MyThread(SurfaceHolder holder) {
        this.flag = false;
        this.surfaceHolder = holder;
        paint = new Paint();
        paint.setAntiAlias(true); // сглаживание
        paint.setStyle(Paint.Style.FILL);
    }

    public long getTime() {
        return System.nanoTime()/1000; // микросекунды
    }

    private long redrawTime;  //0

    public void run() {
        Canvas canvas;
        while(flag) {
            long currentTime = getTime();
            long elapsedTime = currentTime - redrawTime;
            if(elapsedTime < 500000) {
                continue;
            }
            // блокировка Canvas
            canvas = surfaceHolder.lockCanvas();
            // логика отрисовки
            drawCircle(canvas);
            // показать отрисованное
            surfaceHolder.unlockCanvasAndPost(canvas);
            // обновление времени
            redrawTime = getTime();
        }
    }

    public void drawCircle(Canvas canvas) {
        long currTime = getTime();
        int centerX = canvas.getWidth()/2;
        int centerY = canvas.getHeight()/2;
        canvas.drawColor(Color.BLACK);
        // максимальный радиус круга
        float maxRadius = (float)Math.min(canvas.getHeight(),canvas.getWidth())/2;
        // коэфф-т меньше < 1
        float koeff = (float)(currTime%1000)/1000;
        Log.d("RRRRR",Float.toString(koeff));
        paint.setColor(Color.RED);
        canvas.drawCircle(centerX,centerY,maxRadius*koeff,paint);
    }
}
