# Retroalimentación — Laboratorio 1: Codificación del diseño OO

**Grupo:** Grupo2 · **Proyecto:** Liga de Fútbol
**Fecha límite:** 2026-09-08 23:59 · **Versión revisada:** commit `3290a8f`

Muy buen trabajo. El diseño está casi completo y el programa funciona sin problemas.

## Nota

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| El código sigue el diagrama UML | 60% | 4.5 |
| Pruebas: creación de objetos en el programa | 20% | 5.0 |
| Buenas prácticas de programación | 20% | 5.0 |
| **Nota del laboratorio** | | **4.70** |

La nota se calcula así: 60% diseño UML + 20% pruebas + 20% buenas prácticas.

## 1. El código sigue el diagrama UML (4.5)
**Lo que hicieron bien:**
- Están las 7 clases del diagrama (`RolEnPartido`, `Persona`, `Jugador`, `Arbitro`, `Equipo`, `Partido`, `Gol`), con los nombres exactos y dentro de `model/domain`.
- `Persona` es abstracta, implementa `RolEnPartido`, resuelve `datosResumen()` y deja `rolEnPartido()` para que lo resuelva cada hija.
- `Jugador` hereda de `Persona` y llama a `super(...)`. Además quitaron el atributo `equipo` de tipo texto y en su lugar el `Equipo` guarda a sus jugadores, como pide el diagrama.
- `Arbitro` hereda de `Persona` y responde `rolEnPartido()` a su manera.
- `Partido` tiene por separado un `equipoLocal` y un `equipoVisitante`. Muy bien.
- Todos los atributos son privados y tienen sus getters y setters.

**Lo que pueden mejorar:**
- El constructor de `Persona` no revisa que la `identificacion` venga llena (que no sea nula ni vacía). El diagrama lo pide. Es el único detalle que falta.

## 2. Pruebas: creación de objetos (5.0)
**Lo que hicieron bien:**
- `PruebaCreacionObjetos` crea un `Jugador` y un `Arbitro`, agrega el jugador a un `Equipo` y luego recorre ambos como `Persona`, llamando `rolEnPartido()` sin usar `instanceof`. Así se ve que cada uno responde distinto. Cumple todo lo pedido.

## 3. Buenas prácticas (5.0)
**Lo que hicieron bien:**
- Los tres integrantes hicieron commits seguido y con mensajes claros.
- Cada uno trabajó en su propia rama y luego unieron los cambios.
- Respetan las reglas de nombres de Java: clases con mayúscula inicial, métodos y atributos con minúscula inicial.

## ¿El programa funciona?
Sí. El código compila sin errores. Al ejecutar `PruebaCreacionObjetos` se agrega el jugador al equipo y se muestra el rol de cada persona ("Jugador" y "Arbitro").

## Para el próximo laboratorio
- Agreguen en el constructor de `Persona` la revisión de que `identificacion` no sea nula ni vacía.
- En general, incluyan todas las validaciones que pide el diagrama, aunque el programa compile sin ellas.
- Sigan organizando el código en `model.domain` y trabajando con una rama por integrante.
