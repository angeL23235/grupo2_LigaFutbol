package model.domain;

import model.structures.ListaSimple;

public class Equipo {
    private String nombre;
    private String ciudad;
    private String entrenador;
    private ListaSimple<Jugador> jugadores;

    public Equipo() {
        this.jugadores = new ListaSimple<>();
    }

    public Equipo(String nombre, String ciudad, String entrenador) {
        this();
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public ListaSimple<Jugador> getJugadores() {
        return jugadores;
    }
}
