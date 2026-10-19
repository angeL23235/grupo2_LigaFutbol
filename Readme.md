# Grupo 2: Liga de Futbol

## Integrantes
1. Kevin Andres Garcia Avendano
2. Miguel Angel Londono Arroyace
3. Sebastian Rios Marin

## Secuencia de verificación (menú de pilas)

1. Registrar tres goles sobre el mismo partido (opción 1).
2. Consultar el último gol (opción 3): debe ser el tercero.
3. Contar (opción 5): debe decir 3.
4. Listar (opción 6): aparecen el tercero, el segundo y el primero; listar otra vez da lo mismo y contar sigue en 3.
5. Deshacer una vez (opción 2): devuelve el tercer gol.
6. Contar: debe decir 2.
7. Deshacer las dos restantes. Preguntar si hay operaciones (opción 4): debe decir que no.
8. Intentar deshacer otra vez: el menú muestra `La pila está vacía` y sigue funcionando.

## Resultado esperado (pilas)

```text
Ultimo gol: minuto 67 | Tipo: normal | Jugador: Juan
Cantidad de goles recientes: 3
1. Minuto 67 | Tipo: normal | Jugador: Juan
2. Minuto 34 | Tipo: penalti | Jugador: Pedro
3. Minuto 12 | Tipo: normal | Jugador: Ana
Gol deshecho: minuto 67 | Tipo: normal | Jugador: Juan
No hay operaciones por deshacer
La pila está vacía
```

## Secuencia de verificación (menú de colas)

1. Programar tres partidos (opción 1).
2. Consultar quién sigue (opción 3): debe ser el primero.
3. Contar (opción 5): debe decir 3. Listar (opción 6): primero, segundo y tercero; listar otra vez da lo mismo.
4. Jugar uno (opción 2): sale el primero. Consultar quién sigue: ahora es el segundo.
5. Contar: debe decir 2.
6. Jugar los dos restantes. Preguntar si hay espera (opción 4): debe decir que no.
7. Intentar jugar otra vez: muestra que no hay partidos en espera y el menú sigue.
8. Programar un partido nuevo: consultar quién sigue debe devolver ese partido.

## Resultado esperado (colas)

```text
Partido programado en la fila exitosamente
Sigue: A vs B
Partidos en espera: 3
1. A vs B
2. C vs D
3. E vs F
Se jugo: A vs B
Sigue: C vs D
Partidos en espera: 2
No hay partidos en espera
Sigue: G vs H
```
