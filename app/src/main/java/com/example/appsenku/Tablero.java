package com.example.appsenku;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
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

    protected void onDraw(Canvas canvas) {
     /*   super.onDraw(canvas);
        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.RED);
        Bitmap bmp =
                BitmapFactory.decodeResource(getResources(), R.drawable.board_bg );
        canvas.drawBitmap(bmp,0,0,p1);*/

        for(int y = 0; y < 490*2.5; y+=70*2.5){
            for(int x = 0; x < 490*2.5; x+=70*2.5){
                super.onDraw(canvas);
                Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                Bitmap bmp2 =
                        BitmapFactory.decodeResource(getResources(), R.drawable.vacia);
                canvas.drawBitmap(bmp2,x,y,p2);
            }
        }


    }

}
