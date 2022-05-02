package com.example.appsenku;

import android.app.Activity;
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
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Tablero extends View {

    public static final int VACIA = 0;
    public static final int LIMITE = -1;
    public static final int FICHA = 1;
    public int selX = 0;
    public int selY = 0;
    public Boolean selected = false;
    public static Boolean resetV = false;
    public Activity test = null;

    public Tablero(Context context) {
        super(context);
    }

    public Tablero(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Tablero(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int[][] reset_matriz(){
        return new int[][] {{-1,-1,1,1,1,-1,-1},
                {-1,-1,1,1,1,-1,-1},
                {1,1,1,1,1,1,1},
                {1,1,1,0,1,1,1},
                {1,1,1,1,1,1,1},
                {-1,-1,1,1,1,-1,-1},
                {-1,-1,1,1,1,-1,-1}};
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

    public void full_reset(){

        matriz = new int[][]{
                {-1,-1,1,1,1,-1,-1},
                {-1,-1,1,1,1,-1,-1},
                {1,1,1,1,1,1,1},
                {1,1,1,0,1,1,1},
                {1,1,1,1,1,1,1},
                {-1,-1,1,1,1,-1,-1},
                {-1,-1,1,1,1,-1,-1}

        };
        //matriz = reset_matriz();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x= (int)(event.getX()/(70*2.5));
        int y = (int)(event.getY()/(70*2.5));

        boolean compruebaFinal = true;

        int a = x+1;
        int b = x+2;
        int c = x-1;
        int d = x-2;
        int e = y+1;
        int f = y+2;
        int g = y-1;
        int h = y-2;

        if(selected){

            if(matriz[x][y]==1){ //seleccion de ficha
                selX = x;
                selY = y;
                this.invalidate();
            }
            if(c >=0 && d >=0 && this.matriz[x][y] == 0 && this.matriz[c][y] == 1 && d == selX && y == selY){ //movimiento legal hacia la izquierda

                selX = x;
                selY = y;
                this.matriz[x][y] = 1;
                this.matriz[c][y] = 0;
                this.matriz[d][y] = 0;
                selected = false;
                compruebaFinal();
                this.invalidate();
            }
            if(a < 7 && b < 7 && this.matriz[x][y] == 0 && this.matriz[a][y] == 1 && b == selX && y == selY){ //movimiento legal hacia la derecha

                selX = x;
                selY = y;
                this.matriz[x][y] = 1;
                this.matriz[a][y] = 0;
                this.matriz[b][y] = 0;
                selected = false;
                compruebaFinal();
                this.invalidate();
            }
            if(e < 7 && f < 7 && this.matriz[x][y] == 0 && this.matriz[x][e] == 1 && x == selX && f == selY){ //movimiento legal hacia abajo
                selX = x;
                selY = y;
                this.matriz[x][y] = 1;
                this.matriz[x][e] = 0;
                this.matriz[x][f] = 0;
                selected = false;
                compruebaFinal();
                this.invalidate();
            }
            if(h >=0 && g >=0 && this.matriz[x][y] == 0 && this.matriz[x][g] == 1 && x == selX && h == selY){ //movimiento legal hacia arriba
                selX = x;
                selY = y;
                this.matriz[x][y] = 1;
                this.matriz[x][g] = 0;
                this.matriz[x][h] = 0;
                selected = false;
                compruebaFinal();
                this.invalidate();
            }

            else{ //movimiento ilegal
                if(matriz[x][y]==0){
                    Toast toast = Toast.makeText(test, "Movimiento no válido", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }
        else{
            if(matriz[x][y]==1){ //seleccion de ficha.
                selX = x;
                selY = y;
                selected = true;
                this.invalidate();
            }

            if(matriz[x][y]==0){ //movimineto ilegal, hueco vacio
                Toast toast = Toast.makeText(test, "Movimiento no válido", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
        return super.dispatchTouchEvent(event);
    }

    //metodo manejador botón CLUE
    public List<List<Integer>> movimientosPista(){

        List<List<Integer>> movimientosPosibles = new ArrayList<>();

        for(int y1 = 0; y1< matriz.length; y1++){
            for(int x1 = 0; x1< matriz.length; x1++){
                //movimiento posible para la izquierda
                if(x1-1 >=0 && x1-2 >=0 && this.matriz[x1][y1] == 1 && this.matriz[x1-1][y1] == 1 && this.matriz[x1-2][y1] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);

                }
                //movimiento posible para la derecha
                if(x1+1 < 7 && x1+2 < 7 && this.matriz[x1][y1] == 1 && this.matriz[x1+1][y1] == 1 && this.matriz[x1+2][y1] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);
                }
                //movimiento posible hacia arriba
                if(y1-1 >=0 && y1-2 >=0 && this.matriz[x1][y1] == 1 && this.matriz[x1][y1-1] == 1 && this.matriz[x1][y1-2] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);
                }
                //movimiento posible hacia abajo
                if(y1+1 <7 && y1+2 <7 && this.matriz[x1][y1] == 1 && this.matriz[x1][y1+1] == 1 && this.matriz[x1][y1+2] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);
                }
            }
        }

        int n = (int)Math.round(Math.random() * (movimientosPosibles.size()));
        int posible1 = movimientosPosibles.get(n).get(0);
        int posible2 = movimientosPosibles.get(n).get(1);
        selected = true;
        selX = posible1;
        selY = posible2;
        this.invalidate();

        return movimientosPosibles;
    }

    //método partida ganada, consiste en comprobar que quede una única ficha
    //si esto es asi la partida ha sido ganada
    public boolean partidaGanada(){

        boolean res = true;
        int cont = 0;

        for(int y1 = 0; y1< matriz.length; y1++){
            for(int x1 = 0; x1< matriz.length; x1++){
                if(cont > 1) {
                    res = false;
                    break;
                }
                else if(this.matriz[x1][y1]==1){
                    cont++;
                }

            }
        }

        return res;
    }


    public boolean gameOver(){

        List<List<Integer>> movimientosPosibles = new ArrayList<>();

        for(int y1 = 0; y1< matriz.length; y1++){
            for(int x1 = 0; x1< matriz.length; x1++){
                //movimiento posible para la izquierda
                if(x1-1 >=0 && x1-2 >=0 && this.matriz[x1][y1] == 1 && this.matriz[x1-1][y1] == 1 && this.matriz[x1-2][y1] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);

                }
                //movimiento posible para la derecha
                if(x1+1 < 7 && x1+2 < 7 && this.matriz[x1][y1] == 1 && this.matriz[x1+1][y1] == 1 && this.matriz[x1+2][y1] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);
                }
                //movimiento posible hacia arriba
                if(y1-1 >=0 && y1-2 >=0 && this.matriz[x1][y1] == 1 && this.matriz[x1][y1-1] == 1 && this.matriz[x1][y1-2] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);
                }
                //movimiento posible hacia abajo
                if(y1+1 <7 && y1+2 <7 && this.matriz[x1][y1] == 1 && this.matriz[x1][y1+1] == 1 && this.matriz[x1][y1+2] == 0){
                    List<Integer> posiciones = new ArrayList<>();
                    posiciones.add(x1);
                    posiciones.add(y1);
                    movimientosPosibles.add(posiciones);
                }
            }
        }

        Log.d("mov posible", "mov posibles " + movimientosPosibles);

        if(movimientosPosibles.size() == 0){
            return true;
        }

        else{
            return false;
        }
    }

    public boolean compruebaFinal(){
        boolean res = true;
        if(partidaGanada() == true){
            Toast toast = Toast.makeText(test, "Partida Ganada", Toast.LENGTH_SHORT);
            toast.show();
            res = false;
            Log.d("ganada", "ganada");
        }

        else if(gameOver() == true){
            Toast toast = Toast.makeText(test, "Partida perdida", Toast.LENGTH_SHORT);
            toast.show();
            res = false;
            Log.d("perdida", "perdida");
            //yo aqui pondría una ventana emergente con posibilidad de reiniciar el tablero
        }

        return res;
    }


    protected void onDraw(Canvas canvas) {

        for(int y = 0; y<7; y++){
            for(int x = 0; x<7; x++){
                double i = x*70*2.5;
                double j = y*70*2.5;
                if(matriz[x][y] == 0){
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

        if(selected == true){
            Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            p1.setColor(Color.RED);
            Bitmap bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.ficha_seleccionada);
            canvas.drawBitmap(bmp3,selX*70*2.5f,selY*70*2.5f,p1);
        }


    }



}

