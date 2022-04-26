package com.example.appsenku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R.drawable.senku;

        Tablero t = (Tablero) findViewById(R.id.tablero6);
        t.test = this;

        t.test = this;
        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(this);


    }

    public void onClick(View view) {
        Tablero t = (Tablero) findViewById(R.id.tablero6);
        t.full_reset();
        t.invalidate();

        Toast.makeText(MainActivity.this, "HA EMPEZADO DE NUEVO", Toast.LENGTH_LONG).show();



    }
}