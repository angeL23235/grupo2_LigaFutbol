package model.domain;

import structures.ListaSimple;

public class Equipo {
    private ListaSimple<Jugador> jugadores;

    public Equipo() {
        this.jugadores = new ListaSimple<>();
    }

    public ListaSimple<Jugador> getJugadores() {
        return jugadores;
    }
}
