package grupo2_LigaFutbol.src.model.domain;

public class Gol {
 private int minuto;
 private String tipo;
 public Gol(int minuto, String tipo) {
    this.minuto = minuto;
    this.tipo = tipo;
 }
 public int getMinuto() {
    return minuto;
 }
 public void setMinuto(int minuto) {
    this.minuto = minuto;
 }
 public String getTipo() {
    return tipo;
 }
 public void setTipo(String tipo) {
    this.tipo = tipo;
 }   

}
