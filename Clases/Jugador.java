package grupo2_LigaFutbol.Clases;

public class Jugador {
    String nombre; 
    int dorsal; 
    String posicion; 
    String equipo;
    public Jugador (String nombre, int dorsal, String posicion, String equipo){
      this.nombre = nombre;
      this.dorsal = dorsal;
      this.posicion = posicion;
      this.equipo = equipo;
    };
    public void mostrarInfo(){
        System.out.println("Los datos del jugador son: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dorsal: " + dorsal);
        System.out.println("Posición: " + posicion);
        System.out.println("Equipo: " + equipo);
    };

}
