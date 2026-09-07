package model.domain;

public class Arbitro extends Persona {
    private String categoria;

    public Arbitro(String identificacion, String nombre, String categoria) {
        super(identificacion, nombre);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override 
    public String rolEnPartido (){
        return "Arbitro";
    }
}
