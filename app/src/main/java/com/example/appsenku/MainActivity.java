package com.example.appsenku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R.drawable.senku;
        Tablero t = (Tablero) findViewById(R.id.tablero6);
        t.test = this;

    }


}