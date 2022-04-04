package com.example.appsenku;

import java.util.ArrayList;

public class Matriz {

    public int score;
    //private List<Movimiento> mov_anteriores = new ArrayList();

    public int[][] matriz;

    public static final int VACIA = 0;
    public static final int LIMITE = -1;
    public static final int PIEZA = 1;

    private int piezas = 1;


    public Matriz(){
        this.matriz = new int[][]{
                {-1,-1,1,1,1,-1,-1},
                {-1,-1,1,1,1,-1,-1},
                {1,1,1,1,1,1,1},
                {1,1,1,0,1,1,1},
                {1,1,1,1,1,1,1},
                {-1,-1,1,1,1,-1,-1},
                {-1,-1,1,1,1,-1,-1}
        };


        for (int y = 0; y < 7; y++){
            for (int x = 0; x < 7; x++){
                if(this.matriz[x][y] == this.PIEZA){
                    this.score++;
                }
            }
        }
        System.out.println("Num de bolas iniciales: "+ this.score);
        //this.mov_anteriores.clear(); //Limpia la lista
    }


}
