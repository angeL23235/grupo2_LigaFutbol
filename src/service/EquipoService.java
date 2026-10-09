package service;

import model.domain.Equipo;
import model.domain.Jugador;
import structures.ListaSimple;

public class EquipoService {

    public void agregarJugador(Equipo equipo, Jugador jugador) {
        equipo.getJugadores().insertarFinal(jugador);
        System.out.println("Jugador agregado.");
    }

    public Jugador buscarJugadorPorIdentificacion(Equipo equipo, String identificacion) {
        Jugador busqueda = new Jugador(identificacion, "", 0, "", 0);
        return equipo.getJugadores().buscarPorValor(busqueda);
    }

    public Jugador buscarJugadorPorIndice(Equipo equipo, int indice) {
        return equipo.getJugadores().buscarPorIndice(indice);
    }

    public void listarJugadores(Equipo equipo) {
        ListaSimple<Jugador> lista = equipo.getJugadores();
        if (lista.estaVacia()) {
            System.out.println("No hay jugadores en el equipo.");
            return;
        }
        for (int i = 0; i < lista.getTamano(); i++) {
            Jugador jugador = lista.buscarPorIndice(i);
            System.out.println("Indice: " + i + " | ID: " + jugador.getIdentificacion()
                    + " | Nombre: " + jugador.getNombre()
                    + " | Camiseta: " + jugador.getNumeroCamiseta());
        }
    }

    public boolean eliminarJugador(Equipo equipo, String identificacion) {
        Jugador busqueda = new Jugador(identificacion, "", 0, "", 0);
        boolean eliminado = equipo.getJugadores().eliminarPorValor(busqueda);
        if (eliminado) {
            System.out.println("Jugador eliminado.");
        } else {
            System.out.println("No se pudo eliminar el jugador.");
        }
        return eliminado;
    }
}
