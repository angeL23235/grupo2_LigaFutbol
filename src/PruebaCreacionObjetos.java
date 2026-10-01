import model.domain.Persona;
import model.domain.Jugador;
import model.domain.Arbitro;
import model.domain.Equipo;

import java.util.ArrayList;
import java.util.List;

public class PruebaCreacionObjetos {
    public static void main(String[] args) {
        // Instancia
        Jugador jugador1 = new Jugador("123", "SebasKA", 10, "Delantero", 12);
        Arbitro arbitro1 = new Arbitro("2020", "KevinSA", "Lateral");

        // Composición
        Equipo equipo = new Equipo();
        equipo.agregarJugador(jugador1);

        // Polimorfismo
        List<Persona> participantes = new ArrayList<>();
        participantes.add(jugador1);
        participantes.add(arbitro1);

        for (Persona p : participantes) {
            System.out.println("Nombre: " + p.getNombre() + " Rol: " + p.rolEnPartido());
        }
    }
}