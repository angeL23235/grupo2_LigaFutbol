package model.domain;

public class Gol {
   private int minuto;
   private String tipo;
   private Jugador jugador;

   public Gol(int minuto, String tipo, Jugador jugador) {
      this.minuto = minuto;
      this.tipo = tipo;
      this.jugador = jugador;
   }

   public int getMinuto() {
      return minuto;
   }

   public void setMinuto(int minuto) {
      this.minuto = minuto;
   }

   public Jugador getJugador() {
      return jugador;
   }

   public void setJugador(Jugador jugador) {
      this.jugador = jugador;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      Gol otro = (Gol) obj;
      if (this.minuto != otro.minuto) {
         return false;
      }
      if (this.jugador == null || otro.jugador == null) {
         return false;
      }
      return this.jugador.equals(otro.jugador);
   }

}
