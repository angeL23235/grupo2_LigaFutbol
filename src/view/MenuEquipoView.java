package view;

import service.EquipoService;
import utils.ConsoleUtils;

public class MenuEquipoView {
    private final EquipoService equipoService;

    public MenuEquipoView(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opcion: ");
            switch (opcion) {
                case 1 -> registrar();
                case 2 -> System.out.print(equipoService.listarEquipos());
                case 3 -> System.out.println(equipoService.guardarEquipos());
                case 0 -> System.out.println("Saliendo del menu de equipos...");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n=== Liga de Futbol - Equipos ===");
        System.out.println("1. Registrar equipo");
        System.out.println("2. Listar equipos");
        System.out.println("3. Guardar");
        System.out.println("0. Salir");
    }

    private void registrar() {
        String nombre = ConsoleUtils.leerTexto("Nombre: ");
        String ciudad = ConsoleUtils.leerTexto("Ciudad: ");
        String entrenador = ConsoleUtils.leerTexto("Entrenador: ");
        if (nombre.isBlank() || ciudad.isBlank() || entrenador.isBlank()) {
            System.out.println("Los datos del equipo no pueden estar vacios");
            return;
        }
        equipoService.registrarEquipo(nombre, ciudad, entrenador);
        System.out.println("Equipo registrado");
    }
}
