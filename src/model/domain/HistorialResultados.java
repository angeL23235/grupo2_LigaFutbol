package model.domain;

import model.structures.ListaDoble;

public class HistorialResultados {
        private String temporada;
    private ListaDoble<Partido> resultados;
 
    public HistorialResultados(String temporada) {
        if (temporada == null || temporada.isBlank()) {
            throw new IllegalArgumentException("La temporada no puede estar vacía");
        }
        this.temporada = temporada;
        this.resultados = new ListaDoble<>();
    }
 
    public String getTemporada() {
        return temporada;
    }
 
    public ListaDoble<Partido> getResultados() {
        return resultados;
    }
}
