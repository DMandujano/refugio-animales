# Guía de Contribución — Refugio de Animales

## Requisitos previos

- Java 17 o superior
- Git instalado

## Cómo contribuir

1. Haz un fork del repositorio (desmarca que solo clone la rama main)
2. Cambia a la rama `testing`
3. Agrega tus cambios a la estacion de trabajo y haz commit de tus camcios siguiendo la convencion de commits
4. Haz git push hacia tu repositorio 
5. En github crea un Pull Request hacia la rama testing

## Convenciones de código

- Los nombres de métodos y variables deben estar en **camelCase** y en **español** (siguiendo el estilo del proyecto)
- Cada función debe tener una sola responsabilidad
- Agrega comentarios breves solo donde la lógica no sea evidente

## Estructura del proyecto

El proyecto vive en un solo archivo `RefugioAnimales.java`. Las funciones principales son:

| Función | Descripción |
|---|---|
| `registrarAnimales()` | Registra un nuevo animal con nombre y especie |
| `registrarEspecie()` | Agrega una especie al catálogo |
| `mostrarAnimalesDisponibles()` | Lista los animales con estado "Disponible" |

## Opciones del menú pendientes

Las siguientes opciones aún no están implementadas y son candidatas a contribución:

- **Opción 3** — Marcar animal como adoptado
- **Opción 5** — Mostrar animales adoptados
- **Opción 6** — Mostrar reporte general

## Convención de commits

Usa prefijos para indicar el tipo de cambio:

- `feat:` nueva funcionalidad
- `fix:` corrección de un bug
- `refactor:` cambio en la estructura del código sin alterar funcionalidad
- `docs:` cambios en documentación
