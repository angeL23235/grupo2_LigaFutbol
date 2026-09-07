package model.domain;

import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private String resultado;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public Partido(LocalDate fecha, String resultado, Equipo equipoLocal, Equipo equipoVisitante) {
        this.fecha = fecha;
        this.resultado = resultado;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipo1) {
        this.equipoLocal = equipo1;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipo2) {
        this.equipoVisitante = equipo2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}
