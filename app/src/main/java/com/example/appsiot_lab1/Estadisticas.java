package com.example.appsiot_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        Intent intent = getIntent();
        ArrayList<String> estadisticas = (ArrayList<String>) intent.getSerializableExtra("estadisticas");
        Log.d("msg", String.valueOf(estadisticas));

        String textoEstadisticas = "";
        for(String estadistica : estadisticas)
        {
            textoEstadisticas += estadistica+"\n";
        }

        TextView textEstd = findViewById(R.id.textViewEstadisticas);
        textEstd.setText(textoEstadisticas);


    }

    public void nuevoJuego(View view){
        finish();
    }
}