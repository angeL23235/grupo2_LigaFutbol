package service;

import java.time.LocalDate;

import model.domain.Equipo;
import model.domain.HistorialResultados;
import model.domain.Partido;

public class HistorialResultadosService {
    private final HistorialResultados historial;
 
    public HistorialResultadosService(String temporada) {
        this.historial = new HistorialResultados(temporada);
    }
 
    // insertarAlFinal
    public void registrarPartido(String resultado) {
        if (resultado == null || resultado.isBlank()) {
            throw new IllegalArgumentException("El resultado del partido no puede estar vacío");
        }
        Partido partido = new Partido(LocalDate.now(), resultado, new Equipo(), new Equipo());
        historial.getResultados().insertarAlFinal(partido);
    }
 
    // recorrerAdelante
    public String listarPartidosEnOrden() {
        ListaDoble<Partido> lista = historial.getResultados();
        if (lista.estaVacia()) {
            return "No hay partidos en el historial";
        }
 
        StringBuilder texto = new StringBuilder();
        int numero = 1;
        for (NodoDoble<Partido> nodo = lista.getPrimero(); nodo != null; nodo = nodo.getSiguiente()) {
            texto.append(numero)
                    .append(". ")
                    .append(nodo.getDato().getResultado())
                    .append(System.lineSeparator());
            numero++;
        }
        return texto.toString();
    }
 
    // recorrerAtras
    public String listarPartidosEnOrdenInverso() {
        ListaDoble<Partido> lista = historial.getResultados();
        if (lista.estaVacia()) {
            return "No hay partidos en el historial";
        }
 
        StringBuilder texto = new StringBuilder();
        int numero = lista.getTamano();
        for (NodoDoble<Partido> nodo = lista.getUltimo(); nodo != null; nodo = nodo.getAnterior()) {
            texto.append(numero)
                    .append(". ")
                    .append(nodo.getDato().getResultado())
                    .append(System.lineSeparator());
            numero--;
        }
        return texto.toString();
    }
 
    // anterior
    public Partido verPartidoAnterior() {
        return historial.getResultados().anterior();
    }
 
    // siguiente
    public Partido verPartidoSiguiente() {
        return historial.getResultados().siguiente();
    }
 
    // retirarActual
    public Partido retirarPartido() {
        return historial.getResultados().retirarActual();
    }
 
    // Consultas para que la vista pregunte antes de actuar (sin try/catch)
    public boolean sinPartidos() {
        return historial.getResultados().estaVacia();
    }
 
    public boolean hayPartidoAnterior() {
        return historial.getResultados().hayAnterior();
    }
 
    public boolean hayPartidoSiguiente() {
        return historial.getResultados().haySiguiente();
    }
 
    public Partido verPartidoActual() {
        return historial.getResultados().getActual();
    }

}
