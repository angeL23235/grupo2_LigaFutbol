package model.domain;

import model.structures.ListaSimple;

public class Equipo {
    private ListaSimple<Jugador> jugadores;

    public Equipo() {
        this.jugadores = new ListaSimple<>();
    }

    public ListaSimple<Jugador> getJugadores() {
        return jugadores;
    }
}
