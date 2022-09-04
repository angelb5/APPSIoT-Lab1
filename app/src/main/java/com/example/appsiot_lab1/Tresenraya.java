package com.example.appsiot_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tresenraya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tresenraya);
    }

    private int jugador = 1;
    // 1 -> jugador 1 (cruz)
    // 2 -> jugador 2 (circulo)

    private int[][] posicionesGanadoras = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    private int[] tableroActual = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    // -1 -> vacio
    // 0 -> 0
    // 1 -> x

    private int contador = 0;
    // si llega a 9 y no ha ganado nadie, se resetea el juego

    private ArrayList<String> estadisticas = new ArrayList<String>();

    private String estado="jugando";

    public void reiniciar(){
        contador = 0;
        tableroActual = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        jugador = 1;
        estado="jugando";

        Button boton = findViewById(R.id.casilla0);
        boton.setText("-");
        boton = findViewById(R.id.casilla1);
        boton.setText("-");
        boton = findViewById(R.id.casilla2);
        boton.setText("-");
        boton = findViewById(R.id.casilla3);
        boton.setText("-");
        boton = findViewById(R.id.casilla4);
        boton.setText("-");
        boton = findViewById(R.id.casilla5);
        boton.setText("-");
        boton = findViewById(R.id.casilla6);
        boton.setText("-");
        boton = findViewById(R.id.casilla7);
        boton.setText("-");
        boton = findViewById(R.id.casilla8);
        boton.setText("-");
    }

    // funciones para los elementos view

    public void nuevoJuego(View view) {

        if(estado.equals("jugando")){
            // se guarda la estadistica
            int numeroJuego = estadisticas.size()+1; // se le suma 1 para que comienze en 1 y no en 0
            estadisticas.add("Juego "+String.valueOf(numeroJuego)+" - Cancelo");
        }

        ((TextView) findViewById(R.id.textViewResultadoTresEnRaya)).setText("");

        this.reiniciar();
    }

    public void marcarCasilla(View view){
        Button boton = (Button) view;

        int id = view.getId();
        Resources res = view.getResources(); // get integer id of view
        String idString = res.getResourceEntryName(id);
        //Log.d("msg", idString);

        int casilla = -1;
        switch (idString) {
            case "casilla0":
                casilla = 0;
                break;
            case "casilla1":
                casilla = 1;
                break;
            case "casilla2":
                casilla = 2;
                break;
            case "casilla3":
                casilla = 3;
                break;
            case "casilla4":
                casilla = 4;
                break;
            case "casilla5":
                casilla = 5;
                break;
            case "casilla6":
                casilla = 6;
                break;
            case "casilla7":
                casilla = 7;
                break;
            case "casilla8":
                casilla = 8;
                break;
        }
        //Log.d("msg", String.valueOf(casilla));

        if(tableroActual[casilla] == -1 && estado.equals("jugando")){
            // si la casilla aun no ha sido seleccionada

            // se actualizan las casillas
            if(jugador==1){
                // jugador cruz

                boton.setText("X");
                // se actualiza el tablero
                tableroActual[casilla] = 1;
                // se cambia jugador
                jugador = 2;

                // se verifica si gano
                for (int[] posicionGanadora : posicionesGanadoras) {
                    if (tableroActual[posicionGanadora[0]] == 1 && tableroActual[posicionGanadora[1]] == 1 && tableroActual[posicionGanadora[2]] == 1) {
                        ((TextView) findViewById(R.id.textViewResultadoTresEnRaya)).setText("Ganó X");

                        // se guarda la estadistica
                        int numeroJuego = estadisticas.size()+1; // se le suma 1 para que comienze en 1 y no en 0
                        estadisticas.add("Juego "+String.valueOf(numeroJuego)+" - Gano X");
                        estado="fin";
                    }
                }

            } else {
                // jugador cruz

                boton.setText("O");
                // se actualiza el tablero
                tableroActual[casilla] = 0;
                // se cambia jugador
                jugador = 1;

                // se verifica si gano
                for (int[] posicionGanadora : posicionesGanadoras) {
                    if (tableroActual[posicionGanadora[0]] == 0 && tableroActual[posicionGanadora[1]] == 0 && tableroActual[posicionGanadora[2]] == 0) {
                        ((TextView) findViewById(R.id.textViewResultadoTresEnRaya)).setText("Ganó O");

                        // se guarda la estadistica
                        int numeroJuego = estadisticas.size()+1; // se le suma 1 para que comienze en 1 y no en 0
                        estadisticas.add("Juego "+String.valueOf(numeroJuego)+" - Gano O");
                        estado="fin";
                    }
                }
            }

            // se verifica si se acabaron las casillas
            contador++;
            Log.d("msg", String.valueOf(contador));
            if(contador==9){
                ((TextView) findViewById(R.id.textViewResultadoTresEnRaya)).setText("Empate");

                // se guarda la estadistica
                int numeroJuego = estadisticas.size()+1; // se le suma 1 para que comienze en 1 y no en 0
                estadisticas.add("Juego "+String.valueOf(numeroJuego)+" - Empate");
                estado="fin";
            }
        }
    }

    @Override
    protected void onRestart() {
        reiniciar();
        super.onRestart();
    }

    public void mostrarEstadisticas (View view){
        Intent intent = new Intent(this, Estadisticas.class);
        intent.putExtra("estadisticas", estadisticas);
        startActivity( intent );
    }
}