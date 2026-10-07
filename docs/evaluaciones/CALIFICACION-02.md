# Retroalimentación — Laboratorio Lista Simple (Momento 2, Parte 2: implementación)

**Grupo:** Grupo2 · **Proyecto:** Liga de Fútbol

Buen trabajo: la lista quedó integrada y el menú funciona.

## Nota

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| Relaciones uno-a-muchos bien identificadas | 20 % | 5.0 |
| `ListaSimple<T>` integrada al `Service` | 30 % | 4.0 |
| Menú en consola funcional | 15 % | 4.5 |
| Reemplazo del arreglo previo, sin código muerto | 20 % | 5.0 |
| Buenas prácticas (commits y nombres) | 15 % | 4.0 |
| **Nota de la implementación** | | **4.48** |

La nota se calcula así: 20% relaciones + 30% integración al Service + 15% menú + 20% reemplazo + 15% buenas prácticas, cada ítem sobre 5.

## 1. Relaciones uno-a-muchos (5.0)
**Lo que hicieron bien:**
- Eligieron `Equipo` con muchos `Jugador` y `Partido` con muchos `Gol`. Ambas son relaciones reales y sensatas para su Liga de Fútbol.

## 2. `ListaSimple<T>` en el Service (4.0)
**Lo que hicieron bien:**
- `Equipo` guarda sus jugadores en `ListaSimple<Jugador>` y `Partido` sus goles en `ListaSimple<Gol>`.
- `EquipoService` y `PartidoService` usan `insertarFinal`, `buscarPorIndice`, `buscarPorValor` y `eliminarPorValor`, y la vista nunca toca la lista directamente.
- Definieron `equals` en `Jugador` y `Gol`, así la búsqueda y la eliminación por valor funcionan.

**Lo que pueden mejorar:**
- No siguieron la estructura de carpetas acordada en clase: `Nodo`, `ListaSimple` y `OperacionesEstructura` están en `src/structures/` y deben estar en `src/model/structures/`.
- Para buscar o eliminar crean un `Jugador` o `Gol` "de mentira" solo para comparar. Funciona, pero conviene documentarlo o buscar de forma más directa.
- `ListaSimple.buscarPorValor` imprime mensajes en pantalla; es mejor que la estructura solo devuelva el resultado y que el `Service` o la vista avisen al usuario.

## 3. Menú en consola (4.5)
**Lo que hicieron bien:**
- `MenuListasView` permite agregar, buscar (por índice y por valor), listar y eliminar en las dos relaciones, siempre a través del `Service`.

**Lo que pueden mejorar:**
- Al buscar por índice se captura una excepción genérica. Sería mejor validar el índice y mostrar un mensaje claro.
- Al agregar un gol se crea un jugador nuevo a mano en vez de usar un jugador del equipo.

## 4. Reemplazo del arreglo previo (5.0)
**Lo que hicieron bien:**
- `Equipo` ya no tiene el `ArrayList`, ni imports, ni métodos viejos (`setJugadores`, `agregarJugador`). No quedó código muerto.

## 5. Buenas prácticas (4.0)
**Lo que hicieron bien:**
- Trabajaron con ramas por integrante y con Pull Requests, y varios autores aportaron al laboratorio.
- Los nombres de clases, métodos y variables siguen las convenciones de Java.

**Lo que pueden mejorar:**
- Hay mensajes poco descriptivos, como "Actualización del proyecto liga de futbol".
- La integración principal quedó en un commit grande hecho el último día; es mejor hacer commits pequeños y frecuentes.

## ¿El programa funciona?
Sí. El proyecto compila sin errores. El menú corre y probamos agregar, listar, buscar y eliminar goles y jugadores sin fallos.

## Para el próximo laboratorio
- Mover la carpeta `structures` a `src/model/structures/`.
- Hacer commits pequeños, con mensajes que digan qué cambió.
- Que la lista no imprima mensajes; que eso lo haga el `Service` o la vista.
- Validar los índices antes de buscar, en lugar de capturar una excepción genérica.
