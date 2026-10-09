package view;

import java.time.LocalDate;

import model.domain.Equipo;
import model.domain.Gol;
import model.domain.Jugador;
import model.domain.Partido;
import service.EquipoService;
import service.PartidoService;
import utils.ConsoleUtils;

public class MenuListasView {
    private EquipoService equipoService = new EquipoService();
    private PartidoService partidoService = new PartidoService();
    private Equipo equipo = new Equipo();
    private Partido partido = new Partido(LocalDate.now(), "0-0", new Equipo(), new Equipo());

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> agregarJugador();
                case 2 -> buscarJugadorPorIndice();
                case 3 -> buscarJugadorPorIdentificacion();
                case 4 -> listarJugadores();
                case 5 -> eliminarJugador();
                case 6 -> agregarGol();
                case 7 -> buscarGolPorIndice();
                case 8 -> buscarGol();
                case 9 -> listarGoles();
                case 10 -> eliminarGol();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        ConsoleUtils.cerrar();
    }

    private void mostrarMenu() {
        System.out.println("\n=== Liga de Futbol - Listas ===");
        System.out.println("--- Equipo -> Jugadores ---");
        System.out.println("1. Agregar jugador");
        System.out.println("2. Buscar jugador por indice");
        System.out.println("3. Buscar jugador por identificacion");
        System.out.println("4. Listar jugadores");
        System.out.println("5. Eliminar jugador");
        System.out.println("--- Partido -> Goles ---");
        System.out.println("6. Agregar gol");
        System.out.println("7. Buscar gol por indice");
        System.out.println("8. Buscar gol por minuto e id jugador");
        System.out.println("9. Listar goles");
        System.out.println("10. Eliminar gol");
        System.out.println("0. Salir");
    }

    private void agregarJugador() {
        String identificacion = ConsoleUtils.leerTexto("Identificacion: ");
        String nombre = ConsoleUtils.leerTexto("Nombre: ");
        int camiseta = ConsoleUtils.leerEntero("Numero de camiseta: ");
        String posicion = ConsoleUtils.leerTexto("Posicion: ");
        int goles = ConsoleUtils.leerEntero("Goles totales: ");
        Jugador jugador = new Jugador(identificacion, nombre, camiseta, posicion, goles);
        equipoService.agregarJugador(equipo, jugador);
    }

    private void buscarJugadorPorIndice() {
        int indice = ConsoleUtils.leerEntero("Indice del jugador: ");
        try {
            Jugador jugador = equipoService.buscarJugadorPorIndice(equipo, indice);
            System.out.println("Jugador: " + jugador.getNombre() + " | ID: " + jugador.getIdentificacion());
        } catch (Exception e) {
            System.out.println("Jugador no encontrado.");
        }
    }

    private void buscarJugadorPorIdentificacion() {
        String identificacion = ConsoleUtils.leerTexto("Identificacion: ");
        Jugador jugador = equipoService.buscarJugadorPorIdentificacion(equipo, identificacion);
        if (jugador != null) {
            System.out.println("Jugador: " + jugador.getNombre() + " | Camiseta: " + jugador.getNumeroCamiseta());
        }
    }

    private void listarJugadores() {
        equipoService.listarJugadores(equipo);
    }

    private void eliminarJugador() {
        String identificacion = ConsoleUtils.leerTexto("Identificacion del jugador a eliminar: ");
        equipoService.eliminarJugador(equipo, identificacion);
    }

    private void agregarGol() {
        int minuto = ConsoleUtils.leerEntero("Minuto: ");
        String tipo = ConsoleUtils.leerTexto("Tipo (normal/penalti/autogol): ");
        String idJugador = ConsoleUtils.leerTexto("Identificacion del jugador: ");
        String nombreJugador = ConsoleUtils.leerTexto("Nombre del jugador: ");
        Jugador jugador = new Jugador(idJugador, nombreJugador, 0, "", 0);
        Gol gol = new Gol(minuto, tipo, jugador);
        partidoService.agregarGol(partido, gol);
    }

    private void buscarGolPorIndice() {
        int indice = ConsoleUtils.leerEntero("Indice del gol: ");
        try {
            Gol gol = partidoService.buscarGolPorIndice(partido, indice);
            System.out.println("Gol minuto " + gol.getMinuto() + " | Tipo: " + gol.getTipo()
                    + " | Jugador: " + gol.getJugador().getNombre());
        } catch (Exception e) {
            System.out.println("Gol no encontrado.");
        }
    }

    private void buscarGol() {
        int minuto = ConsoleUtils.leerEntero("Minuto: ");
        String idJugador = ConsoleUtils.leerTexto("Identificacion del jugador: ");
        Gol gol = partidoService.buscarGolPorMinutoYJugador(partido, minuto, idJugador);
        if (gol != null) {
            System.out.println("Gol encontrado | Tipo: " + gol.getTipo()
                    + " | Jugador: " + gol.getJugador().getNombre());
        }
    }

    private void listarGoles() {
        partidoService.listarGoles(partido);
    }

    private void eliminarGol() {
        int minuto = ConsoleUtils.leerEntero("Minuto del gol a eliminar: ");
        String idJugador = ConsoleUtils.leerTexto("Identificacion del jugador: ");
        partidoService.eliminarGol(partido, minuto, idJugador);
    }
}
