package comparadores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

//TODO el fichero de los alumnos debe de ser csv y la primera linea era para el nombre de los campos
public class Aula {
	private final static Logger LOGGER = LogManager.getLogger();
	static ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public static void main(String[] args) {
		creacionUsuarios();
		verListaNormal();
		verListaPorDefecto();
		verListaNombre();
		verListaEdad();
		verListaNota();

	}

	/**
	 * Método para crear usuarios a partir de un archivo de texto.
	 *
	 * @return Verdadero si se crearon usuarios, falso en caso contrario.
	 */
	public static boolean creacionUsuarios() {
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
				anyadirALista(estudiante);
			}

		} catch (IOException | DateTimeException e) {
			e.getMessage();
		}
		if (estudiantes.isEmpty()) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

	/**
	 * Método para añadir un estudiante a la lista.
	 *
	 * @param estudiante El estudiante a añadir.
	 * @return Verdadero si el estudiante se añadió correctamente, falso en caso contrario.
	 */
	public static boolean anyadirALista(Estudiante estudiante) {
		if (estudiantes.add(estudiante)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Método para imprimir la lista de estudiantes en su orden actual.
	 */
	public static void verListaNormal() {
		System.out.println("Lista con orden de insercion: \n" +
				estudiantes.toString());

	}

	/**
	 * Método para ordenar e imprimir la lista de estudiantes por el orden por defecto.
	 */
	//TODO la lista ordenada por defecto era por nombre y luego por apellido, has creado dos metodos en vez de uno
	public static void verListaPorDefecto() {
		Collections.sort(estudiantes);
		System.out.println(estudiantes.toString());
	}

	/**
	 * Método para ordenar e imprimir la lista de estudiantes por nombre.
	 */
	public static void verListaNombre() {
		Collections.sort(estudiantes, new ComparadorEstudianteNombre());
		System.out.println(estudiantes.toString());
	}

	/**
	 * Método para ordenar e imprimir la lista de estudiantes por edad.
	 */
	public static void verListaEdad() {
		Collections.sort(estudiantes, new ComparadorEstudianteEdad());
		System.out.println(estudiantes.toString());
	}

	/**
	 * Método para ordenar e imprimir la lista de estudiantes por nota.
	 */
	//TODO mirar el todo pues en la clase del comparator
	public static void verListaNota() {
		Collections.sort(estudiantes, new ComparadorEstudianteNota());
		System.out.println(estudiantes.toString());
	}
}
