package com.example.appsenku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tablero t = (Tablero) findViewById(R.id.tablero6);
        t.test = this;
        Button reset = findViewById(R.id.button2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tablero t = (Tablero) findViewById(R.id.tablero6);
                t.full_reset();
                t.invalidate();
            }
        });

        Button info = findViewById(R.id.button4);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), com.example.appsenku.Menu.class);
                startActivity(intent);
            }
        });




    }


    public void onClick(View view) {

    }








}