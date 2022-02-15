package com.example.pruebaexamazterketa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Nireview extends View {
    float circlex, circley,mx,my,d,circletop,circleleft,cicleright,circlebottom,rectTop=50,rectBottom=200,rectRight=200,rectLeft=50,d1, d2,d3,d4;
    float circleraudius=100f;

    Paint paint;

    public Nireview(Context context) {
        super(context);
    }

    public Nireview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();

    }

    public Nireview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Nireview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLUE);

        canvas.drawColor(Color.YELLOW);



        if ((circlex == 0f) && (circley == 0f)) {
            circlex = getWidth() / 2;
            circley = getHeight() / 2;

        }

        canvas.drawCircle(circlex,circley,circleraudius,paint);
        paint.setColor(Color.RED);
        canvas.drawRect(rectLeft,rectTop,rectRight,rectBottom,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()== MotionEvent.ACTION_DOWN) {
            mx=event.getX();
            my=event.getY();
            d= (float) Math.sqrt(Math.pow(circlex-mx,2) + Math.pow(circley-my,2));

        }


        if(event.getAction()== MotionEvent.ACTION_MOVE){

            mx=event.getX();
            my=event.getY();

            circletop = circley-circleraudius;
            circleleft=circlex-circleraudius;
            cicleright=circlex+circleraudius;
            circlebottom=circley+circleraudius;

            d1= (float) Math.sqrt(Math.pow(circlex-rectLeft,2) + Math.pow(circley-rectTop,2));
            d2= (float) Math.sqrt(Math.pow(circlex-rectRight,2) + Math.pow(circley-rectTop,2));
            d3= (float) Math.sqrt(Math.pow(circlex-rectRight,2) + Math.pow(circley-rectBottom,2));
            d4= (float) Math.sqrt(Math.pow(circlex-rectLeft,2) + Math.pow(circley-rectBottom,2));
            Log.d("c", " "+d1);
            Log.d("c", " "+d2);
            Log.d("c", " "+d3);
            Log.d("c", " "+d4);
            if(d<circleraudius){

                    circlex=mx;
                    circley=my;
                /*
                if(circletop< 0){

                    circley=circleraudius;
                }

                if(cicleright > getWidth()){
                    circlex=getWidth()-circleraudius;
                }

                if(circleleft < 0){
                    circlex=circleraudius;
                }

                if(circlebottom > getHeight()){
                    circley=getHeight()-circleraudius;
                }*/


            }

            if(d1<circleraudius|| d2 <circleraudius||d3 < circleraudius|| d4 <circleraudius) {

                Log.d("c", "colission ");
            }

        }


        postInvalidate();

        return true;
    }
}
