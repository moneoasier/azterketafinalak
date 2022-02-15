package com.example.zirkuluabakarrikmugitu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;


public class ZirkuluaView extends SurfaceView implements Runnable {

    private Paint zirkuluaPaint;
    private float circleX;
    private float circleY;
    private float circleRadius = 100;

    private Rect laukia;
    private Paint laukiaPaint;
    private final int laukiaAldea=200;

    private Thread thread;

    public ZirkuluaView(Context context) {
        super(context);
        init();
    }

    private void init() {
        // Laukia
        laukia = new Rect();
        laukiaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        laukiaPaint.setColor(Color.MAGENTA);

        // Zirkulua hasieratu
        zirkuluaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        zirkuluaPaint.setColor(Color.RED);
    }

    @Override
    public void run() {
        while (true) {
            update();
            draw();
            sleep();
        }
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawColor(Color.WHITE);


            canvas.drawRect(laukia,laukiaPaint);
            canvas.drawCircle(circleX, circleY, circleRadius, zirkuluaPaint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void update() {
        laukia.top=getHeight()/2+laukiaAldea/2;
        laukia.bottom=getHeight()/2-laukiaAldea/2;
        laukia.left=getWidth()/2+laukiaAldea/2;
        laukia.right=getWidth()/2-laukiaAldea/2;

        if (circleX == 0f || circleY == 0) {
            circleX = getWidth() / 2;
            circleY = circleRadius;
        } else if(circleY-circleRadius>=getHeight()) {
            circleRadius += 15;
            circleY = circleRadius;
            Random rnd = new Random();
            zirkuluaPaint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }else if (circleRadius+circleRadius>getWidth()){
            circleRadius=100;
        } else{
            circleY += 40;
        }
    }

    private void sleep() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        thread = new Thread(this);
        thread.start();
    }
}
