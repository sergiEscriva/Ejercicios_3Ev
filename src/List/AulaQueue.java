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

//TODO el fichero de los alumnos debe de ser csv y la primera linea era para el nombre de los campos
public class AulaQueue {
	private final static Logger LOGGER = LogManager.getLogger();
	static LinkedList<Estudiante> estudiantes = new LinkedList<>();
	static PriorityQueue<Estudiante> estudianteQueue = new PriorityQueue<>();
	static ArrayDeque<Estudiante> estudiantesDeque = new ArrayDeque<>();

	public static void main(String[] args) {
		creacionUsuarios();
		//mostrarEstudiantesQueue();
		mostrarEstudiantesDeque();
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
				anyadirListaPriorityQueue(estudiante);
				anyadirListaDeque(estudiante);


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
	public static void anyadirListaPriorityQueue(Estudiante estudiante){
		estudianteQueue.add(estudiante);
	}

	public static void anyadirListaDeque(Estudiante estudiante){
		estudiantesDeque.add(estudiante);
	}
	public static void mostrarEstudiantesQueue(){
		System.out.println(estudianteQueue.poll());
		System.out.println("----------------------------");
		Iterator<Estudiante> iterator = estudianteQueue.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());

		}

	}

	public static void mostrarEstudiantesDeque(){
		Iterator<Estudiante> iterator = estudiantesDeque.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}
}
