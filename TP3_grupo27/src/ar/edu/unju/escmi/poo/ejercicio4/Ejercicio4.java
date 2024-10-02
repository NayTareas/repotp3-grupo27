package ar.edu.unju.escmi.poo.ejercicio4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Crear el HashMap con clave String y valor Cliente
        HashMap<String, Cliente> clientesMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        // Menú de opciones
        while (opcion != 4) {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Alta cliente");
            System.out.println("2 - Mostrar todos los clientes");
            System.out.println("3 - Ingrese clave para eliminar cliente");
            System.out.println("4 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Opción Alta cliente
                    String dni = "";
                    while (true) {
                        System.out.print("Ingrese DNI (solo números): ");
                        dni = scanner.nextLine();
                        // Verificar que el DNI solo contenga números
                        if (dni.matches("\\d+")) {
                            break; // Salir del bucle si la entrada es válida
                        } else {
                            System.out.println("DNI inválido. Ingrese solo números.");
                        }
                    }

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    char categoria = ' ';
                    while (true) {
                        System.out.print("Ingrese categoría (A, B, C): ");
                        String inputCategoria = scanner.nextLine().toUpperCase();
                        // Verificar que la categoría sea 'A', 'B' o 'C'
                        if (inputCategoria.length() == 1 && (inputCategoria.charAt(0) == 'A' || inputCategoria.charAt(0) == 'B' || inputCategoria.charAt(0) == 'C')) {
                            categoria = inputCategoria.charAt(0);
                            break; // Salir del bucle si la entrada es válida
                        } else {
                            System.out.println("Categoría inválida. Ingrese solo A, B o C.");
                        }
                    }

                    // Crear un nuevo objeto Cliente
                    Cliente cliente = new Cliente(dni, nombre, categoria);

                    // Crear la clave para el HashMap
                    String clave = dni + categoria;

                    // Agregar el cliente al HashMap
                    clientesMap.put(clave, cliente);
                    System.out.println("Cliente agregado correctamente.\n");
                    break;

                case 2:
                    // Opción Mostrar todos los clientes
                    if (clientesMap.isEmpty()) {
                        System.out.println("No hay clientes en el sistema.\n");
                    } else {
                        // Usar un Iterator para recorrer el HashMap
                        Iterator<Map.Entry<String, Cliente>> iterator = clientesMap.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<String, Cliente> entry = iterator.next();
                            System.out.println("Clave: " + entry.getKey() + " - Cliente: " + entry.getValue());
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    // Opción Eliminar cliente por clave
                    System.out.print("Ingrese la clave del cliente a eliminar: ");
                    String claveEliminar = scanner.nextLine();
                    if (clientesMap.containsKey(claveEliminar)) {
                        clientesMap.remove(claveEliminar);
                        System.out.println("Cliente eliminado correctamente.\n");
                    } else {
                        System.out.println("No se encontró ningún cliente con esa clave.\n");
                    }
                    break;

                case 4:
                    // Opción Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, intente nuevamente.\n");
                    break;
            }
        }
        scanner.close();
    }
}
