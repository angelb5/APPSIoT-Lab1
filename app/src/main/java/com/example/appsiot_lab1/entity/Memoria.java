package com.example.appsiot_lab1.entity;

import android.util.Log;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Memoria {
    public Memoria() {
        paresAdivinados=0;
        sortValores();
        tInicio=System.currentTimeMillis();
        Log.d("msgAs",String.valueOf(tInicio));
    }

    public long gettInicio() {
        return tInicio;
    }

    public void settInicio(long tInicio) {
        this.tInicio = tInicio;
    }

    public String[] getValores() {
        return valores;
    }

    public void setValores(String[] valores) {
        this.valores = valores;
    }

    public int getParesAdivinados() {
        return paresAdivinados;
    }

    public void setParesAdivinados(int paresAdivinados) {
        this.paresAdivinados = paresAdivinados;
    }

    private String[] valores = {"A","A","B","B","C","C","D","D","E","E","F","F","G","G","H","H"};
    private int paresAdivinados =0;
    private long tInicio;

    public void sortValores(){
        Random rnd = ThreadLocalRandom.current();
        for (int i = valores.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = valores[index];
            valores[index] = valores[i];
            valores[i] = a;
        }
    }

    public void agregarParAdivinado(){
        paresAdivinados++;
    }
}
