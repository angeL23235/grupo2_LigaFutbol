package view;

import java.util.List;

import model.domain.Equipo;
import model.domain.Jugador;
import utils.ConsoleUtils;

public class MenuView {
    private final Equipo equipo = new Equipo();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> agregarJugador();
                case 2 -> listarJugadores();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        ConsoleUtils.cerrar();
    }

    private void mostrarMenu() {
        System.out.println("1. Agregar jugador");
        System.out.println("2. Listar jugadores");
        System.out.println("0. Salir");
    }

    private void agregarJugador() {
        String identificacion = ConsoleUtils.leerTexto("Identificacion: ");
        String nombre = ConsoleUtils.leerTexto("Nombre: ");
        int numeroCamiseta = ConsoleUtils.leerEntero("Numero de camiseta: ");
        String posicion = ConsoleUtils.leerTexto("Posicion: ");
        int golesTotales = ConsoleUtils.leerEntero("Goles totales: ");

        Jugador jugador = new Jugador(identificacion, nombre, numeroCamiseta, posicion, golesTotales);
        equipo.agregarJugador(jugador);
    }

    private void listarJugadores() {
        List<Jugador> jugadores = equipo.getJugadores();
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " | " + jugador.getPosicion() + " | " + jugador.getNumeroCamiseta());
        }
    }
}