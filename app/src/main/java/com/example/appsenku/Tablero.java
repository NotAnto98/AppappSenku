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

    public static final int VACIA = 0;
    public static final int LIMITE = -1;
    public static final int FICHA = 1;

    public Tablero(Context context) {
        super(context);
    }

    public Tablero(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Tablero(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

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
        int y = (int)(event.getY()/(70*2.5));

        int a = x+1;
        int b = x+2;
        int c = x-1;
        int d = x-2;
        int e = y+1;
        int f = y+2;
        int g = y-1;
        int h = y-2;

        if(a < 7 && b < 7){
            if(this.matriz[x][y] == 1 && this.matriz[a][y] == 1 && this.matriz[b][y] == 0){
                Log.d("Senku", "derecha");
            }
        }
        if(c >= 0 && d >= 0){
            if(this.matriz[x][y] == 1 && this.matriz[c][y] == 1 && this.matriz[d][y] == 0){
                Log.d("Senku", "izquierda");
            }
        }
        if(e < 7 && f < 7){
            if(this.matriz[x][y] == 1 && this.matriz[x][e] == 1 && this.matriz[x][f] == 0){
                Log.d("Senku", "arriba");
            }
        }
        if(g >= 0 && h >= 0){
            if(this.matriz[x][y] == 1 && this.matriz[x][g] == 1 && this.matriz[x][h] == 0){
                Log.d("Senku", "abajo");
            }
        }


        //Log.d("SENKU","X="+x);
        //Log.d("SENKU","Y="+y);
        //estadoMovimiento(event);
        return super.dispatchTouchEvent(event);
    }

    protected void onDraw(Canvas canvas) {

        for(int y = 0; y<7; y++){
            for(int x = 0; x<7; x++){
                double i = x*70*2.5;
                double j = y*70*2.5;
                if(matriz[x][y] == -1){

                }
                else if(matriz[x][y] == 0){
                    super.onDraw(canvas);
                    Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Bitmap bmp2 =
                            BitmapFactory.decodeResource(getResources(), R.drawable.negra);
                    canvas.drawBitmap(bmp2,(int)i,(int)j,p2);
                }
                else if(matriz[x][y] == 1){
                    super.onDraw(canvas);
                    Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Bitmap bmp2 =
                            BitmapFactory.decodeResource(getResources(), R.drawable.ficha);
                    canvas.drawBitmap(bmp2,(int)i,(int)j,p2);
                }
            }
        }
    }

    public boolean estadoMovimiento(MotionEvent event){
        int x= (int)(event.getX()/(70*2.5));
        int y = (int)(event.getY()/(70*2.5));
        boolean movPosible = false;
        for( ;y<5; y++){
            for(;x<5;x++){
                if((this.matriz[x][y] == 1 && this.matriz[x+1][y] == 1 && this.matriz[x+2][y] == 0) ||
                        (this.matriz[x][y] == 0 && this.matriz[x+1][y] == 1 && this.matriz[x+2][y] == 1) ||
                        (this.matriz[x][y] == 1 && this.matriz[x][y+1] == 1 && this.matriz[x][y+2] == 0) ||
                        (this.matriz[x][y] == 0 && this.matriz[x][y+1] == 1 && this.matriz[x][y+2] == 1)){
                    Log.d("SENKU","se pueden hacer movimientos"+x);
                    movPosible = true;
                }else{
                    Log.d("SENKU","no se pueden hacer movimientos");
                }

            }
        }
        return movPosible;
    }



}
