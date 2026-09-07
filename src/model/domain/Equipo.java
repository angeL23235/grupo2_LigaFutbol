package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> jugadores;
    
    public Equipo() {
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
        System.out.println("El jugador se ha añadido");
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}