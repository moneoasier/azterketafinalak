package com.example.pruebaexam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Nireview extends View {
    float x1, y1, x2, y2, d;


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

    @Override
    protected void onDraw(Canvas canvas) {
        //brocha
        Paint paint=new Paint();
        //mojar pintura
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        paint.setStrokeWidth(10);




        canvas.drawColor(Color.BLUE);
        canvas.drawRect(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()/2+50,canvas.getHeight()/2+50,paint);
        canvas.drawText(""+d,canvas.getWidth()/2,canvas.getHeight()/4,paint);
        canvas.drawLine(x1,y1,x2,y2,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Cuando clicas con el mouse ACTION_DOWN
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            x1 = event.getX();
            y1 = event.getY();
            x2 = event.getX();
            y2 = event.getY();


        }
        //Cuando clicas y mueves con el mouse ACTION_MOVE
        if (event.getAction() == MotionEvent.ACTION_MOVE) {

            x2 = event.getX();
            y2 = event.getY();

            d= (float) Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));

        }


        postInvalidate();
        return true;
    }
}
