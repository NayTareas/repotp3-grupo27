package ar.edu.unju.escmi.poo.ejercicio3;

import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio3 {

	private static HashSet<Empleado> empleados = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1- Crear empleado");
            System.out.println("2- Aumentar Salario");
            System.out.println("3- Mostrar la suma total de todos los salarios");
            System.out.println("4- Mostrar todos los empleados");
            System.out.println("5- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearEmpleado(scanner);
                    break;
                case 2:
                    aumentarSalario(scanner);
                    break;
                case 3:
                    mostrarSumaTotalSalarios();
                    break;
                case 4:
                    mostrarTodosEmpleados();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void crearEmpleado(Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el legajo del empleado: ");
        int legajo = scanner.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();

        Empleado empleado = new Empleado(nombre, legajo, salario);
        empleados.add(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    private static void aumentarSalario(Scanner scanner) {
        System.out.print("Ingrese el número de legajo del empleado que recibirá el aumento: ");
        int legajo = scanner.nextInt();

        for (Empleado empleado : empleados) {
            if (empleado.getLegajo() == legajo) {
                empleado.aumentarSalario();
                System.out.println("Salario aumentado exitosamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    private static void mostrarSumaTotalSalarios() {
        double sumaTotal = 0;
        for (Empleado empleado : empleados) {
            sumaTotal += empleado.getSalario();
        }
        System.out.println("La suma total de todos los salarios es: $" + sumaTotal);
    }

    private static void mostrarTodosEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrarDatos();
            System.out.println();
        }
    }

}
