package service;

import model.domain.Gol;
import model.domain.Jugador;
import model.domain.Partido;
import structures.ListaSimple;

public class PartidoService {

    public void agregarGol(Partido partido, Gol gol) {
        partido.getGoles().insertarFinal(gol);
        System.out.println("Gol agregado.");
    }

    public Gol buscarGolPorMinutoYJugador(Partido partido, int minuto, String idJugador) {
        Jugador jugadorBusqueda = new Jugador(idJugador, "", 0, "", 0);
        Gol busqueda = new Gol(minuto, "", jugadorBusqueda);
        return partido.getGoles().buscarPorValor(busqueda);
    }

    public Gol buscarGolPorIndice(Partido partido, int indice) {
        return partido.getGoles().buscarPorIndice(indice);
    }

    public void listarGoles(Partido partido) {
        ListaSimple<Gol> lista = partido.getGoles();
        if (lista.estaVacia()) {
            System.out.println("No hay goles en el partido.");
            return;
        }
        for (int i = 0; i < lista.getTamano(); i++) {
            Gol gol = lista.buscarPorIndice(i);
            System.out.println("Indice: " + i
                    + " | Minuto: " + gol.getMinuto()
                    + " | Tipo: " + gol.getTipo()
                    + " | Jugador: " + gol.getJugador().getNombre());
        }
    }

    public boolean eliminarGol(Partido partido, int minuto, String idJugador) {
        Jugador jugadorBusqueda = new Jugador(idJugador, "", 0, "", 0);
        Gol busqueda = new Gol(minuto, "", jugadorBusqueda);
        boolean eliminado = partido.getGoles().eliminarPorValor(busqueda);
        if (eliminado) {
            System.out.println("Gol eliminado.");
        } else {
            System.out.println("No se pudo eliminar el gol.");
        }
        return eliminado;
    }
}
