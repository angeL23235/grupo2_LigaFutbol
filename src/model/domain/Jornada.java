package model.domain;

import model.structures.Cola;

public class Jornada {
    int numero;
    Cola<Partido> fila;

    public int getNumero() {
        return numero;
    }
    public Cola<Partido> getFila() {
        return fila;
    }
    
}
