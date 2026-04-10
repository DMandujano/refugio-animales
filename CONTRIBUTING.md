# Guía de Contribución — Refugio de Animales

## Requisitos previos

- Java 17 o superior
- Git instalado

## Cómo contribuir

1. Haz un fork del repositorio
2. Crea una rama para tu cambio:
   ```
   git checkout -b feature/nombre-de-tu-funcion
   ```
3. Realiza tus cambios y haz commit:
   ```
   git commit -m "feat: descripción breve del cambio"
   ```
4. Sube tu rama y abre un Pull Request hacia `main`

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
