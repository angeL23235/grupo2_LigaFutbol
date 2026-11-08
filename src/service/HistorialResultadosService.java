package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import model.domain.Equipo;
import model.domain.HistorialResultados;
import model.domain.Partido;
import model.structures.NodoDoble;

public class HistorialResultadosService {
    private static final String ARCHIVO_RESULTADOS = "data/resultados.txt";
    private static final String SEPARADOR = ";";
    private final EquipoService equipoService;
    private final HistorialResultados historial;

    public HistorialResultadosService(EquipoService equipoService) {
        this.equipoService = equipoService;
        this.historial = new HistorialResultados("2026");
        cargarResultados();
    }

    public void registrarResultado(String fecha, String nombreLocal, String nombreVisitante,
            int golesLocal, int golesVisitante) {
        if (!fechaValida(fecha)) {
            throw new IllegalArgumentException("Fecha invalida");
        }
        Equipo local = equipoService.buscarPorNombre(nombreLocal);
        Equipo visitante = equipoService.buscarPorNombre(nombreVisitante);
        if (local == null || visitante == null) {
            throw new IllegalArgumentException("El equipo no existe");
        }
        insertar(LocalDate.parse(fecha), local, visitante, golesLocal, golesVisitante);
    }

    public String listarPartidosEnOrden() {
        if (sinPartidos()) {
            return "No hay partidos en el historial";
        }
        return historial.getResultados().recorrerAdelante();
    }

    public String listarPartidosEnOrdenInverso() {
        if (sinPartidos()) {
            return "No hay partidos en el historial";
        }
        return historial.getResultados().recorrerAtras();
    }

    public Partido verPartidoAnterior() {
        return historial.getResultados().anterior();
    }

    public Partido verPartidoSiguiente() {
        return historial.getResultados().siguiente();
    }

    public Partido anularResultado() {
        return historial.getResultados().retirarActual();
    }

    public int contarPartidos() {
        return historial.getResultados().size();
    }

    public boolean sinPartidos() {
        return historial.getResultados().isEmpty();
    }

    public boolean hayPartidoAnterior() {
        return historial.getResultados().hayAnterior();
    }

    public boolean hayPartidoSiguiente() {
        return historial.getResultados().haySiguiente();
    }

    public boolean hayPartidoSeleccionado() {
        return historial.getResultados().hayActual();
    }

    public boolean existeEquipo(String nombre) {
        return equipoService.buscarPorNombre(nombre) != null;
    }

    public boolean fechaValida(String fecha) {
        if (fecha == null || fecha.isBlank()) {
            return false;
        }
        try {
            LocalDate.parse(fecha);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String guardarResultados() {
        try {
            escribirResultados();
            return "Se guardaron " + contarPartidos() + " resultados en data/resultados.txt";
        } catch (IOException e) {
            return "No se pudo guardar: " + e.getMessage();
        }
    }

    public String cargarResultados() {
        while (historial.getResultados().getHead() != null) {
            historial.getResultados().eliminar(historial.getResultados().getHead());
        }
        File archivo = new File(ARCHIVO_RESULTADOS);
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(SEPARADOR);
                if (campos.length != 5) {
                    continue;
                }
                Equipo local = equipoService.buscarPorNombre(campos[1]);
                Equipo visitante = equipoService.buscarPorNombre(campos[2]);
                if (local == null || visitante == null) {
                    continue;
                }
                try {
                    insertar(LocalDate.parse(campos[0]), local, visitante,
                            Integer.parseInt(campos[3]), Integer.parseInt(campos[4]));
                } catch (DateTimeParseException | NumberFormatException e) {
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            return "No existe data/resultados.txt; se inicia con el historial vacio";
        } catch (IOException e) {
            return "No se pudo leer: " + e.getMessage();
        }
        return "Se cargaron " + contarPartidos() + " resultados";
    }

    private void escribirResultados() throws IOException {
        File archivo = new File(ARCHIVO_RESULTADOS);
        File carpeta = archivo.getParentFile();
        if (carpeta != null) {
            carpeta.mkdirs();
        }
        StringBuilder texto = new StringBuilder();
        NodoDoble<Partido> nodo = historial.getResultados().getHead();
        while (nodo != null) {
            Partido partido = nodo.getDato();
            texto.append(String.join(SEPARADOR,
                    partido.getFecha().toString(),
                    partido.getEquipoLocal().getNombre(),
                    partido.getEquipoVisitante().getNombre(),
                    Integer.toString(partido.getGolesLocal()),
                    Integer.toString(partido.getGolesVisitante())));
            texto.append(System.lineSeparator());
            nodo = nodo.getSiguiente();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            escritor.write(texto.toString());
        }
    }

    private void insertar(LocalDate fecha, Equipo local, Equipo visitante, int golesLocal, int golesVisitante) {
        String texto = local.getNombre() + " " + golesLocal + "-" + golesVisitante + " " + visitante.getNombre();
        Partido partido = new Partido(fecha, texto, local, visitante);
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);
        historial.getResultados().insertarAlFinal(partido);
    }
}
