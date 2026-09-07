package grupo2_LigaFutbol.src.model.domain;

public class App {
    public static void main(String[] args) throws Exception{
        Jugador jugador1 = new Jugador("kevin", 14, "mediocampista", "real madrid");
        jugador1.mostrarInfo();
        Jugador jugador2 = new Jugador("Andres", 8, "Extremo", "barcelona");
        jugador2.mostrarInfo();
    }
}