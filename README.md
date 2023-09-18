# EliminatoriasMundial
Api para simular las eliminatorias al mundial

### Proposito:

Aplicar los conociminetos aprendidos sobre spring y creacion de api

#### Para el siguiente proyecto se uso el motor de base de datos mySql y se planteo una base de datos sencilla respresentada con el siguiente diseño logico

![diseñoFisicoBD-ingles](https://github.com/diego-Ballesteros/EliminatoriasMundial/assets/114629529/c76587a9-2977-4b61-a722-2609a177dc7a)


### Operaciones contruidas 

## Teams:
#### GET / ("http://localhost:8080/api/equipos")
#### GET / get by name RequestParam ("http://localhost:8080/api/equipos/nombre?")
#### POST / RequestBody ("http://localhost:8080/api/equipos")
#### PUT / RequestBody ("http://localhost:8080/api/equipos/{idEquipo}")
#### DELETE / ("http://localhost:8080/api/equipos/{idEquipo}")

## Matches:
#### GET / ("http://localhost:8080/api/partidos")
#### POST / RequestBody ("http://localhost:8080/api/partidos")
#### PATCH / RequestBody ("http://localhost:8080/api/partidos")

## Results:
#### POST / RequestBody ("http://localhost:8080/api/resultados")
#### PATCH / RequestBody ("http://localhost:8080/api/resultados")

