package model.domain;

public abstract class Persona implements RolEnPartido {
   private String identificacion;
   private String nombre;

   public Persona(String identificacion, String nombre) {
      this.identificacion = identificacion;
      this.nombre = nombre;
   }

   public String datosResumen() {
      return "ID: " + this.identificacion + "Nombre: " + this.nombre;
   }

  
   public String getIdentificacion() {
      return identificacion;
   }

   public void setIdentificacion(String identificacion) {
      this.identificacion = identificacion;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String rolEnPartido() {
      return "Medio Campo";
   }
}

