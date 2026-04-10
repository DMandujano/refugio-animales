import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;

public class RefugioAnimales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> animales = new ArrayList<>(); 
        Map<String, String> estadoAnimal = new HashMap<>(); 
        Set<String> especies = new HashSet<>(); 
        Map<String, String> animalEspecie = new HashMap<>();

        int opcion;

        // ================================
        //      MENU DE OPCIONES
        // ================================

        do {
            System.out.println("================================");
            System.out.println("========= REFUGIO ANIMAL =========");
            System.out.println("================================");
            System.out.println("1. Registrar un nuevo animal");
            System.out.println("2. Registrar especie");
            System.out.println("3. Marcar animal como adoptado");
            System.out.println("4. Mostrar animales disponibles");
            System.out.println("5. Mostrar animales adoptados");
            System.out.println("6. Mostrar reporte general");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpia buffer

            switch (opcion) {

                case 1 -> { // DANTE
                    registrarAnimales(sc, animales, especies, animalEspecie, estadoAnimal);
                }

                case 2 -> { // BRUNO
                    registrarEspecie(sc, especies);
                }

                case 3 -> { // FELIPE
                    // aquí irá la función para adoptar animales
                }

                case 4 -> { // ALLAN
                    mostrarAnimalesDisponibles(estadoAnimal);

                }

                case 5 -> { // DAFNE
                    // aquí irá la función para mostrar animales adoptados
                }

                case 6 -> { // RENATO
                    mostrarReporteGeneral(animales, especies, animalEspecie, estadoAnimal);
                }

                case 7 -> {
                    System.out.println("Saliendo del sistema...");
                }

                default -> {
                    System.out.println("Opción inválida");
                }
            }

        } while (opcion != 7);

        sc.close();
    }

    // ================================
    // FUNCIONES
    // ================================

    // OPCION 2
    public static void registrarEspecie(Scanner scanner, Set<String> especies) {

        System.out.println("Ingrese la especie: ");
        String nombreEspecie = scanner.nextLine().trim().toLowerCase();

        // verificamos si la especie ya existe
        if (especies.contains(nombreEspecie)) {
            System.out.println("La especie ya fue registrada, intenta con otra");
        } else {

            // si no existe se agrega al set
            especies.add(nombreEspecie);
            System.out.println("La especie " + nombreEspecie + " fue agregada con éxito");
        }
    }

    // OPCION 1
    public static void registrarAnimales(Scanner scanner,
                                        List<String> animales,
                                        Set<String> especies,
                                        Map<String, String> animalEspecie,
                                        Map<String, String> estadoAnimal) {

        System.out.println("\n--- Registro de Nuevo Animal ---");
        System.out.print("Ingresa el nombre del animal: ");
        String inputNameAnimal = scanner.nextLine().trim();

        // validar si el animal ya existe
        if (animales.stream().anyMatch(a -> a.equalsIgnoreCase(inputNameAnimal))) {
            System.out.println("Error: El nombre '" + inputNameAnimal + "' ya está registrado.");
            return;
        }

        System.out.print("Ingresa el nombre de la especie: ");
        String inputEspecie = scanner.nextLine().trim().toLowerCase();

        // validar que la especie exista
        if (!especies.contains(inputEspecie)) {
            System.out.println("Error: La especie '" + inputEspecie + "' no existe en el catálogo. Regístrela primero en la opción 2.");
            return;
        }

        // guardar datos
        animales.add(inputNameAnimal);
        animalEspecie.put(inputNameAnimal, inputEspecie);
        estadoAnimal.put(inputNameAnimal, "Disponible");

        System.out.println("Animal registrado exitosamente.");
    }

    // OPCION 4
    public static void mostrarAnimalesDisponibles(Map<String, String> estadoAnimal) {
        System.out.println("\n--- Lista de Animales Disponibles ---");
        if (estadoAnimal.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }

        // Se cambió el recorrido forEach por un ciclo for para poder usar la variable
        // hayDisponibles y así verificar si existe al menos un animal disponible
        // Esto permite mostrar un mensaje si no se encuentra ninguno
        boolean hayDisponibles = false;

        // recorremos el mapa
        for (Map.Entry<String, String> entry : estadoAnimal.entrySet()) {

            if (entry.getValue().equalsIgnoreCase("Disponible")) {
                System.out.println(" - " + entry.getKey());
                hayDisponibles = true;
            }
        }

        // si no se encontró ninguno disponible
        if (!hayDisponibles) {
            System.out.println("No hay animales disponibles para adopción en este momento.");
        }
    }

    public static void mostrarReporteGeneral(List<String> animales, Set<String> especies, Map<String, String> animalEspecie, Map<String, String> estadoAnimal) {

    if (animales.isEmpty()) {   // Si no hay animales registrados, mostramos un mensaje y salimos
        System.out.println("No hay animales registrados.");
        return;
    }
    // Contamos cuántos animales están disponibles y cuántos adoptados
    long disponibles = estadoAnimal.values().stream().filter(e -> e.equalsIgnoreCase("Disponible")).count();
    long adoptados = estadoAnimal.values().stream().filter(e -> e.equalsIgnoreCase("Adoptado")).count();
    // Imprimimos el reporte general
    System.out.println("\n========== REPORTE GENERAL ==========");
    System.out.println("Total animales registrados : " + animales.size());
    System.out.println("  - Disponibles            : " + disponibles);
    System.out.println("  - Adoptados              : " + adoptados);
    System.out.println("Total especies registradas : " + especies.size());
    System.out.println("-------------------------------------");
    System.out.println("Detalle:");
    for (String animal : animales) {    // Recorremos la lista de animales para mostrar su detalle
        String especie = animalEspecie.get(animal);
        String estado = estadoAnimal.get(animal);
        System.out.println("  - " + animal + " | " + especie + " | " + estado);
    }
    System.out.println("=====================================");
}

}