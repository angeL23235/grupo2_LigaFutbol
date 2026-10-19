# Retroalimentación — Laboratorio Pilas y Colas en el proyecto de aula

**Grupo:** Grupo2 · **Proyecto:** Liga de Fútbol

Muy buen trabajo: las dos estructuras funcionan y están bien integradas.

## Nota

| Criterio | Puntos | Obtenido |
|---|---|---|
| **Pilas** | | |
| `Pila<T>` correcta | 30 | 30 |
| Casos límite | 10 | 10 |
| Integración en entidad y `Service` | 30 | 28 |
| Menú en `view/` | 15 | 8 |
| Buenas prácticas | 15 | 8 |
| **Total Pilas** | 100 | **84** |
| **Colas** | | |
| `Cola<T>` correcta | 30 | 30 |
| Casos límite | 10 | 10 |
| UML y entidad dueña (`Jornada`) | 15 | 15 |
| Integración en el `Service` | 25 | 23 |
| Menú en `view/` | 10 | 10 |
| Buenas prácticas | 10 | 5 |
| **Total Colas** | 100 | **93** |
| **Nota del laboratorio** | | **4.43** |

La nota es el promedio de los totales de Pilas y Colas, dividido entre 20: (84 + 93) / 2 / 20.

## 1. Pilas: `Pila<T>` y casos límite (40/40)
**Lo que hicieron bien:**
- `push`, `pop`, `peek`, `isEmpty` y `size` funcionan bien, sin ciclos y sin usar `java.util`.
- `pop` y `peek` con la pila vacía lanzan el error con mensaje, y `push(null)` deja la pila intacta.

## 2. Pilas: entidad y `Service` (28/30)
**Lo que hicieron bien:**
- `Partido` guarda la pila de goles como atributo privado y la crea en el constructor.
- Deshacer quita el gol de la pila y también de la lista de goles, sin volver a apilarlo.
- Listar usa la pila auxiliar y deja todo como estaba (probamos listar dos veces y quedaron 3 goles).

**Lo que pueden mejorar:**
- El `Service` imprime mensajes con `System.out`; eso es trabajo de la vista.

## 3. Pilas: menú (8/15)
**Lo que hicieron bien:** el menú tiene las seis opciones, lee con `ConsoleUtils` y no conoce la pila.

**Lo que pueden mejorar:**
- El menú usa `try` / `catch`, y la guía pedía no usarlo en la vista.
- Al deshacer o consultar no preguntan primero si hay goles (`sinGolesPorDeshacer`); dependen del error atrapado.

## 4. Colas: `Cola<T>`, casos límite y entidad (55/55)
**Lo que hicieron bien:**
- `Cola<T>` maneja bien `frente` y `fin`; al vaciarla y encolar otro elemento, `front()` devuelve el nuevo.
- `Jornada` coincide con el diagrama: cola privada creada en el constructor, sin `setFila` y sin lógica de filas.

## 5. Colas: `Service` y menú (33/35)
**Lo que hicieron bien:**
- `JornadaService` tiene los cinco métodos y `listarEnEspera`, que rota la fila sin alterarla.
- Jugar un partido lo saca de la fila pero no de la lista de partidos.
- El menú consulta si hay partidos antes de atender o consultar, y la fila vacía no cierra el programa.

**Lo que pueden mejorar:**
- Los partidos se crean con equipos vacíos; sería mejor programar partidos reales ya existentes.

## 6. Buenas prácticas (Pilas 8/15, Colas 5/10)
**Lo que hicieron bien:** mensajes de commit claros, nombres según las convenciones de Java y cambios fusionados a `main`.

**Lo que pueden mejorar:**
- No usaron las ramas `feature/pila-en-el-proyecto` ni `feature/cola-en-el-proyecto`; trabajaron en la rama `Angel`.
- Los commits de la cola se hicieron casi todos en el mismo minuto, la noche anterior a la entrega. Hagan un commit al terminar cada parte.
