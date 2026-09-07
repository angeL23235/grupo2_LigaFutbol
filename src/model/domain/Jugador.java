package model.domain;

public class Jugador extends Persona {
    private int numeroCamiseta;
    private String posicion;
    private int golesTotales;

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
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

    public Jugador(String identificacion, String nombre, int numeroCamiseta, String posicion, int golesTotales) {
        super(identificacion, nombre);
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
        this.golesTotales = golesTotales;
    }

    @Override
    public String rolEnPartido() {
        return "Jugador";
    }

}
