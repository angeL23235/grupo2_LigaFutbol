package view;

import model.domain.Partido;
import service.JornadaService;
import utils.ConsoleUtils;

public class MenuColaView {
    private final JornadaService jornadaService;

    public MenuColaView(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opcion: ");
            switch (opcion) {
                case 1 -> registrarLlegada();
                case 2 -> atender();
                case 3 -> consultarSiguiente();
                case 4 -> verSiHayEnEspera();
                case 5 -> contar();
                case 6 -> listar();
                case 0 -> System.out.println("Saliendo del menu de colas...");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n=== Liga de Futbol - Colas (Jornada) ===");
        System.out.println("1. Programar partido (enqueue)");
        System.out.println("2. Jugar siguiente partido (dequeue)");
        System.out.println("3. Ver quien sigue (front)");
        System.out.println("4. Hay partidos en espera? (isEmpty)");
        System.out.println("5. Cantidad en espera (size)");
        System.out.println("6. Listar la fila");
        System.out.println("0. Salir");
    }

    private void registrarLlegada() {
        String descripcion = ConsoleUtils.leerTexto("Descripcion del partido (ej. Local vs Visitante): ");
        jornadaService.programarPartido(descripcion);
        System.out.println("Partido programado en la fila exitosamente");
    }

    private void atender() {
        if (jornadaService.sinPartidosEnEspera()) {
            System.out.println("No hay partidos en espera");
            return;
        }
        Partido jugado = jornadaService.jugarSiguientePartido();
        System.out.println("Se jugo: " + jugado.getResultado());
    }

    private void consultarSiguiente() {
        if (jornadaService.sinPartidosEnEspera()) {
            System.out.println("No hay partidos en espera");
            return;
        }
        Partido siguiente = jornadaService.consultarSiguientePartido();
        System.out.println("Sigue: " + siguiente.getResultado());
    }

    private void verSiHayEnEspera() {
        if (jornadaService.sinPartidosEnEspera()) {
            System.out.println("No hay partidos en espera");
        } else {
            System.out.println("Hay partidos en espera");
        }
    }

    private void contar() {
        System.out.println("Partidos en espera: " + jornadaService.contarEnEspera());
    }

    private void listar() {
        System.out.print(jornadaService.listarEnEspera());
    }
}
