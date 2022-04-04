package com.example.appsenku;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Tablero extends View {

    public Tablero(Context context) {
        super(context);
    }

    public Tablero(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Tablero(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public com.example.appsenku.Tablero(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    /*protected void onDraw(Canvas canvas) {

        for(int y = 0; y < 490*2.5; y+=70*2.5){
                for(int x = 0; x < 490*2.5; x+=70*2.5){
                    if((x>=0 && x<140*2.5 && y>=0 && y<140*2.5) ||
                       (x>=0 && x<140*2.5 && y>=350*2.5 && y<=490*2.5) ||
                       (x>=350*2.5 && x<=490*2.5 && y>=0 && y<140*2.5) ||
                       (x>=350*2.5 && x<=490*2.5 && y>=350*2.5 && y<=490*2.5)) {
                        super.onDraw(canvas);
                        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                        Bitmap bmp2 =
                                BitmapFactory.decodeResource(getResources(), R.drawable.tablero);
                        canvas.drawBitmap(bmp2,x,y,p2);
                    }else{
                        super.onDraw(canvas);
                        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                        Bitmap bmp2 =
                                BitmapFactory.decodeResource(getResources(), R.drawable.vacia);
                        canvas.drawBitmap(bmp2,x,y,p2);

                    }

                }



        }

    }*/
    public int[][] matriz=  new int[][]{
        {-1,-1,1,1,1,-1,-1},
        {-1,-1,1,1,1,-1,-1},
        {1,1,1,1,1,1,1},
        {1,1,1,0,1,1,1},
        {1,1,1,1,1,1,1},
        {-1,-1,1,1,1,-1,-1},
        {-1,-1,1,1,1,-1,-1}
    };

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x= (int)(event.getX()/(70*2.5));
        Log.d("SENKU","X="+x);
        return super.dispatchTouchEvent(event);
    }

    protected void onDraw(Canvas canvas) {

        for(int y = 0; y<7; y++){
            for(int x = 0; x<7; x++){
                double i = x*70*2.5;
                double j = y*70*2.5;
                if(matriz[x][y] == -1){
                    super.onDraw(canvas);
                    Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Bitmap bmp2 =
                            BitmapFactory.decodeResource(getResources(), R.drawable.tablero);
                    canvas.drawBitmap(bmp2,(int)i,(int)j,p2);
                }
                else if(matriz[x][y] == 0){
                    super.onDraw(canvas);
                    Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Bitmap bmp2 =
                            BitmapFactory.decodeResource(getResources(), R.drawable.vacia);
                    canvas.drawBitmap(bmp2,(int)i,(int)j,p2);
                }
                else if(matriz[x][y] == 1){
                    super.onDraw(canvas);
                    Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Bitmap bmp2 =
                            BitmapFactory.decodeResource(getResources(), R.drawable.llena);
                    canvas.drawBitmap(bmp2,(int)i,(int)j,p2);
                }
            }
        }
    }


}
