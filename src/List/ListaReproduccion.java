package List;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ListaReproduccion {
	static LinkedHashSet<String> cola = new LinkedHashSet<>();

	public static void main(String[] args) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);

		try {
			do {
				System.out.println("1. Añadir canciones\n" +
						"2. Eliminar canciones\n" +
						"3. Mostrar lista de reproducicon");
				opcion = sc.nextInt();

				switch (opcion) {
					case 1:
						anyadirCanciones(sc);
						break;
					case 2:
						eliminarCanciones(sc);
						break;
					case 3:
						System.out.println(cola);
						break;
					default:
						System.out.println("Valor introducido no valido");
				}

			} while (opcion <= 3 && opcion >= 1);
		} catch (RuntimeException e) {
			System.out.println("Error");
		}
	}

	public static void anyadirCanciones(Scanner sc) {
		boolean finalizado = Boolean.FALSE;

		System.out.println("Inserte la cancion que desee\n" +
				"escriba 'salir' para salir");
		do {
			String cancion = sc.nextLine();
			if (!cancion.equalsIgnoreCase("salir")) {
				cola.add(cancion);
			} else {
				finalizado = Boolean.TRUE;
			}
		} while (!finalizado);


	}

	public static void eliminarCanciones(Scanner sc) {
		boolean finalizado = Boolean.FALSE;
		sc.nextLine();
		System.out.println("Introduce nombre de la cancion que desea eliminar");
		do {
			String cancion = sc.nextLine();
			if (cancion.equalsIgnoreCase("salir")) {
				finalizado = Boolean.TRUE;
			}
			if (cola.contains(cancion)) {
				System.out.println("Eliminando cancion");
				cola.remove(cancion);
			} else {
				System.out.println("Cancion no encontrada");
			}
		} while (!finalizado);
	}
}
