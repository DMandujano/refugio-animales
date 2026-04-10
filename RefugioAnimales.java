import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;

public class RefugioAnimales {

    public static void main(String[] args) {
        // llamar al scanner
        Scanner sc = new Scanner(System.in);

        List<String> animales = new ArrayList<>(); // lista de animales donde guardara datos
        Map<String, String> estadoAnimal = new HashMap<>(); // lista que permite 2 valores (clave, valor) (nombre, estado)
        Set<String> especies = new HashSet<>(); // lista que no permite datos duplicados
        Map<String, String> animalEspecie = new HashMap<>(); // lista que permite 2 valores (clave, valor) (nombre, especie)

        int opcion; // una variable con tipo de valor entero

        // ================================
        //      MENU DE OPCIONES
        // ================================
        do {
            System.out.println("================================");
            System.out.println("========= Refugio animal =========");
            System.out.println("================================");
            System.out.println("1. Registrar un nuevo animal");
            System.out.println("2. Registrar especie");
            System.out.println("3. Marcar animal como adoptado");
            System.out.println("4. Mostrar animales disponibles");
            System.out.println("5. mostrar animales adoptados");
            System.out.println("6. mostrar reporte general");//Aqui arregle por el estaba muy pegado
            System.out.println("7. Salir");
            System.out.print("Select an option: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer

//Switch moderno

            switch (opcion) {
                case 1 ->
                    //Se llama a la funcion creada mas abajo
                    registrarAnimales(sc, animales, especies, animalEspecie, estadoAnimal);
                case 2 -> {}
                    // funcion(variables a utilizar)
                case 3 -> {}

                //adoptarAniamles();
                case 4 -> { // Allan
                    System.out.println("\n--- Lista de Animales Disponibles ---");

                    // Llamamos a la función
                    mostrarAnimalesDisponibles(estadoAnimal);
                    }
                case 5-> {}
                    //mostrarPorEstado();
                case 6-> {}
                    //reporte();
                case 7->
                    System.out.println("saliendo del sistema...");

                default->
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 7);

        sc.close();
    }


    // FUNCIONES

    public static void registrarEspecie(Scanner scanner, Set<String> especies) {
        // Que necesitamos?
        // registrar una especie
        // llamar al scanner
        // llamar a la lista de especies

        System.out.println("Ingrese la especie: ");
        String nombreEspecie = scanner.nextLine().trim(); // trim quita espacios adelante y detras del codigo
        // ingresar una especie dependiendo del dato del usuario.
        // "SI" especie(lo que manda el usuario) se encuentra dentro de la lista especies
        if (especies.contains(nombreEspecie)) {
            System.out.println("La especie ya fue registrada, intenta con otra");

            // "SI NO" esta especie(lo que manda el usuario) entonces tienes que agregar a la lista especies.
        } else {
            // agrega a la lista de especies
            especies.add(nombreEspecie);
            // la especie / lo que escribe el usuario / fue agregada
            System.out.println("La especie " + nombreEspecie + " fue agregada con exito");
        }

    }

    public static void registrarAnimales(Scanner scanner,
                                         List<String> animales,
                                         Set<String> especies,
                                         Map<String, String> animalEspecie,
                                         Map<String, String> estadoAnimal) {

        System.out.println("\n--- Registro de Nuevo Animal ---");
        System.out.print("Ingresa el nombre de tu mascota: ");
        String inputNameAnimal = scanner.nextLine().trim();

        // 1. Validar si el animal ya existe (ignorando mayúsculas)
        if (animales.stream().anyMatch(a -> a.equalsIgnoreCase(inputNameAnimal))) {
            System.out.println("Error: El nombre '" + inputNameAnimal + "' ya está registrado.");
            return;
        }

        System.out.print("Ingresa el nombre de la especie: ");
        String inputEspecie = scanner.nextLine().trim();

        // 2. CORRECCIÓN: Validar que la especie EXISTA en el catálogo
        if (!especies.contains(inputEspecie)) {
            System.out.println("Error: La especie '" + inputEspecie + "' no existe en el catálogo. Regístrela primero en la opción 2.");
            return;
        }

        // 3. Guardar datos si esta bien
        animales.add(inputNameAnimal);
        animalEspecie.put(inputNameAnimal, inputEspecie);
        estadoAnimal.put(inputNameAnimal, "Disponible");

        System.out.println("¡" + inputNameAnimal + " ha sido registrado exitosamente como " + inputEspecie + "!");
    }
    public static void mostrarAnimalesDisponibles(Map<String, String> estadoAnimal) {

        // Verificamos si el mapa tiene datos
        if (estadoAnimal.isEmpty()) {
            System.out.println("No hay animales registrados en el refugio.");
        } else {
            boolean hayDisponibles = false;

            // Recorremos el mapa usando un for-each o lambda
            for (Map.Entry<String, String> entry : estadoAnimal.entrySet()) {
                String nombre = entry.getKey();
                String estado = entry.getValue();

                // Filtramos solo los que están disponibles
                if (estado.equalsIgnoreCase("Disponible")) {
                    System.out.println(" - " + nombre);
                    hayDisponibles = true;
                }
            }

            if (!hayDisponibles) {
                System.out.println("No hay animales disponibles para adopción en este momento.");
            }
        }
    }

}