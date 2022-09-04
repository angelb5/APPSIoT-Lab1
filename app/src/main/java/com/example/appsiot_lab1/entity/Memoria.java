package com.example.appsiot_lab1.entity;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Memoria {
    public Memoria() {
        sortValores();
        tInicio=System.currentTimeMillis();
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

    public String[] getValoresMostrados() {
        return valoresMostrados;
    }

    public void setValoresMostrados(String[] valoresMostrados) {
        this.valoresMostrados = valoresMostrados;
    }

    private String[] valores = {"A","A","B","B","C","C","D","D","E","E","F","F","G","G","H","H"};
    private String[] valoresMostrados = {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"};
    private int paresAdivinados =0;
    private long tInicio;

    public void sortValores(){
        Random rnd = new Random();
        for (int i = valores.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            String a = valores[index];
            valores[index] = valores[i];
            valores[i] = a;
        }
    }

    public void iniciarJuego(){
        paresAdivinados=0;
        Arrays.fill(valoresMostrados, "-");
    }

    public void actualizarPares(int index1, int index2){
        valoresMostrados[index1]=valores[index1];
        valoresMostrados[index2]=valores[index2];
        paresAdivinados++;
    }
}
