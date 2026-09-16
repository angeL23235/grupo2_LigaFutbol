# Retroalimentación — Laboratorio Evaluativo — Codificación de Diseño OO (Momento 1)

**Grupo:** Grupo2 · **Proyecto:** Liga de Fútbol
**Fecha límite:** 2026-09-08 23:59 -0500 · **Commit evaluado:** `3290a8f` (2026-09-07 03:00:09 -0500)

## Calificación

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| Codificación correcta del UML | 60% | 4.5 |
| Pruebas en el App — creación de objetos | 20% | 5.0 |
| Buenas prácticas de programación | 20% | 5.0 |
| **Nota del laboratorio** | | **4.70** |

```
nota_laboratorio = 0.60 × 4.5 + 0.20 × 5.0 + 0.20 × 5.0 = 2.70 + 1.00 + 1.00 = 4.70
nota_final_curso  = (4.70 / 5) × 5% = 4.70%
```

## Detalle por criterio

### Codificación correcta del UML
**Lo que está bien:**
- Las 7 clases del proyecto (`RolEnPartido`, `Persona`, `Jugador`, `Arbitro`, `Equipo`, `Partido`, `Gol`) están presentes en `src/model/domain/`, con los nombres exactos del diagrama.
- `Persona` es `abstract`, implementa `RolEnPartido`, resuelve `datosResumen()` y deja `rolEnPartido()` pendiente para los subtipos (`src/model/domain/Persona.java`).
- `Jugador` extiende `Persona`, ya **no** es abstracta, conserva `numeroCamiseta`, `posicion`, `golesTotales`, invoca `super(...)`, y **eliminó correctamente** el atributo `equipo:String` suelto, reemplazándolo por la composición real con `Equipo` (`src/model/domain/Jugador.java`, `src/model/domain/Equipo.java`).
- `Arbitro` extiende `Persona`, conserva `categoria` y resuelve `rolEnPartido()` con `@Override` (`src/model/domain/Arbitro.java`).
- `Partido` implementa correctamente los dos campos separados `equipoLocal` y `equipoVisitante` en vez de una relación genérica (`src/model/domain/Partido.java:5-6`).
- Todos los atributos son `private`, con getters/setters consistentes.

**Por mejorar:**
- El constructor de `Persona` **no valida** que `identificacion` sea no nula/no vacía, como exige explícitamente la rúbrica para este proyecto (`src/model/domain/Persona.java:6-9`); tampoco hay validaciones en los setters (`setIdentificacion`, `setNombre`, etc.). Es la única falla real frente al diagrama, y es aislada.
- Hay un archivo `App.java` suelto en `src/` (fuera de `model/domain`), sin relación con el diagrama — no afecta la convención de paquetes pero es código residual que conviene limpiar.

### Pruebas en el App — creación de objetos
**Lo que está bien:** `PruebaCreacionObjetos.java` (fuera de `model/domain`, junto a `App.java`) crea un `Jugador` y un `Arbitro`, agrega el `Jugador` a un `Equipo` (composición), y recorre ambos como referencias `Persona` en una `List<Persona>`, invocando `rolEnPartido()` polimórficamente **sin `instanceof`**, imprimiendo el resultado de cada uno por consola. Compila y ejecuta sin errores (ver sección de compilación).

**Por mejorar:** ninguna observación relevante; cumple todo lo pedido.

### Buenas prácticas de programación
**Lo que está bien:** historial con commits frecuentes y descriptivos de tres autores distintos (`Kevin`, `Sebas`/`Sala L 401`, `Angel Londoño`), trabajo en ramas propias (`sebas`, `Angel`, `Kevin`) integradas por `merge`/pull requests, y convenciones Java respetadas (`PascalCase` en clases, `camelCase` en métodos/atributos).

**Por mejorar:** sin observaciones relevantes.

## Compilación y ejecución

Compiló sin errores:
```
javac -d out $(find src -name "*.java")   # exit 0
```

Ejecución de `PruebaCreacionObjetos` (stdin vacío):
```
El jugador se ha añadido
Nombre: SebasKA Rol: Jugador
Nombre: KevinSA Rol: Arbitro
```
Confirma instanciación de los dos subtipos, composición con `Equipo`, y comportamiento polimórfico distinto entre `Jugador` y `Arbitro`.

## Recomendaciones para el siguiente corte
- Agregar las validaciones de constructor/setters que pide el diagrama (por ejemplo, `identificacion` no nula/vacía en `Persona`), incluso cuando el compilador no las exige — la rúbrica las evalúa explícitamente.
- Retirar del repositorio archivos sueltos sin propósito (`App.java`) para mantener la estructura limpia.
- Buen trabajo manteniendo la convención de paquetes `model.domain` y el flujo de ramas por integrante; sigan así.
