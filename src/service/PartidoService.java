package service;

import model.domain.Gol;
import model.domain.Jugador;
import model.domain.Partido;
import model.structures.ListaSimple;
import model.structures.Pila;

public class PartidoService {

    public void agregarGol(Partido partido, Gol gol) {
        if (gol == null) {
            throw new IllegalArgumentException("El gol no puede ser null");
        }
        partido.getGoles().insertarFinal(gol);
        partido.getGolesRecientes().push(gol);
        System.out.println("Gol agregado.");
    }

    public Gol buscarGolPorMinutoYJugador(Partido partido, int minuto, String idJugador) {
        Jugador jugadorBusqueda = new Jugador(idJugador, "", 0, "", 0);
        Gol busqueda = new Gol(minuto, "", jugadorBusqueda);
        Gol encontrado = partido.getGoles().buscarPorValor(busqueda);
        if (encontrado == null) {
            System.out.println("Gol no encontrado.");
        }
        return encontrado;
    }

    public Gol buscarGolPorIndice(Partido partido, int indice) {
        ListaSimple<Gol> lista = partido.getGoles();
        if (indice < 0 || indice >= lista.getTamano()) {
            System.out.println("Indice fuera de rango.");
            return null;
        }
        return lista.buscarPorIndice(indice);
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

    public Gol deshacerUltimoGol(Partido partido) {
        Gol gol = partido.getGolesRecientes().pop();
        partido.getGoles().eliminarPorValor(gol);
        return gol;
    }

    public Gol consultarUltimoGol(Partido partido) {
        return partido.getGolesRecientes().peek();
    }

    public boolean sinGolesPorDeshacer(Partido partido) {
        return partido.getGolesRecientes().isEmpty();
    }

    public int contarGolesRecientes(Partido partido) {
        return partido.getGolesRecientes().size();
    }

    public String listarGolesRecientes(Partido partido) {
        Pila<Gol> original = partido.getGolesRecientes();
        if (original.isEmpty()) {
            return "No hay operaciones por deshacer";
        }

        Pila<Gol> auxiliar = new Pila<>();
        StringBuilder texto = new StringBuilder();
        int contador = 1;

        while (!original.isEmpty()) {
            Gol gol = original.pop();
            texto.append(contador)
                    .append(". Minuto ")
                    .append(gol.getMinuto())
                    .append(" | Tipo: ")
                    .append(gol.getTipo())
                    .append(" | Jugador: ")
                    .append(gol.getJugador().getNombre())
                    .append(System.lineSeparator());
            auxiliar.push(gol);
            contador++;
        }

        while (!auxiliar.isEmpty()) {
            original.push(auxiliar.pop());
        }

        return texto.toString();
    }
}
