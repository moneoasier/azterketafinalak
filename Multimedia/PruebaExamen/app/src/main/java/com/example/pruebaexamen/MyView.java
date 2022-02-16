package com.example.pruebaexamen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    private Rect cuadrado1;
    private Rect cuadrado2;
    private Rect cuadrado3;
    private Rect cuadrado4;

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){

        cuadrado1=new Rect();
        cuadrado2=new Rect();
        cuadrado3=new Rect();
        cuadrado4=new Rect();

        paint1=new Paint();
        paint2=new Paint();
        paint3=new Paint();
        paint4=new Paint();

        paint1.setColor(Color.BLACK);
        paint2.setColor(Color.DKGRAY);
        paint3.setColor(Color.GRAY);
        paint4.setColor(Color.MAGENTA);
    }

    public void changeColor(){

        paint1.setColor(paint1.getColor() == Color.BLACK ? Color.DKGRAY : Color.BLACK);
        paint2.setColor(paint2.getColor() == Color.DKGRAY ? Color.GRAY : Color.DKGRAY);
        paint3.setColor(paint3.getColor() == Color.GRAY ? Color.MAGENTA : Color.GRAY);
        paint4.setColor(paint4.getColor() == Color.MAGENTA ? Color.BLACK : Color.MAGENTA);

        postInvalidate();

    }

    @Override
    public void onDraw(Canvas canvas){

        cuadrado1.left=0;
        cuadrado1.top=0;
        cuadrado1.right=canvas.getWidth()/2;
        cuadrado1.bottom=canvas.getHeight()/2;

        canvas.drawRect(cuadrado1,paint1);

        cuadrado2.left=canvas.getWidth()/2;
        cuadrado2.top=0;
        cuadrado2.right=canvas.getWidth();
        cuadrado2.bottom=canvas.getHeight()/2;

        canvas.drawRect(cuadrado2,paint2);

        cuadrado3.left=0;
        cuadrado3.top=canvas.getHeight()/2;
        cuadrado3.right=canvas.getWidth()/2;
        cuadrado3.bottom=canvas.getHeight();

        canvas.drawRect(cuadrado3,paint3);


        cuadrado4.left=canvas.getWidth()/2;
        cuadrado4.top=canvas.getHeight()/2;
        cuadrado4.right=canvas.getWidth();
        cuadrado4.bottom=canvas.getHeight();

        canvas.drawRect(cuadrado4,paint4);

    }

}
