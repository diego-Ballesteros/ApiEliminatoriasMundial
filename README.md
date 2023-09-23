# EliminatoriasMundial
Api para simular las eliminatorias al mundial

### Proposito:

Aplicar los conociminetos aprendidos sobre spring y creacion de api

#### Para el siguiente proyecto se uso el motor de base de datos mySql y se planteo una base de datos sencilla respresentada con el siguiente diseño logico

![diseñoFisicoBD-ingles](https://github.com/diego-Ballesteros/EliminatoriasMundial/assets/114629529/c76587a9-2977-4b61-a722-2609a177dc7a)


### Operaciones construidas 

## Teams:
#### GET / ("http://localhost:8080/api/equipos")
#### GET / get by name RequestParam ("http://localhost:8080/api/equipos/nombre?name=nombreEquipo")
#### POST / RequestBody ("http://localhost:8080/api/equipos")
#### PUT / RequestBody ("http://localhost:8080/api/equipos/{idEquipo}")
#### DELETE / ("http://localhost:8080/api/equipos/{idEquipo}")
#### GET (veces que jugo de local)/ RequestParam(http://localhost:8080/api/equipos/contarlocal?name=nombreEquipo)

## Matches:
#### GET / ("http://localhost:8080/api/partidos")
#### GET / get by date RequestParam ("http://localhost:8080/api/partidos/fecha?")
#### POST / RequestBody ("http://localhost:8080/api/partidos")
#### PATCH / RequestBody ("http://localhost:8080/api/partidos")

## Results:
#### POST / RequestBody ("http://localhost:8080/api/resultados")
#### PATCH / RequestBody ("http://localhost:8080/api/resultados")

## Adicionales:
- Se creo DTO para cada entidad de tal forma que el cliente solo puede ver los datos que se permite en el DTO
- Se creo un GlobalExceptionHandler para el manejo de excepciones de manera global
- Se realizaron validaciones tanto a nivel entidad como a nivel Dto, tambien a cada parametro en las funciones del controller donde fue considerado util



