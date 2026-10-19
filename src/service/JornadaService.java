package service;

import java.time.LocalDate;

import model.domain.Equipo;
import model.domain.Jornada;
import model.domain.Partido;
import model.structures.Cola;
import model.structures.ListaSimple;

public class JornadaService {
    private final ListaSimple<Partido> partidos = new ListaSimple<>();
    private final Jornada jornada = new Jornada(1);

    public Partido crearPartido(String resultado) {
        if (resultado == null || resultado.isBlank()) {
            throw new IllegalArgumentException("La descripcion del partido no puede estar vacia");
        }
        Partido partido = new Partido(LocalDate.now(), resultado, new Equipo(), new Equipo());
        partidos.insertarFinal(partido);
        return partido;
    }

    private Partido buscarPartidoOFallar(int indice) {
        if (indice < 0 || indice >= partidos.getTamano()) {
            throw new IllegalArgumentException("El partido con indice " + indice + " no existe");
        }
        return partidos.buscarPorIndice(indice);
    }

    public void programarPartido(String descripcion) {
        Partido partido = crearPartido(descripcion);
        jornada.getFila().enqueue(partido);
    }

    public void programarPartidoPorIndice(int indice) {
        Partido partido = buscarPartidoOFallar(indice);
        jornada.getFila().enqueue(partido);
    }

    public Partido jugarSiguientePartido() {
        return jornada.getFila().dequeue();
    }

    public Partido consultarSiguientePartido() {
        return jornada.getFila().front();
    }

    public boolean sinPartidosEnEspera() {
        return jornada.getFila().isEmpty();
    }

    public int contarEnEspera() {
        return jornada.getFila().size();
    }

    public String listarEnEspera() {
        Cola<Partido> fila = jornada.getFila();
        if (fila.isEmpty()) {
            return "No hay partidos en espera";
        }

        StringBuilder texto = new StringBuilder();
        int total = fila.size();
        for (int i = 1; i <= total; i++) {
            Partido partido = fila.dequeue();
            texto.append(i)
                    .append(". ")
                    .append(partido.getResultado())
                    .append(System.lineSeparator());
            fila.enqueue(partido);
        }
        return texto.toString();
    }
}
