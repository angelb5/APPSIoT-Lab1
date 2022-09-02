package com.example.appsiot_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.sql.Array;
import java.util.Arrays;

public class StaticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics);


        Button button = findViewById(R.id.buttonNuevoJuego);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long tInicio = System.currentTimeMillis();
                Intent intent = new Intent(StaticsActivity.this,MemoriaActivity.class);
                startActivity(intent);

                long tFinal = System.currentTimeMillis();
                long tDiferencia = tFinal - tInicio;
                double tseg = tDiferencia/1000.0;

            }
        });




        Intent intent = getIntent();
        double[] listaduracion = intent.getDoubleArrayExtra("lista");

        Integer duracion = intent.getIntExtra("duracion",0);
        Integer numeroJuego = intent.getIntExtra("juego",0);
        String evento = intent.getStringExtra("evento");
        TextView detalles = findViewById(R.id.textViewDetalles);
        String texto= "";
        texto = texto + "Juego "+numeroJuego+" : "+ evento + " en "+ duracion+" minutos";

    }
}