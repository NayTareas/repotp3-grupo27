package ar.edu.unju.escmi.poo.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ejercicio5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<producto> productos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Alta de producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Incrementar precio de productos");
            System.out.println("4 – Ordenar productos");
            System.out.println("5 – Filtrar productos por código");
            System.out.println("6 – Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    System.out.print("Ingrese el código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ingrese la descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();
                    productos.add(new producto(codigo, descripcion, precio));
                    break;

                case 2:
                    productos.stream().forEach(System.out::println);
                    break;

                case 3:
                    productos = productos.stream()
                            .map(p -> {
                                p.setPrecio(p.getPrecio() + 300.00);
                                return p;
                            })
                            .collect(Collectors.toList());
                    System.out.println("Se incrementaron los precios de los productos.");
                    break;

                case 4:
                    productos.stream()
                            .sorted((p1, p2) -> Integer.compare(p1.getCodigo(), p2.getCodigo()))
                            .forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Ingrese el código para filtrar: ");
                    int codigoFiltro = scanner.nextInt();
                    productos.stream()
                            .filter(p -> p.getCodigo() > codigoFiltro)
                            .forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}