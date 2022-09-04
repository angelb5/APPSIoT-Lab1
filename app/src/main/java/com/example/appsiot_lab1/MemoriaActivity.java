package com.example.appsiot_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsiot_lab1.entity.Memoria;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoriaActivity extends AppCompatActivity {

    private Memoria juegoMemoria;
    private Button ultimoBtn;
    private ArrayList<Button> lockedBtns = new ArrayList<>();
    private ArrayList<String> lista = new ArrayList<>();
    private String estado = "carga";
    private int primera=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        crearNuevoJuego();
        primera=0;
        findViewById(R.id.btnNuevoMemoria).setOnClickListener(view -> crearNuevoJuego());

        Button button = findViewById(R.id.btnStats);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemoriaActivity.this,StaticsActivity.class);
                intent.putExtra("lista",lista);
                startActivity(intent);
            }
        });
    }


    public void crearNuevoJuego(){
        estado="carga";
        juegoMemoria = new Memoria();
        lockedBtns = new ArrayList<>();
        ultimoBtn = null;

        if(primera !=1){
            if(juegoMemoria.getParesAdivinados()!=8){
                lista.add("0");
            }
        }
        ((TextView) findViewById(R.id.textViewTerminoMemoria)).setText("");
        flashBtns();
    }

    public void flashBtns(){
        Handler handler = new Handler();
        String[] array = new String[16];
        Arrays.fill(array, "-");

        textoABtns(juegoMemoria.getValores());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textoABtns(array);
                estado="jugando";
                juegoMemoria.iniciarJuego();
            }
        }, 1000);
    }

    public void alPresionar(View view){
        assert view instanceof Button;
        Button btnPresionado = (Button) view;
        if(!lockedBtns.contains(btnPresionado) && estado.equals("jugando")){
            revelarValorBtn(btnPresionado);
            Log.d("msgAS","Presionado: "+ getBtnText(btnPresionado));
            if(ultimoBtn==null){
                ultimoBtn=btnPresionado;
            }else if(btnPresionado!=ultimoBtn){
                if(getBtnText(btnPresionado).equals(getBtnText(ultimoBtn))){
                    Log.d("msgAS", "Par: "+getBtnText(ultimoBtn)+" y "+ getBtnText(btnPresionado));
                    lockedBtns.add(ultimoBtn);
                    lockedBtns.add(btnPresionado);
                    juegoMemoria.actualizarPares(getBtnIndex(ultimoBtn),getBtnIndex(btnPresionado));
                    Log.d("msgAS","Pares adivinados: "+ String.valueOf(juegoMemoria.getParesAdivinados())+" Ultimo par adivinado: "+getBtnText(btnPresionado));
                    if(juegoMemoria.getParesAdivinados()==8){
                        long tFinal = System.currentTimeMillis();
                        long tDif = tFinal - juegoMemoria.gettInicio();
                        double tMinutos = tDif/60000.0;
                        ((TextView) findViewById(R.id.textViewTerminoMemoria)).setText("Terminó en "+String.format("%.2f",tMinutos)+ " minutos");
                        lista.add(String.format("%.2f",tMinutos));
                    }
                }
                ultimoBtn=null;
                Handler handler =new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textoABtns(juegoMemoria.getValoresMostrados());
                    }
                }, 300);
            }
        }
    }

    public void revelarValorBtn(Button btn){
        switch (btn.getId()){
            case (R.id.btnMemoria0):
                btn.setText(juegoMemoria.getValores()[0]);
                break;
            case (R.id.btnMemoria1):
                btn.setText(juegoMemoria.getValores()[1]);
                break;
            case (R.id.btnMemoria2):
                btn.setText(juegoMemoria.getValores()[2]);
                break;
            case (R.id.btnMemoria3):
                btn.setText(juegoMemoria.getValores()[3]);
                break;
            case (R.id.btnMemoria4):
                btn.setText(juegoMemoria.getValores()[4]);
                break;
            case (R.id.btnMemoria5):
                btn.setText(juegoMemoria.getValores()[5]);
                break;
            case (R.id.btnMemoria6):
                btn.setText(juegoMemoria.getValores()[6]);
                break;
            case (R.id.btnMemoria7):
                btn.setText(juegoMemoria.getValores()[7]);
                break;
            case (R.id.btnMemoria8):
                btn.setText(juegoMemoria.getValores()[8]);
                break;
            case (R.id.btnMemoria9):
                btn.setText(juegoMemoria.getValores()[9]);
                break;
            case (R.id.btnMemoria10):
                btn.setText(juegoMemoria.getValores()[10]);
                break;
            case (R.id.btnMemoria11):
                btn.setText(juegoMemoria.getValores()[11]);
                break;
            case (R.id.btnMemoria12):
                btn.setText(juegoMemoria.getValores()[12]);
                break;
            case (R.id.btnMemoria13):
                btn.setText(juegoMemoria.getValores()[13]);
                break;
            case (R.id.btnMemoria14):
                btn.setText(juegoMemoria.getValores()[14]);
                break;
            case (R.id.btnMemoria15):
                btn.setText(juegoMemoria.getValores()[15]);
                break;

        }
    }

    private String getBtnText(Button btn){
        switch (btn.getId()){
            case (R.id.btnMemoria0):
                return juegoMemoria.getValores()[0];
            case (R.id.btnMemoria1):
                return juegoMemoria.getValores()[1];
            case (R.id.btnMemoria2):
                return juegoMemoria.getValores()[2];
            case (R.id.btnMemoria3):
                return juegoMemoria.getValores()[3];
            case (R.id.btnMemoria4):
                return juegoMemoria.getValores()[4];
            case (R.id.btnMemoria5):
                return juegoMemoria.getValores()[5];
            case (R.id.btnMemoria6):
                return juegoMemoria.getValores()[6];
            case (R.id.btnMemoria7):
                return juegoMemoria.getValores()[7];
            case (R.id.btnMemoria8):
                return juegoMemoria.getValores()[8];
            case (R.id.btnMemoria9):
                return juegoMemoria.getValores()[9];
            case (R.id.btnMemoria10):
                return juegoMemoria.getValores()[10];
            case (R.id.btnMemoria11):
                return juegoMemoria.getValores()[11];
            case (R.id.btnMemoria12):
                return juegoMemoria.getValores()[12];
            case (R.id.btnMemoria13):
                return juegoMemoria.getValores()[13];
            case (R.id.btnMemoria14):
                return juegoMemoria.getValores()[14];
            case (R.id.btnMemoria15):
                return juegoMemoria.getValores()[15];
            default:
                return "";
        }
    }

    private int getBtnIndex(Button btn){
        switch (btn.getId()){
            case (R.id.btnMemoria1):
                return 1;
            case (R.id.btnMemoria2):
                return 2;
            case (R.id.btnMemoria3):
                return 3;
            case (R.id.btnMemoria4):
                return 4;
            case (R.id.btnMemoria5):
                return 5;
            case (R.id.btnMemoria6):
                return 6;
            case (R.id.btnMemoria7):
                return 7;
            case (R.id.btnMemoria8):
                return 8;
            case (R.id.btnMemoria9):
                return 9;
            case (R.id.btnMemoria10):
                return 10;
            case (R.id.btnMemoria11):
                return 11;
            case (R.id.btnMemoria12):
                return 12;
            case (R.id.btnMemoria13):
                return 13;
            case (R.id.btnMemoria14):
                return 14;
            case (R.id.btnMemoria15):
                return 15;
            default:
                return 0;
        }
    }

    public void textoABtns(String[] textos){
        ((Button)  findViewById(R.id.btnMemoria0)).setText(textos[0]);
        ((Button)  findViewById(R.id.btnMemoria1)).setText(textos[1]);
        ((Button)  findViewById(R.id.btnMemoria2)).setText(textos[2]);
        ((Button)  findViewById(R.id.btnMemoria3)).setText(textos[3]);
        ((Button)  findViewById(R.id.btnMemoria4)).setText(textos[4]);
        ((Button)  findViewById(R.id.btnMemoria5)).setText(textos[5]);
        ((Button)  findViewById(R.id.btnMemoria6)).setText(textos[6]);
        ((Button)  findViewById(R.id.btnMemoria7)).setText(textos[7]);
        ((Button)  findViewById(R.id.btnMemoria8)).setText(textos[8]);
        ((Button)  findViewById(R.id.btnMemoria9)).setText(textos[9]);
        ((Button)  findViewById(R.id.btnMemoria10)).setText(textos[10]);
        ((Button)  findViewById(R.id.btnMemoria11)).setText(textos[11]);
        ((Button)  findViewById(R.id.btnMemoria12)).setText(textos[12]);
        ((Button)  findViewById(R.id.btnMemoria13)).setText(textos[13]);
        ((Button)  findViewById(R.id.btnMemoria14)).setText(textos[14]);
        ((Button)  findViewById(R.id.btnMemoria15)).setText(textos[15]);
    }

    @Override
    protected void onRestart() {
        primera=1;
        crearNuevoJuego();
        super.onRestart();
    }
}