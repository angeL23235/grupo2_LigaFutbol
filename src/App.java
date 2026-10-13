import java.time.LocalDate;

import model.domain.Equipo;
import model.domain.Partido;
import service.EquipoService;
import service.PartidoService;
import utils.ConsoleUtils;
import view.MenuListasView;
import view.MenuPilaView;

public class App {
    public static void main(String[] args) {
        EquipoService equipoService = new EquipoService();
        PartidoService partidoService = new PartidoService();
        Equipo equipo = new Equipo();
        Partido partido = new Partido(LocalDate.now(), "0-0", new Equipo(), new Equipo());

        MenuListasView menuListas = new MenuListasView(equipoService, partidoService, equipo, partido);
        MenuPilaView menuPila = new MenuPilaView(partidoService, partido);

        int opcion;
        do {
            System.out.println("\n=== Liga de Futbol ===");
            System.out.println("1. Menu de listas");
            System.out.println("2. Menu de pilas (goles)");
            System.out.println("0. Salir");
            opcion = ConsoleUtils.leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> menuListas.iniciar();
                case 2 -> menuPila.iniciar();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        ConsoleUtils.cerrar();
    }
}
