package model.domain;

import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private String resultado;
    private Equipo equipo1;
    private Equipo equipo2;

    public Partido(LocalDate fecha, String resultado) {
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
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
