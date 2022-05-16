package com.example.appsenku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Tablero t = (Tablero) findViewById(R.id.tablero6);
        t.test = this;

        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer

        simpleChronometer.start(); // start a chronometer
        t.invalidate();

        Button info = findViewById(R.id.button4);



        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), com.example.appsenku.Menu.class);
                startActivity(intent);
            }
        });


        Button clue = findViewById(R.id.clue);
        clue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tablero t = (Tablero) findViewById(R.id.tablero6);
                t.movimientosPista();




            }


        });







        Button reset = findViewById(R.id.reset);
        Button scoreB = findViewById(R.id.score);
        scoreB.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                                         alerta.setMessage("PUNTUACIÓN ACUMULADA:  "+ t.puntuacion+ " ptos").setCancelable(true);
                                         AlertDialog titulo = alerta.create();
                                         titulo.setTitle("PUNTUACIÓN");
                                         titulo.show();
                                     }

                                 });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("¿Está seguro de que desea reiniciar el juego?").setCancelable(true)
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tablero t = (Tablero) findViewById(R.id.tablero6);
                                t.full_reset();
                                //Log.d("score", "onCreate: "+scr);

                                simpleChronometer.setBase(SystemClock.elapsedRealtime());
                                t.invalidate();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog titulo = alerta.create();
                titulo.setTitle("Reinicio del juego");
                titulo.show();
            }
        });

        Tablero t1 = (Tablero) findViewById(R.id.tablero6);
        Log.d("asd", "asd" + t1.gameOver());

        if(t1.partidaGanada()){

        }

        else if(t1.gameOver()){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setCancelable(true);
            builder.setTitle("Enhorabuena, has ganado!!!!");
            builder.setMessage("Pulsa abajo para reiniciar la partida");
            builder.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tablero t = (Tablero) findViewById(R.id.tablero6);
                    t.full_reset();
                    t.invalidate();
                }
            });

            builder.setNegativeButton("Menú", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Button info = findViewById(R.id.button4);
                    info.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (v.getContext(), com.example.appsenku.Menu.class);
                            startActivity(intent);
                        }
                    });
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }



    }


    }


