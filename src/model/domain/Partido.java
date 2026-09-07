package grupo2_LigaFutbol.src.model.domain;
import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private String resultado;
    public Partido(LocalDate fecha, String resultado) {
        this.fecha = fecha;
        this.resultado = resultado;
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
