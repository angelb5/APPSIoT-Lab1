package com.example.appsiot_lab1;

import androidx.appcompat.app.AppCompatActivity;

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
    private String ultimoValor;
    private Button ultimoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        crearNuevoJuego();
        findViewById(R.id.btnNuevoMemoria).setOnClickListener(view -> crearNuevoJuego());

    }

    public void crearNuevoJuego(){
        juegoMemoria = new Memoria();
        ultimoValor = "";
        ultimoBtn = null;
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
            }
        }, 1000);
    }

    public void alPresionar(View view){
        assert view instanceof Button;
        Button btnPresionado = (Button) view;
        mostrarValorBtn(btnPresionado);
        if(ultimoBtn==null){
            ultimoBtn=btnPresionado;
            ultimoValor= btnPresionado.getText().toString();
            Log.d("msgAS","El ultimo valor fue "+ultimoValor);
        }else if(btnPresionado!=ultimoBtn){
            if(btnPresionado.getText().toString().equals(ultimoValor)){
                juegoMemoria.agregarParAdivinado();
                Log.d("msgAS",String.valueOf(juegoMemoria.getParesAdivinados()));
                if(juegoMemoria.getParesAdivinados()==8){
                    long tFinal = System.currentTimeMillis();
                    long tDif = tFinal - juegoMemoria.gettInicio();
                    double tMinutos = tDif/60000.0;
                    ((TextView) findViewById(R.id.textViewTerminoMemoria)).setText("Termino en "+tMinutos+ " minutos");
                }
                ultimoBtn=null;
                ultimoValor="";
            }else{
                final ArrayList<Button> btnsABorrar = new ArrayList<>();
                btnsABorrar.add(ultimoBtn);
                btnsABorrar.add(btnPresionado);
                ultimoBtn=null;
                ultimoValor="";
                Handler handler =new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(Button btn : btnsABorrar){
                            btn.setText("-");
                        }
                    }
                }, 300);
            }

        }
    }

    public void mostrarValorBtn(Button btn){
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

}