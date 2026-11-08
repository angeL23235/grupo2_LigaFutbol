package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.domain.Equipo;
import model.domain.Jugador;
import model.structures.ListaSimple;

public class EquipoService {
    private static final String ARCHIVO_EQUIPOS = "data/equipos.txt";
    private static final String SEPARADOR = ";";
    private final ListaSimple<Equipo> equipos = new ListaSimple<>();

    public EquipoService() {
        cargarEquipos();
    }

    public void registrarEquipo(String nombre, String ciudad, String entrenador) {
        if (nombre == null || nombre.isBlank()
                || ciudad == null || ciudad.isBlank()
                || entrenador == null || entrenador.isBlank()) {
            throw new IllegalArgumentException("Los datos del equipo no pueden estar vacios");
        }
        equipos.insertarFinal(new Equipo(nombre, ciudad, entrenador));
    }

    public Equipo buscarPorNombre(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (int i = 0; i < equipos.getTamano(); i++) {
            Equipo equipo = equipos.buscarPorIndice(i);
            if (nombre.equals(equipo.getNombre())) {
                return equipo;
            }
        }
        return null;
    }

    public String listarEquipos() {
        if (equipos.estaVacia()) {
            return "No hay equipos";
        }
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < equipos.getTamano(); i++) {
            Equipo equipo = equipos.buscarPorIndice(i);
            texto.append(equipo.getNombre())
                    .append(" | ")
                    .append(equipo.getCiudad())
                    .append(" | ")
                    .append(equipo.getEntrenador())
                    .append(System.lineSeparator());
        }
        return texto.toString();
    }

    public String guardarEquipos() {
        try {
            escribirEquipos();
            return "Se guardaron " + equipos.getTamano() + " equipos en data/equipos.txt";
        } catch (IOException e) {
            return "No se pudo guardar: " + e.getMessage();
        }
    }

    public String cargarEquipos() {
        while (!equipos.estaVacia()) {
            equipos.eliminarInicio();
        }
        File archivo = new File(ARCHIVO_EQUIPOS);
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(SEPARADOR);
                if (campos.length != 3) {
                    continue;
                }
                equipos.insertarFinal(new Equipo(campos[0], campos[1], campos[2]));
            }
        } catch (FileNotFoundException e) {
            return "No existe data/equipos.txt; se inicia con la lista vacia";
        } catch (IOException e) {
            return "No se pudo leer: " + e.getMessage();
        }
        return "Se cargaron " + equipos.getTamano() + " equipos";
    }

    private void escribirEquipos() throws IOException {
        File archivo = new File(ARCHIVO_EQUIPOS);
        File carpeta = archivo.getParentFile();
        if (carpeta != null) {
            carpeta.mkdirs();
        }
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < equipos.getTamano(); i++) {
            Equipo equipo = equipos.buscarPorIndice(i);
            texto.append(String.join(SEPARADOR, equipo.getNombre(), equipo.getCiudad(), equipo.getEntrenador()));
            texto.append(System.lineSeparator());
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            escritor.write(texto.toString());
        }
    }

    public void agregarJugador(Equipo equipo, Jugador jugador) {
        equipo.getJugadores().insertarFinal(jugador);
        System.out.println("Jugador agregado.");
    }

    public Jugador buscarJugadorPorIdentificacion(Equipo equipo, String identificacion) {
        Jugador busqueda = new Jugador(identificacion, "", 0, "", 0);
        Jugador encontrado = equipo.getJugadores().buscarPorValor(busqueda);
        if (encontrado == null) {
            System.out.println("Jugador no encontrado.");
        }
        return encontrado;
    }

    public Jugador buscarJugadorPorIndice(Equipo equipo, int indice) {
        ListaSimple<Jugador> lista = equipo.getJugadores();
        if (indice < 0 || indice >= lista.getTamano()) {
            System.out.println("Indice fuera de rango.");
            return null;
        }
        return lista.buscarPorIndice(indice);
    }

    public void listarJugadores(Equipo equipo) {
        ListaSimple<Jugador> lista = equipo.getJugadores();
        if (lista.estaVacia()) {
            System.out.println("No hay jugadores en el equipo.");
            return;
        }
        for (int i = 0; i < lista.getTamano(); i++) {
            Jugador jugador = lista.buscarPorIndice(i);
            System.out.println("Indice: " + i + " | ID: " + jugador.getIdentificacion()
                    + " | Nombre: " + jugador.getNombre()
                    + " | Camiseta: " + jugador.getNumeroCamiseta());
        }
    }

    public boolean eliminarJugador(Equipo equipo, String identificacion) {
        Jugador busqueda = new Jugador(identificacion, "", 0, "", 0);
        boolean eliminado = equipo.getJugadores().eliminarPorValor(busqueda);
        if (eliminado) {
            System.out.println("Jugador eliminado.");
        } else {
            System.out.println("No se pudo eliminar el jugador.");
        }
        return eliminado;
    }
}
