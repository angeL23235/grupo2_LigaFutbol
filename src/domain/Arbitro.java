package grupo2_LigaFutbol.model.domain;

public class Arbitro {
    private String categoria;

    public Arbitro(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String rolEnPartido (){
        return "";
    }
}
