package com.example.pruebazirkulu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Nireview extends View {
   private Paint circle;
    private float circleX, circleY;
    private float circleRadius=100f;
    float mx,my,deltax,deltay,d;

    private int sqKolore;

    public Nireview(Context context) {
        super(context);

    }

    public Nireview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public Nireview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public Nireview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    protected void  onDraw(Canvas canvas){
        circle = new Paint();

        circle.setColor(Color.parseColor("#aa00aa"));
        canvas.drawColor(Color.RED);

        if ((circleX == 0f) || (circleY == 0f)) {
            circleX = getWidth() / 2;
            circleY = getHeight() / 2;

        }
        canvas.drawCircle(circleX, circleY, circleRadius, circle);

    }

    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_MOVE){
            mx=event.getX();
            my=event.getY();
            deltax=mx-circleX;
            deltay=my-circleY;

            d= (float) Math.sqrt(Math.pow(deltax,2)+Math.pow(deltay,2));

            if(d < circleRadius){

                circleX=mx;
                circleY=my;
                Log.d("xd", " colision");

            }
            Log.d("xd", " "+d);

        }
        postInvalidate();


        return true;
    }
}
