package List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AulaSet {
	private final static Logger LOGGER = LogManager.getLogger();

	static Set<Estudiante> estudiantesLinkedHashSet = new LinkedHashSet<>();
	static Set<Estudiante> estudiantesHashSet = new HashSet<>();
	static TreeSet<Estudiante> estudiantesTreeSet = new TreeSet<>();

	public static void main(String[] args) {
		creacionUsuarios();
		mostrarEstudiantesLinkedHashSet();
		mostrarEstudiantesHashSet();
		mostrarEstudiantesTreeSet(estudiantesTreeSet);
//		System.out.println(estudiantesTreeSet.isEmpty());
//		System.out.println(estudiantesTreeSet.size());
//
//		System.out.println(estudiantesTreeSet.pollFirst());
//
//		mostrarEstudiantesTreeSet(estudiantesTreeSet);



	}

	/**
	 * Método para crear usuarios a partir de un archivo de texto.
	 */
	public static void creacionUsuarios() {
		String linea;
		String[] lineaCompleta;
		int contador = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try (BufferedReader br = new BufferedReader(new FileReader("src\\comparadores\\ListaAlumnos.csv"))) {
			while ((linea = br.readLine()) != null) {
				contador++;
				if (contador == 1)
					continue;
				lineaCompleta = linea.split(";");
				Estudiante estudiante = new Estudiante(lineaCompleta[0], lineaCompleta[1], LocalDate.parse(lineaCompleta[2], dtf), Double.parseDouble(lineaCompleta[3]));
				estudiantesLinkedHashSet.add(estudiante);
				estudiantesHashSet.add(estudiante);
				estudiantesTreeSet.add(estudiante);

			}

		} catch (IOException | DateTimeException e) {
			LOGGER.error("Error");
		}

	}


	public static void mostrarEstudiantesLinkedHashSet() {
		Iterator<Estudiante> iterator = estudiantesLinkedHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("---------------------------------------------");

	}

	public static void mostrarEstudiantesHashSet() {
		Iterator<Estudiante> iterator = estudiantesHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("---------------------------------------------");

	}

	public static void mostrarEstudiantesTreeSet(TreeSet<Estudiante> estudiantes) {
		Iterator<Estudiante> iterator = estudiantes.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("---------------------------------------------");

	}

}
