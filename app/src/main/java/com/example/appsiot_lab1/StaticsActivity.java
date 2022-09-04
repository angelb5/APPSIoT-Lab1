package com.example.appsiot_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class StaticsActivity extends AppCompatActivity {

    private ArrayList<String> listaduracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics);


        Button button = findViewById(R.id.buttonNuevoJuego);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        listaduracion = intent.getStringArrayListExtra("lista");
        String texto= "";
        for(int i = 0; i<listaduracion.size(); i++){
            String duracion=listaduracion.get(i);
            if(!duracion.equals("0")){
                texto = texto + "Juego "+ (i+1) +" : Terminó en "+ duracion+" minutos\n";
            }else{
                texto = texto + "Canceló\n";
            }
        }
        TextView detalles = findViewById(R.id.textViewDetalles);
        detalles.setText(texto);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}