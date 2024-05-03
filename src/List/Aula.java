package List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

//TODO el fichero de los alumnos debe de ser csv y la primera linea era para el nombre de los campos
public class Aula {
	private final static Logger LOGGER = LogManager.getLogger();
	static LinkedList<Estudiante> estudiantes = new LinkedList<>();

	public static void main(String[] args) {
		creacionUsuarios();
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
				anyadirLista(estudiante
				);


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
	public static void anyadirLista(Estudiante estudiante){
		System.out.println("Añade un estudiante a la lista");
		estudiantes.add(estudiante);

		System.out.println("Añade un estudiante el primero de la lista");
		estudiantes.addFirst(estudiante);

		System.out.println("Añade un estudiante en el index indicado");
		estudiantes.add(1,estudiante);

		System.out.println("Añade un estudiante en el principio de la lista");
		estudiantes.push(estudiante);

		System.out.println("Añade un estudiante en el principio de la lista");
		estudiantes.offerFirst(estudiante);

		System.out.println("Añade un estudiante en el final de la lista");
		estudiantes.offerLast(estudiante);

		System.out.println("Setea el valor de estidiante en el index inidcado");
		estudiantes.set(1, estudiante);

		System.out.println("Devuelve el elemento en el index indicado");
		estudiantes.get(3);

		System.out.println("Devuelve el elemento del principo de la lista isn eliminarlo");
		estudiantes.element();

		System.out.println("Devuelve el elemento del principo de la lista isn eliminarlo, devuelve null si esta vacia la lista");
		estudiantes.peekFirst();

		System.out.println("Devuelve el elemento del final de la lista isn eliminarlo, devuelve null si esta vacia la lista");
		estudiantes.peekLast();

		System.out.println("Elimina el primer elemento de la lista");
		estudiantes.remove();

		System.out.println("Elimina el primer elemento de la lista");
		estudiantes.removeFirst();

		System.out.println("Elimina el ultimo elemento de la lista");
		estudiantes.removeLast();

		System.out.println("Devuelve el primer elemto de la lista");
		estudiantes.pop();

		System.out.println("Elimina el elemento del index indicado");
		estudiantes.remove(1);

		System.out.println("Devuelve el primer elemento de la lista, null si esta esta vacio");
		estudiantes.pollFirst();

		System.out.println("Devuelve el segon elemento de la lista, null si esta esta vacio");
		estudiantes.pollLast();
	}
}
