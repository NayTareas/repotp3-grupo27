package ar.edu.unju.escmi.poo.ejercicio1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("Menu de opciones:");
			System.out.println("1 - Crear objeto con Constructor por defecto.");
			System.out.println("2 - Crear objeto con Constructor parametrizado.");
			System.out.println("3 - Crear objeto con Constructor (dni, nombre, fecha de nacimiento.");
			System.out.println("4 - Mostrar personas.");
			System.out.println("5 - Salir.");
			System.out.print("Seleccione una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			
			switch (opcion) {
			case 1:
				Persona persona1 = new Persona();
				System.out.print("Ingrese DNI: ");
				persona1.setDni(scanner.nextLine());
				System.out.print("Ingrese Nombre: ");
				persona1.setNombre(scanner.nextLine());
				System.out.print("Ingrese Fecha de Nacimiento (yyyy-mm-dd): ");
				persona1.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));
				System.out.print("Ingrese Domicilio: ");
				persona1.setDomicilio(scanner.nextLine());
				System.out.print("Ingrese Provincia: ");
				persona1.setProvincia(scanner.nextLine());
				personas.add(persona1);
				break;
				
			case 2:
				System.out.print("Ingrese DNI: ");
					String dni2 = scanner.nextLine();
				System.out.print("Ingrese Nombre: ");
				String nombre2 = scanner.nextLine();
				System.out.print("Ingrese Fecha de Nacimiento (yyyy-mm-dd): ");
				LocalDate fechaNacimiento2 = LocalDate.parse(scanner.nextLine());
				System.out.print("Ingrese Domicilio: ");
				String domicilio2 = scanner.nextLine();
				System.out.print("Ingrese Provincia: ");
				String provincia2 = scanner.nextLine();
				Persona persona2 = new Persona(dni2, nombre2, fechaNacimiento2, domicilio2, provincia2);
				personas.add(persona2);
				break;
				
			case 3:
				System.out.print("Ingrese DNI: ");
				String dni3 = scanner.nextLine();
				System.out.print("Ingrese Nombre: ");
				String nombre3 = scanner.nextLine();
				System.out.print("Ingrese Fecha de Nacimiento (yyyy-mm-dd): ");
				LocalDate fechaNacimiento3 = LocalDate.parse(scanner.nextLine());
				Persona persona3 = new Persona(dni3, nombre3, fechaNacimiento3);
				personas.add(persona3);
				break;
				
			case 4:
				if (personas.isEmpty()) {
					System.out.println("No hay personas registradas.");
				} else {
					for (Persona p : personas) {
						p.mostrarDatos();
						System.out.println("--------------------");
					}
				}
				break;
				
			case 5:
				System.out.println("Saliendo del programa...");
				break;
				
				default:
					System.out.println("Opcion no valida, intente nuevamente.");
			}
			
		} while (opcion != 5);
		
		scanner.close();
	}
							
	}