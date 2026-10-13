package view;

import model.domain.Gol;
import model.domain.Jugador;
import model.domain.Partido;
import service.PartidoService;
import utils.ConsoleUtils;

public class MenuPilaView {
    private final PartidoService partidoService;
    private final Partido partido;

    public MenuPilaView(PartidoService partidoService, Partido partido) {
        this.partidoService = partidoService;
        this.partido = partido;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opcion: ");
            try {
                switch (opcion) {
                    case 1 -> registrar();
                    case 2 -> deshacer();
                    case 3 -> consultarUltima();
                    case 4 -> verSiHayOperaciones();
                    case 5 -> contar();
                    case 6 -> listar();
                    case 0 -> System.out.println("Saliendo del menu de pilas...");
                    default -> System.out.println("Opcion invalida");
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n=== Liga de Futbol - Pilas (Goles) ===");
        System.out.println("1. Registrar gol (push)");
        System.out.println("2. Deshacer ultimo gol (pop)");
        System.out.println("3. Ver ultimo gol (peek)");
        System.out.println("4. Hay goles por deshacer? (isEmpty)");
        System.out.println("5. Cantidad de goles recientes (size)");
        System.out.println("6. Listar goles recientes");
        System.out.println("0. Salir");
    }

    private void registrar() {
        int minuto = ConsoleUtils.leerEntero("Minuto: ");
        String tipo = ConsoleUtils.leerTexto("Tipo (normal/penalti/autogol): ");
        String idJugador = ConsoleUtils.leerTexto("Identificacion del jugador: ");
        String nombreJugador = ConsoleUtils.leerTexto("Nombre del jugador: ");
        Jugador jugador = new Jugador(idJugador, nombreJugador, 0, "", 0);
        Gol gol = new Gol(minuto, tipo, jugador);
        partidoService.agregarGol(partido, gol);
        System.out.println("Gol registrado en la pila.");
    }

    private void deshacer() {
        Gol gol = partidoService.deshacerUltimoGol(partido);
        System.out.println("Gol deshecho: minuto " + gol.getMinuto()
                + " | Tipo: " + gol.getTipo()
                + " | Jugador: " + gol.getJugador().getNombre());
    }

    private void consultarUltima() {
        Gol gol = partidoService.consultarUltimoGol(partido);
        System.out.println("Ultimo gol: minuto " + gol.getMinuto()
                + " | Tipo: " + gol.getTipo()
                + " | Jugador: " + gol.getJugador().getNombre());
    }

    private void verSiHayOperaciones() {
        if (partidoService.sinGolesPorDeshacer(partido)) {
            System.out.println("No hay operaciones por deshacer");
        } else {
            System.out.println("Hay operaciones");
        }
    }

    private void contar() {
        int cantidad = partidoService.contarGolesRecientes(partido);
        System.out.println("Cantidad de goles recientes: " + cantidad);
    }

    private void listar() {
        System.out.print(partidoService.listarGolesRecientes(partido));
    }
}
