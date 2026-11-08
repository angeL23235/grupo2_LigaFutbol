package view;

import service.HistorialResultadosService;
import utils.ConsoleUtils;

public class MenuHistorialView {
    private final HistorialResultadosService historialService;

    public MenuHistorialView(HistorialResultadosService historialService) {
        this.historialService = historialService;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opcion: ");
            switch (opcion) {
                case 1 -> registrar();
                case 2 -> System.out.print(historialService.listarPartidosEnOrden());
                case 3 -> System.out.print(historialService.listarPartidosEnOrdenInverso());
                case 4 -> verAnterior();
                case 5 -> verSiguiente();
                case 6 -> anular();
                case 7 -> guardar();
                case 0 -> guardar();
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n=== Liga de Futbol - Historial de resultados ===");
        System.out.println("1. Registrar resultado");
        System.out.println("2. Listar del primero al ultimo");
        System.out.println("3. Listar del ultimo al primero");
        System.out.println("4. Ver resultado anterior");
        System.out.println("5. Ver resultado siguiente");
        System.out.println("6. Anular el resultado que estoy mirando");
        System.out.println("7. Guardar");
        System.out.println("0. Guardar y salir");
    }

    private void registrar() {
        String fecha = ConsoleUtils.leerTexto("Fecha (yyyy-MM-dd): ");
        if (!historialService.fechaValida(fecha)) {
            System.out.println("Fecha invalida");
            return;
        }
        String local = ConsoleUtils.leerTexto("Equipo local: ");
        String visitante = ConsoleUtils.leerTexto("Equipo visitante: ");
        if (!historialService.existeEquipo(local) || !historialService.existeEquipo(visitante)) {
            System.out.println("El equipo no existe");
            return;
        }
        int golesLocal = ConsoleUtils.leerEntero("Goles local: ");
        int golesVisitante = ConsoleUtils.leerEntero("Goles visitante: ");
        historialService.registrarResultado(fecha, local, visitante, golesLocal, golesVisitante);
        System.out.println("Resultado registrado");
    }

    private void verAnterior() {
        if (historialService.sinPartidos() || !historialService.hayPartidoAnterior()) {
            System.out.println("No hay resultado anterior");
            return;
        }
        System.out.println(historialService.verPartidoAnterior());
    }

    private void verSiguiente() {
        if (historialService.sinPartidos() || !historialService.hayPartidoSiguiente()) {
            System.out.println("No hay resultado siguiente");
            return;
        }
        System.out.println(historialService.verPartidoSiguiente());
    }

    private void anular() {
        if (!historialService.hayPartidoSeleccionado()) {
            System.out.println("No hay un resultado seleccionado");
            return;
        }
        System.out.println(historialService.anularResultado());
    }

    private void guardar() {
        System.out.println(historialService.guardarResultados());
    }
}
