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

## Resultado esperado (ejemplo)

```text
Gol agregado.
Gol registrado en la pila.
...
Ultimo gol: minuto 67 | Tipo: normal | Jugador: Juan
Cantidad de goles recientes: 3
1. Minuto 67 | Tipo: normal | Jugador: Juan
2. Minuto 34 | Tipo: penalti | Jugador: Pedro
3. Minuto 12 | Tipo: normal | Jugador: Ana
Cantidad de goles recientes: 3
Gol deshecho: minuto 67 | Tipo: normal | Jugador: Juan
Cantidad de goles recientes: 2
No hay operaciones por deshacer
La pila está vacía
```
