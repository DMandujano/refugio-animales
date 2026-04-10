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

            switch (opcion) {

                case 1:
                    registrarAnimales(sc, animales,especies ,animalEspecie , estadoAnimal);
                    break;
                case 2:
                    // funcion(variables a utilizar)
                    registrarEspecie(sc, especies);
                    break;
                case 3:
                    //adoptarAniamles();
                    break;
                case 4:
                    //mostrarPorEstado();
                    break;
                case 5:
                    //mostrarPorEstado();
                    break;
                case 6:
                    //reporte();
                    break;
                case 7:
                    System.out.println("saliendo del sistema...");
                    break;

                default:
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
        // nombre
        // especie
        // verficicar si esta o no

        //preguntar al usuario el nombre del animal.
        System.out.println("Ingresa el nombre de tu mascota: ");
        // preguntar al usuario
        String inputNameAnimal = scanner.nextLine().trim(); // eliminar espacios delante y detras del codigo.
        // consultar en la lista de animales si el nombre del animal ya esta.
        if (animales.contains(inputNameAnimal)) {
            System.out.println("El nombre de este animal ya se encuentra registrado, intenta con otro. ");
            return;
        }

        System.out.println("Ingresa el nombre de la especie: ");
        // preguntar al usuario.
        String inputEspecie = scanner.nextLine().trim();

        // validar que la especie exista.
        if (especies.contains(inputEspecie)) {
            System.out.println("La especie ya existe.");
            return;

        }
        // agregar el animal y la especie a la lista.
        animales.add(inputNameAnimal);
        // agregar el animal y la especie a las listas de animalEspecie
        animalEspecie.put(inputNameAnimal, inputEspecie);
        // agregar el animal y como opcion por defecto el disponible al estado en la lista estadoAnimal
        estadoAnimal.put(inputNameAnimal, "Disponible");

        System.out.println("Animal registrado exitosamente.");



    }


}