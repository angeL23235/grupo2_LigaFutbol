package model.domain;

import model.structures.Cola;

public class Jornada {
    private int numero;
    private Cola<Partido> fila;

    public Jornada(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El numero de jornada debe ser mayor que cero");
        }
        this.numero = numero;
        this.fila = new Cola<>();
    }

    public int getNumero() {
        return numero;
    }

    public Cola<Partido> getFila() {
        return fila;
    }
}
