package model.domain;

public class Jugador extends Persona {
    private int muneroCamiseta;
    private String posicion;
    private int golesTotales;

    public int getMuneroCamiseta() {
        return muneroCamiseta;
    }

    public void setMuneroCamiseta(int muneroCamiseta) {
        this.muneroCamiseta = muneroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGolesTotales() {
        return golesTotales;
    }

    public void setGolesTotales(int golesTotales) {
        this.golesTotales = golesTotales;
    }

    public Jugador(String identificacion, String nombre, int muneroCamiseta, String posicion, int golesTotales) {
        super(identificacion, nombre);
        this.muneroCamiseta = muneroCamiseta;
        this.posicion = posicion;
        this.golesTotales = golesTotales;
    }

    public String rolEnPartido() {
        return "";
    }

}
