package comparadores;

import java.util.Comparator;

public class ComparadorEstudianteEdad implements Comparator<Estudiante> {

	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		int edad = o2.getFechaNacimiento().compareTo(o1.getFechaNacimiento());

		if (edad == 0){
			return o1.getNombre().compareTo(o2.getNombre());
		}
		return edad;

	}
}
