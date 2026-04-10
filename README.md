# Refugio de Mascotas - Grupo 2

## Descripción del proyecto
Este proyecto consiste en un programa de consola desarrollado en Java que simula un sistema simple de adopción de animales
El sistema permite ver la lista de animales disponibles, adoptar un animal y también mostrar los animales que ya han sido adoptados.
El usuario interactúa con el sistema a través de un menú en consola, seleccionando las opciones que desea ejecutar

## Estructuras de datos usadas
En el proyecto se utilizaron las siguientes estructuras de datos de Java:

List (ArrayList)
Se utiliza para almacenar los nombres de los animales registrados.
Set (HashSet)
Se usa para almacenar las especies y evitar que se registren especies duplicadas.
Map (HashMap)
Se utilizan dos mapas:
Para relacionar el nombre del animal con su estado (Disponible / Adoptado).
Para relacionar el nombre del animal con su especie.

Estas estructuras permiten organizar la información de manera eficiente dentro del sistema.

## Cómo ejecutar el programa
El proyecto es un solo archivo Java, así que se ejecuta con dos comandos desde la terminal:

Compilar:

-javac RefugioAnimales.java
Ejecutar:

-java RefugioAnimales
Asegúrate de estar en el directorio del proyecto (\workspace generation\refugio-animales) antes de correr los comandos. Puedes verificar tu versión de Java con:


java -version
Necesitas Java 17 o superior según el CONTRIBUTING.md.
## Ejemplo de menú
Al ejecutar el programa, el sistema muestra un menú similar al siguiente:
==================================
========= REFUGIO ANIMAL =========
==================================
1. Registrar un nuevo animal
2. Registrar especie
3. Marcar animal como adoptado
4. Mostrar animales disponibles
5. Mostrar animales adoptados
6. Mostrar reporte general
7. Salir
Selecciona una opción: 

El usuario debe ingresar el número de la opción que desea ejecutar

## Integrantes del equipo
- Dante Escalona
- Bruno Bustos
- Felipe Segovia
- Allan Nuñez
- Dafne Mandujano
- Renato Campos
